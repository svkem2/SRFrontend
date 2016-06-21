package com.stellr.sr.backingbeans;

import com.stellr.sr.domain.FileCompareGroup;
import com.stellr.sr.domain.InputFile;
import com.stellr.sr.servicesbeans.FileCompareGroupServiceLocal;
import com.stellr.sr.servicesbeans.InputFileServiceLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

/* Backing bean for displaying all file compare groups
 * in a data table and display CRUD options
 * 
 * @author Stuart Kemp
 * @version 1.0
 */
@Named("fileCompareAdminBean")
@SessionScoped
public class FileCompareAdminBean implements Serializable {
    //Input File CRUD Services Bean
    @EJB
    FileCompareGroupServiceLocal fileCompareGroupService;
    
    List<FileCompareGroup> allFileCompareGroup;
    
    FileCompareGroup selectedFileCompareGroup;
    
    Map<Integer, String> inputFileIdtoNameFormatMap;
    
    //hold filtered results for datatable
    List<FileCompareGroup> filterList;
    
    //Input File CRUD Services Bean
    @EJB
    InputFileServiceLocal inputFileService;
    List<InputFile> allInputFiles;

    //use post construct to contain single database calls
    //getter called by jsf too often
    @PostConstruct
    public void init() {
        refreshData();
    }
    
    public void refreshData() {
        allFileCompareGroup = fetchAllFileCompareGroup();
        allInputFiles = fetchAllInputFiles();
        //avoid null pointer exception
        selectedFileCompareGroup = allFileCompareGroup.get(0);
        //populate id to name format map
        inputFileIdtoNameFormatMap = new HashMap<>();
        for(InputFile file : allInputFiles){
            inputFileIdtoNameFormatMap.put(file.getInputFileId(), file.getNameFormat());
        }
    }
    
    /* METHODS */
    //FETCH ALL CALLS
    private List<FileCompareGroup> fetchAllFileCompareGroup() {
        return fileCompareGroupService.getAllFileCompareGroup();
    }
    
    private List<InputFile> fetchAllInputFiles() {
        return inputFileService.getAllInputFiles();
    }
    
    public void deactivateEntry(Boolean isActive, FileCompareGroup group) {
        group.setActive(isActive);
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            this.fileCompareGroupService.updateFileCompareGroup(group);
            context.addMessage(null, new FacesMessage("Successfully Saved!"));

        } catch (Exception ex) {
            Logger log = Logger.getLogger("viewLogger");
            log.log(Level.WARNING, "update file compare group exception: {0}", ex.getMessage());
            context.addMessage(null, new FacesMessage("Error saving file compare group please contact Administrator."));
        } finally {
            refreshData();
        }
        
        
    }
    
    /* ACTION LISTENERS */
    public void newEntryAction() {
        this.selectedFileCompareGroup = new FileCompareGroup();
        //avoid null pointer exception in selectonemenu
        this.selectedFileCompareGroup.setFileCompareList(new ArrayList<String>());
        this.selectedFileCompareGroup.getFileCompareList().add("");
        this.selectedFileCompareGroup.getFileCompareList().add("1");
        this.selectedFileCompareGroup.getFileCompareList().add("2");  
        //default active true
        this.selectedFileCompareGroup.setActive(true);
    }
    
    public void saveEntryAction(ActionEvent actionEvent) {
        updateFileCompareGroup();
    }
    
     /* CRUD METHODS */
    //update dirty input file
    public String updateFileCompareGroup() {
        //validation performed on entity bean - sufficient?
        FileCompareGroup thisGroup = new FileCompareGroup();
        
        thisGroup.setActive(this.selectedFileCompareGroup.isActive());
        thisGroup.setFileCompareId(this.selectedFileCompareGroup.getFileCompareId());
        thisGroup.setFileCompareList(this.selectedFileCompareGroup.getFileCompareList());
        thisGroup.setGroupName(this.selectedFileCompareGroup.getGroupName());
        
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            this.fileCompareGroupService.updateFileCompareGroup(thisGroup);
            context.addMessage(null, new FacesMessage("Successfully Saved!"));
            RequestContext pfcontext = RequestContext.getCurrentInstance();
            pfcontext.execute("PF('createEditFileCompareGroupModal').hide()");
            pfcontext.update("dataForm");
            return "success";

        } catch (Exception ex) {
            Logger log = Logger.getLogger("viewLogger");
            log.log(Level.WARNING, "update file compare group exception: {0}", ex.getMessage());
            context.addMessage(null, new FacesMessage("Error saving file compare group please contact Administrator."));
        } finally {
            refreshData();
        }
        return "fail";
    }
    
    /* GETTERS AND SETTERS */

    public FileCompareGroupServiceLocal getFileCompareGroupService() {
        return fileCompareGroupService;
    }

    public void setFileCompareGroupService(FileCompareGroupServiceLocal fileCompareGroupService) {
        this.fileCompareGroupService = fileCompareGroupService;
    }

    public List<FileCompareGroup> getAllFileCompareGroup() {
        return allFileCompareGroup;
    }

    public void setAllFileCompareGroup(List<FileCompareGroup> allFileCompareGroup) {
        this.allFileCompareGroup = allFileCompareGroup;
    }

    public FileCompareGroup getSelectedFileCompareGroup() {
        return selectedFileCompareGroup;
    }

    public void setSelectedFileCompareGroup(FileCompareGroup selectedFileCompareGroup) {
        this.selectedFileCompareGroup = selectedFileCompareGroup;
    }

    public List<FileCompareGroup> getFilterList() {
        return filterList;
    }

    public void setFilterList(List<FileCompareGroup> filterList) {
        this.filterList = filterList;
    }

    public List<InputFile> getAllInputFiles() {
        return allInputFiles;
    }

    public void setAllInputFiles(List<InputFile> allInputFiles) {
        this.allInputFiles = allInputFiles;
    }

    public Map<Integer, String> getInputFileIdtoNameFormatMap() {
        return inputFileIdtoNameFormatMap;
    }

    public void setInputFileIdtoNameFormatMap(Map<Integer, String> inputFileIdtoNameFormatMap) {
        this.inputFileIdtoNameFormatMap = inputFileIdtoNameFormatMap;
    }
    
}

   