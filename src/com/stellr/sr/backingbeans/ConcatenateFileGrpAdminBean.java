package com.stellr.sr.backingbeans;

import com.stellr.sr.domain.ConcatenateFileGroup;
import java.util.List;

import javax.ejb.EJB;

import com.stellr.sr.servicesbeans.ConcatenateFileGroupServiceLocal;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

/* Backing bean for displaying concatenated file groups
 * in a data table and display CRUD options
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-04-08
 */
@Named("concateFileAdminBean")
@SessionScoped
public class ConcatenateFileGrpAdminBean implements Serializable {

    //Input File CRUD Services Bean
    @EJB
    ConcatenateFileGroupServiceLocal concatenateFileGroupService;

    //hold all input files and dependency lists from database
    List<ConcatenateFileGroup> allconcatenateFileGroups;
    
    //hold filtered results for datatable
    List<ConcatenateFileGroup> filterList;

    //selected input file and dependencies
    ConcatenateFileGroup selectedConcatenateFileGroup;

    public ConcatenateFileGrpAdminBean() {
    }

    //use post construct to contain single database calls
    @PostConstruct
    public void init() {
        refreshData();
        selectedConcatenateFileGroup = new ConcatenateFileGroup();
    }

    public void refreshData() {
        allconcatenateFileGroups = fetchAllConcatenateFileGroups();
    }

    /* METHODS */
    //FETCH ALL CALLS
    private List<ConcatenateFileGroup> fetchAllConcatenateFileGroups() {
        return concatenateFileGroupService.getAllConcatenateFileGroup();
    } 

    /* ACTION LISTNERS */
    public void saveEntryAction(ActionEvent actionEvent) {
        updateFileInput();
    }

    public void newEntryAction() {
        this.selectedConcatenateFileGroup = new ConcatenateFileGroup();
    }
    
    public void deactivateEntry(Boolean isActive, ConcatenateFileGroup group) {
        group.setActive(isActive);
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            this.concatenateFileGroupService.updateConcatenateFileGroup(group);
            context.addMessage(null, new FacesMessage("Successfully Saved!"));

        } catch (Exception ex) {
            Logger log = Logger.getLogger("viewLogger");
            log.log(Level.WARNING, "update file group exception: {0}", ex.getMessage());
            context.addMessage(null, new FacesMessage("Error saving file please contact Administrator."));
        } finally {
            refreshData();
        }
        
        
    }

    /* CRUD METHODS */
    //update dirty input file
    public String updateFileInput() {
        //validation performed on entity bean - sufficient?

        ConcatenateFileGroup thisGroup = new ConcatenateFileGroup();
        
        thisGroup.setActive(true);
        thisGroup.setDescription(this.selectedConcatenateFileGroup.getDescription());
        thisGroup.setFileConcatList(this.selectedConcatenateFileGroup.getFileConcatList());
        thisGroup.setConcatenateFileGroupId(this.selectedConcatenateFileGroup.getConcatenateFileGroupId());
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            this.concatenateFileGroupService.updateConcatenateFileGroup(thisGroup);
            context.addMessage(null, new FacesMessage("Successfully Saved!"));
            RequestContext pfcontext = RequestContext.getCurrentInstance();
            pfcontext.execute("PF('createEditConcatFileGrpModal').hide()");
            pfcontext.update("dataForm");
            return "success";

        } catch (Exception ex) {
            Logger log = Logger.getLogger("viewLogger");
            log.log(Level.WARNING, "update group exception: {0}", ex.getMessage());
            context.addMessage(null, new FacesMessage("Error saving file please contact Administrator."));
        } finally {
            refreshData();
        }
        return "fail";
    }

    /* GETTERS AND SETTERS */
    public List<ConcatenateFileGroup> getFilterList() {
        return filterList;
    }

    public void setFilterList(List<ConcatenateFileGroup> filterList) {
        this.filterList = filterList;
    }

    public ConcatenateFileGroup getSelectedConcatenateFileGroup() {
        return selectedConcatenateFileGroup;
    }

    public void setSelectedConcatenateFileGroup(ConcatenateFileGroup selectedConcatenateFileGroup) {
        this.selectedConcatenateFileGroup = selectedConcatenateFileGroup;
    }

    public List<ConcatenateFileGroup> getAllconcatenateFileGroups() {
        return allconcatenateFileGroups;
    }

    public void setAllconcatenateFileGroups(List<ConcatenateFileGroup> allconcatenateFileGroups) {
        this.allconcatenateFileGroups = allconcatenateFileGroups;
    }


}
