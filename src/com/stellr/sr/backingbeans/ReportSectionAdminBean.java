/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stellr.sr.backingbeans;

import com.stellr.sr.domain.ReportSection;
import com.stellr.sr.servicesbeans.ReportSectionServiceLocal;
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

/* Backing bean for displaying all report section
 * in a data table and display CRUD options
 * 
 * @author Stuart Kemp
 * @version 1.0
 */
@Named("reportSectionAdminBean")
@SessionScoped
public class ReportSectionAdminBean implements Serializable {
    //Input File CRUD Services Bean
    @EJB
    ReportSectionServiceLocal reportSectionService;
    
    List<ReportSection> allReportSection;
    
    ReportSection selectedReportSection;
    
    //hold filtered results for datatable
    List<ReportSection> filterList;

    //use post construct to contain single database calls
    //getter called by jsf too often
    @PostConstruct
    public void init() {
        refreshData();
    }
    
    public void refreshData() {
        allReportSection = fetchAllReportSection();
    }
    
    /* METHODS */
    //FETCH ALL CALLS
    private List<ReportSection> fetchAllReportSection() {
        return reportSectionService.getAllReportSection();
    }
    
    public void deactivateEntry(Boolean isActive, ReportSection report) {
        report.setActive(isActive);
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            this.reportSectionService.updateReportSection(report);
            context.addMessage(null, new FacesMessage("Successfully Saved!"));

        } catch (Exception ex) {
            Logger log = Logger.getLogger("viewLogger");
            log.log(Level.WARNING, "update report section exception: {0}", ex.getMessage());
            context.addMessage(null, new FacesMessage("Error saving report section contact Administrator."));
        } finally {
            refreshData();
        }
        
        
    }
    
    /* ACTION LISTENERS */
    public void newEntryAction() {
        this.selectedReportSection = new ReportSection();
        this.selectedReportSection.setActive(true);
    }
    
    public void saveEntryAction(ActionEvent actionEvent) {
        updateReportSection();
    }
    
     /* CRUD METHODS */
    //update dirty input file
    public String updateReportSection() {
        //validation performed on entity bean - sufficient?
        ReportSection thisReport = new ReportSection();
        
        thisReport.setActive(this.selectedReportSection.isActive());
        thisReport.setReportSectionId(this.selectedReportSection.getReportSectionId());
        thisReport.setSectionHeading(this.selectedReportSection.getSectionHeading());
        thisReport.setSectionPosition(this.selectedReportSection.getSectionPosition());
        thisReport.setSectionStructureId(this.selectedReportSection.getSectionStructureId());

        FacesContext context = FacesContext.getCurrentInstance();

        try {
            this.reportSectionService.updateReportSection(thisReport);
            context.addMessage(null, new FacesMessage("Successfully Saved!"));
            RequestContext pfcontext = RequestContext.getCurrentInstance();
            pfcontext.execute("PF('createEditReportSectionModal').hide()");
            pfcontext.update("dataForm");
            return "success";

        } catch (Exception ex) {
            Logger log = Logger.getLogger("viewLogger");
            log.log(Level.WARNING, "update report section exception: {0}", ex.getMessage());
            context.addMessage(null, new FacesMessage("Error saving report section please contact Administrator."));
        } finally {
            refreshData();
        }
        return "fail";
    }
    
    /* GETTERS AND SETTERS */

    public ReportSectionServiceLocal getReportSectionService() {
        return reportSectionService;
    }

    public void setReportSectionService(ReportSectionServiceLocal reportSectionService) {
        this.reportSectionService = reportSectionService;
    }

    public List<ReportSection> getAllReportSection() {
        return allReportSection;
    }

    public void setAllReportSection(List<ReportSection> allReportSection) {
        this.allReportSection = allReportSection;
    }

    public ReportSection getSelectedReportSection() {
        return selectedReportSection;
    }

    public void setSelectedReportSection(ReportSection selectedReportSection) {
        this.selectedReportSection = selectedReportSection;
    }

    public List<ReportSection> getFilterList() {
        return filterList;
    }

    public void setFilterList(List<ReportSection> filterList) {
        this.filterList = filterList;
    }
    
}
