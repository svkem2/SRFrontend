/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stellr.sr.backingbeans;

import com.stellr.sr.domain.FilePath;
import com.stellr.sr.servicesbeans.FilePathServiceLocal;
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
@Named("filePathAdminBean")
@SessionScoped
public class FilePathAdminBean implements Serializable {
    //Input File CRUD Services Bean
    @EJB
    FilePathServiceLocal filePathService;
    
    List<FilePath> allFilePaths;
    
    FilePath selectedFilePath;
    
    //hold filtered results for datatable
    List<FilePath> filterList;

    //use post construct to contain single database calls
    //getter called by jsf too often
    @PostConstruct
    public void init() {
        refreshData();
    }
    
    public void refreshData() {
        allFilePaths = fetchAllFilePath();
    }
    
    /* METHODS */
    //FETCH ALL CALLS
    private List<FilePath> fetchAllFilePath() {
        return filePathService.getAllFilePath();
    }
    
    public void deactivateEntry(Boolean isActive, FilePath path) {
        path.setActive(isActive);
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            this.filePathService.updateFilePath(path);
            context.addMessage(null, new FacesMessage("Successfully Saved!"));

        } catch (Exception ex) {
            Logger log = Logger.getLogger("viewLogger");
            log.log(Level.WARNING, "update file exception: {0}", ex.getMessage());
            context.addMessage(null, new FacesMessage("Error saving file please contact Administrator."));
        } finally {
            refreshData();
        }
        
        
    }
    
    /* ACTION LISTENERS */
    public void newEntryAction() {
        selectedFilePath = new FilePath();
    }
    
    public void saveEntryAction(ActionEvent actionEvent) {
        updateFilePath();
    }
    
     /* CRUD METHODS */
    //update dirty input file
    public String updateFilePath() {
        //validation performed on entity bean - sufficient?
        FilePath thisPath = new FilePath();

        thisPath.setFilePath(this.selectedFilePath.getFilePath());
        thisPath.setFilePathId(this.selectedFilePath.getFilePathId());
        thisPath.setPathType(this.selectedFilePath.getPathType());
        thisPath.setActive(true);

        FacesContext context = FacesContext.getCurrentInstance();

        try {
            this.filePathService.updateFilePath(thisPath);
            context.addMessage(null, new FacesMessage("Successfully Saved!"));
            RequestContext pfcontext = RequestContext.getCurrentInstance();
            pfcontext.execute("PF('createEditFilePathModal').hide()");
            pfcontext.update("dataForm");
            return "success";

        } catch (Exception ex) {
            Logger log = Logger.getLogger("viewLogger");
            log.log(Level.WARNING, "update file exception: {0}", ex.getMessage());
            context.addMessage(null, new FacesMessage("Error saving file path please contact Administrator."));
        } finally {
            refreshData();
        }
        return "fail";
    }

   
    
    /* GETTERS AND SETTERS */
    public List<FilePath> getAllFilePaths() {
        return allFilePaths;
    }

    public FilePath getSelectedFilePath() {
        return selectedFilePath;
    }

    public void setSelectedFilePath(FilePath selectedFilePath) {
        this.selectedFilePath = selectedFilePath;
    }

    public List<FilePath> getFilterList() {
        return filterList;
    }

    public void setFilterList(List<FilePath> filterList) {
        this.filterList = filterList;
    }
}
