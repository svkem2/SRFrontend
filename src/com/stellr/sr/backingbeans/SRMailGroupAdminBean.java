/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stellr.sr.backingbeans;

import com.stellr.sr.domain.FilePath;
import com.stellr.sr.domain.SRMailGroup;
import com.stellr.sr.servicesbeans.FilePathServiceLocal;
import com.stellr.sr.servicesbeans.SRMailGroupServiceLocal;
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

/* Backing bean for displaying all file paths
 * in a data table and display CRUD options
 * 
 * @author Stuart Kemp
 * @version 1.0
 */
@Named("srMailGroupAdminBean")
@SessionScoped
public class SRMailGroupAdminBean implements Serializable {
    //Input File CRUD Services Bean
    @EJB
    SRMailGroupServiceLocal srMailGroupService;
    
    List<SRMailGroup> allSRMailGroups;
    
    SRMailGroup selectedSRMailGroup;
    
    //hold filtered results for datatable
    List<SRMailGroup> filterList;

    //use post construct to contain single database calls
    //getter called by jsf too often
    @PostConstruct
    public void init() {
        refreshData();
        selectedSRMailGroup = new SRMailGroup();
    }
    
    public void refreshData() {
        allSRMailGroups = fetchAllSRMailGroup();
        RequestContext pfcontext = RequestContext.getCurrentInstance();
        pfcontext.update("dataForm");
    }
    
    /* METHODS */
    //FETCH ALL CALLS
    private List<SRMailGroup> fetchAllSRMailGroup() {
        return srMailGroupService.getAllSRMailGroup();
    }
    
    public void deactivateEntry(Boolean isActive, SRMailGroup group) {
        group.setActive(isActive);
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            this.srMailGroupService.updateSRMailGroup(group);
            context.addMessage(null, new FacesMessage("Successfully Saved!"));

        } catch (Exception ex) {
            Logger log = Logger.getLogger("viewLogger");
            log.log(Level.WARNING, "update file exception: {0}", ex.getMessage());
            context.addMessage(null, new FacesMessage("Error saving SRT Mail Group please contact Administrator."));
        }
    }
    
    /* ACTION LISTENERS */
    public void newEntryAction() {
        selectedSRMailGroup = new SRMailGroup();
        selectedSRMailGroup.setActive(true);
    }
    
    public void saveEntryAction(ActionEvent actionEvent) {
        updateSRMailGroup();
    }
    
     /* CRUD METHODS */
    //update dirty input file
    public String updateSRMailGroup() {
        //validation performed on entity bean - sufficient?
        SRMailGroup thisGroup = new SRMailGroup();
        thisGroup.setSrMailGroupId(this.selectedSRMailGroup.getSrMailGroupId());
        thisGroup.setActive(this.selectedSRMailGroup.isActive());
        thisGroup.setSrMailCc(this.selectedSRMailGroup.getSrMailCc());
        thisGroup.setSrMailSendTo(this.selectedSRMailGroup.getSrMailSendTo());
        
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            this.srMailGroupService.updateSRMailGroup(thisGroup);
            context.addMessage(null, new FacesMessage("Successfully Saved!"));
            RequestContext pfcontext = RequestContext.getCurrentInstance();
            pfcontext.execute("PF('createEditSRMailGroupModal').hide()");
            pfcontext.update(":dataForm");
            return "success";

        } catch (Exception ex) {
            Logger log = Logger.getLogger("viewLogger");
            log.log(Level.WARNING, "update sr mail group exception: {0}", ex.getMessage());
            context.addMessage(null, new FacesMessage("Error saving sr mail group, please contact Administrator."));
        } finally {
            refreshData();
        }
        return "fail";
    }

   
    
    /* GETTERS AND SETTERS */

    public List<SRMailGroup> getAllSRMailGroups() {
        return allSRMailGroups;
    }

    public void setAllSRMailGroups(List<SRMailGroup> allSRMailGroups) {
        this.allSRMailGroups = allSRMailGroups;
    }

    public SRMailGroup getSelectedSRMailGroup() {
        return selectedSRMailGroup;
    }

    public void setSelectedSRMailGroup(SRMailGroup selectedSRMailGroup) {
        this.selectedSRMailGroup = selectedSRMailGroup;
    }

    public List<SRMailGroup> getFilterList() {
        return filterList;
    }

    public void setFilterList(List<SRMailGroup> filterList) {
        this.filterList = filterList;
    }
   
}
