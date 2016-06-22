/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stellr.sr.backingbeans;

import com.stellr.sr.domain.ReportSectionContent;
import com.stellr.sr.servicesbeans.ReportSectionContentServiceLocal;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

/* Backing bean for displaying all report section content
 * in a data table and display CRUD options
 * 
 * @author Stuart Kemp
 * @version 1.0
 */
@Named("reportSectionContentAdminBean")
@SessionScoped
public class ReportSectionContentBean implements Serializable {
    //Report Section CRUD Services Bean
    @EJB
    ReportSectionContentServiceLocal reportSectionContentService;
    
    List<ReportSectionContent> allReportSectionContent;
    
    ReportSectionContent selectedReportSectionContent;
    
    //hold filtered results for datatable
    List<ReportSectionContent> filterList;

    //use post construct to contain single database calls
    //getter called by jsf too often
    @PostConstruct
    public void init() {
        refreshData();
    }
    
    public void refreshData() {
        allReportSectionContent = fetchAllReportSectionContent();
    }
    
    /* METHODS */
    //FETCH ALL CALLS
    private List<ReportSectionContent> fetchAllReportSectionContent() {
        return this.reportSectionContentService.getAllReportSectionContent();
    }
    
    public void deactivateEntry(Boolean isActive, ReportSectionContent report) {
        report.setActive(isActive);
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            this.reportSectionContentService.updateReportSectionContent(report);
            context.addMessage(null, new FacesMessage("Successfully Saved!"));

        } catch (Exception ex) {
            Logger log = Logger.getLogger("viewLogger");
            log.log(Level.WARNING, "update report section content exception: {0}", ex.getMessage());
            context.addMessage(null, new FacesMessage("Error saving report section content, contact Administrator."));
        } finally {
            refreshData();
        }
        
        
    }
    
    /* ACTION LISTENERS */
    public void newEntryAction() {
        this.selectedReportSectionContent = new ReportSectionContent();
        this.selectedReportSectionContent.setActive(true);
    }
    
    public void saveEntryAction(ActionEvent actionEvent) {
        updateReportSectionContent();
    }
    
     /* CRUD METHODS */
    //update dirty input file
    public String updateReportSectionContent() {
        //validation performed on entity bean - sufficient?
        ReportSectionContent thisReport = new ReportSectionContent();
        
        thisReport.setActive(this.selectedReportSectionContent.isActive());
        thisReport.setFilename(this.selectedReportSectionContent.getFilename());
        thisReport.setGroupList(this.selectedReportSectionContent.getGroupList());
        thisReport.setIdentifier(this.selectedReportSectionContent.getIdentifier());
        thisReport.setReportSectionId(this.selectedReportSectionContent.getReportSectionId());
        thisReport.setSectionContentId(this.selectedReportSectionContent.getSectionContentId());

        FacesContext context = FacesContext.getCurrentInstance();

        try {
            this.reportSectionContentService.updateReportSectionContent(thisReport);
            context.addMessage(null, new FacesMessage("Successfully Saved!"));
            RequestContext pfcontext = RequestContext.getCurrentInstance();
            pfcontext.execute("PF('createEditReportSectionContentModal').hide()");
            pfcontext.update("dataForm");
            return "success";

        } catch (Exception ex) {
            Logger log = Logger.getLogger("viewLogger");
            log.log(Level.WARNING, "update report section content exception: {0}", ex.getMessage());
            context.addMessage(null, new FacesMessage("Error saving report section content please contact Administrator."));
        } finally {
            refreshData();
        }
        return "fail";
    }
    
    /* GETTERS AND SETTERS */

    public ReportSectionContentServiceLocal getReportSectionContentService() {
        return reportSectionContentService;
    }

    public void setReportSectionContentService(ReportSectionContentServiceLocal reportSectionContentService) {
        this.reportSectionContentService = reportSectionContentService;
    }

    public List<ReportSectionContent> getAllReportSectionContent() {
        return allReportSectionContent;
    }

    public void setAllReportSectionContent(List<ReportSectionContent> allReportSectionContent) {
        this.allReportSectionContent = allReportSectionContent;
    }

    public ReportSectionContent getSelectedReportSectionContent() {
        return selectedReportSectionContent;
    }

    public void setSelectedReportSectionContent(ReportSectionContent selectedReportSectionContent) {
        this.selectedReportSectionContent = selectedReportSectionContent;
    }

    public List<ReportSectionContent> getFilterList() {
        return filterList;
    }

    public void setFilterList(List<ReportSectionContent> filterList) {
        this.filterList = filterList;
    }
    
}
