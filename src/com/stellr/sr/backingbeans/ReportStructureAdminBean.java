/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stellr.sr.backingbeans;

import com.stellr.sr.domain.ReportStructure;
import com.stellr.sr.servicesbeans.ReportStructureServiceLocal;
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

/* Backing bean for displaying all report structure
 * in a data table and display CRUD options
 * 
 * @author Stuart Kemp
 * @version 1.0
 */
@Named("reportStructureAdminBean")
@SessionScoped
public class ReportStructureAdminBean implements Serializable {
    //Report Structure CRUD Services Bean
    @EJB
    ReportStructureServiceLocal reportStructureService;
    
    List<ReportStructure> allReportStructure;
    
    ReportStructure selectedReportStructure;
    
    //hold filtered results for datatable
    List<ReportStructure> filterList;

    //use post construct to contain single database calls
    //getter called by jsf too often
    @PostConstruct
    public void init() {
        refreshData();
    }
    
    public void refreshData() {
        this.allReportStructure = fetchAllReportStructure();
    }
    
    /* METHODS */
    //FETCH ALL CALLS
    private List<ReportStructure> fetchAllReportStructure() {
        return this.reportStructureService.getAllReportStructure();
    }
    
    public void deactivateEntry(Boolean isActive, ReportStructure report) {
        report.setActive(isActive);
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            this.reportStructureService.updateReportStructure(report);
            context.addMessage(null, new FacesMessage("Successfully Saved!"));

        } catch (Exception ex) {
            Logger log = Logger.getLogger("viewLogger");
            log.log(Level.WARNING, "update report structure exception: {0}", ex.getMessage());
            context.addMessage(null, new FacesMessage("Error saving report structure, contact Administrator."));
        } finally {
            refreshData();
        }
        
        
    }
    
    /* ACTION LISTENERS */
    public void newEntryAction() {
        this.selectedReportStructure = new ReportStructure();
        this.selectedReportStructure.setActive(true);
    }
    
    public void saveEntryAction(ActionEvent actionEvent) {
        updateReportStructure();
    }
    
     /* CRUD METHODS */
    //update dirty object
    public String updateReportStructure() {
        //validation performed on entity bean - sufficient?
        ReportStructure thisReport = new ReportStructure();
        
        thisReport.setActive(this.selectedReportStructure.isActive());
        thisReport.setReportFilename(this.selectedReportStructure.getReportFilename());
        thisReport.setReportGroups(this.selectedReportStructure.getReportGroups());
        thisReport.setReportStructureId(this.selectedReportStructure.getReportStructureId());
        thisReport.setSrMailGroupId(this.selectedReportStructure.getSrMailGroupId());

        FacesContext context = FacesContext.getCurrentInstance();

        try {
            this.reportStructureService.updateReportStructure(thisReport);
            context.addMessage(null, new FacesMessage("Successfully Saved!"));
            RequestContext pfcontext = RequestContext.getCurrentInstance();
            pfcontext.execute("PF('createEditReportStructureModal').hide()");
            pfcontext.update("dataForm");
            return "success";

        } catch (Exception ex) {
            Logger log = Logger.getLogger("viewLogger");
            log.log(Level.WARNING, "update report structure exception: {0}", ex.getMessage());
            context.addMessage(null, new FacesMessage("Error saving report structure please contact Administrator."));
        } finally {
            refreshData();
        }
        return "fail";
    }
    
    /* GETTER AND SETTERS */

    public ReportStructureServiceLocal getReportStructureService() {
        return reportStructureService;
    }

    public void setReportStructureService(ReportStructureServiceLocal reportStructureService) {
        this.reportStructureService = reportStructureService;
    }

    public List<ReportStructure> getAllReportStructure() {
        return allReportStructure;
    }

    public void setAllReportStructure(List<ReportStructure> allReportStructure) {
        this.allReportStructure = allReportStructure;
    }

    public ReportStructure getSelectedReportStructure() {
        return selectedReportStructure;
    }

    public void setSelectedReportStructure(ReportStructure selectedReportStructure) {
        this.selectedReportStructure = selectedReportStructure;
    }

    public List<ReportStructure> getFilterList() {
        return filterList;
    }

    public void setFilterList(List<ReportStructure> filterList) {
        this.filterList = filterList;
    }
    
}
