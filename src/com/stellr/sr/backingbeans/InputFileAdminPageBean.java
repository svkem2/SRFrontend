package com.stellr.sr.backingbeans;

import com.stellr.sr.domain.ConcatenateFileGroup;
import com.stellr.sr.domain.FilePath;
import java.util.List;

import javax.ejb.EJB;

import com.stellr.sr.domain.InputFile;
import com.stellr.sr.domain.InputFileSchema;
import com.stellr.sr.servicesbeans.ConcatenateFileGroupServiceLocal;
import com.stellr.sr.servicesbeans.FilePathServiceLocal;
import com.stellr.sr.servicesbeans.InputFileSchemaServiceLocal;
import com.stellr.sr.servicesbeans.InputFileServiceLocal;
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

/* Backing bean for displaying all input files
 * in a data table and display CRUD options
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-04-08
 */
@Named("inputFileAdminBean")
@SessionScoped
public class InputFileAdminPageBean implements Serializable {

    //Input File CRUD Services Bean
    @EJB
    InputFileServiceLocal inputFileService;

    //File Path CRUD Services Bean
    @EJB
    FilePathServiceLocal filePathService;

    //File Schema CRUD Services
    @EJB
    InputFileSchemaServiceLocal inputFileSchemaService;

    //Concatenate File Group CRUD Services
    @EJB
    ConcatenateFileGroupServiceLocal concatenateFileGroupService;

    //hold all input files and dependency lists from database
    List<InputFile> allInputFiles;
    List<FilePath> allFilePaths;
    List<InputFileSchema> allInputFileSchemas;
    List<ConcatenateFileGroup> allConcatenateFileGroups;

    //hold filtered results for datatable
    List<InputFile> filterList;

    //selected input file and dependencies
    InputFile selectedInputFile;
    FilePath selectedFilePath;
    InputFileSchema selectedFileSchema;
    ConcatenateFileGroup selectedConcatFileGroup;

    public InputFileAdminPageBean() {
    }

    //use post construct to contain single database calls
    @PostConstruct
    public void init() {
        refreshData();
    }

    public void refreshData() {
        allInputFiles = fetchAllInputFiles();
        allFilePaths = fetchAllFilePaths();
        allInputFileSchemas = fetchAllInputFileSchemas();
        allConcatenateFileGroups = fetchAllConcatenateFileGroups();
        selectedFilePath = null;
        selectedFileSchema = null;
        selectedConcatFileGroup = null;
    }

    /* METHODS */
    //FETCH ALL CALLS
    private List<InputFile> fetchAllInputFiles() {
        return inputFileService.getAllInputFiles();
    }

    private List<FilePath> fetchAllFilePaths() {
        return filePathService.getAllFilePath();
    }

    private List<InputFileSchema> fetchAllInputFileSchemas() {
        return inputFileSchemaService.getAllInputFileSchema();
    }

    private List<ConcatenateFileGroup> fetchAllConcatenateFileGroups() {
        return concatenateFileGroupService.getAllConcatenateFileGroup();
    }

    /* FETCH DEPENDENCIES BY ID CALLS */
    public void setDependencies() {
        this.selectedFilePath = fetchFilePathById(this.selectedFilePath.getFilePathId());
        this.selectedFileSchema = fetchInputFileSchemaById(this.selectedFileSchema.getInputFileSchemaId());
        this.selectedConcatFileGroup = fetchConcatenateFileGroupById(this.selectedConcatFileGroup.getConcatenateFileGroupId());
    }

    public FilePath fetchFilePathById(int id) {
        return filePathService.fetchFilePathbyId(id);
    }

    public InputFileSchema fetchInputFileSchemaById(int id) {
        return inputFileSchemaService.fetchInputFileSchemabyId(id);
    }

    public ConcatenateFileGroup fetchConcatenateFileGroupById(int id) {
        return concatenateFileGroupService.fetchConcatenateFileGroupbyId(id);
    }

    /* ACTION LISTNERS */
    public void saveEntryAction(ActionEvent actionEvent) {
        updateFileInput();
    }

    public void newEntryAction() {
        this.selectedInputFile = new InputFile();
        this.selectedFilePath = null;
        this.selectedFileSchema = null;
        this.selectedConcatFileGroup = new ConcatenateFileGroup();
        refreshData();
    }
    
    public void deactivateEntry(Boolean isActive, InputFile file) {
        file.setActive(isActive);
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            this.inputFileService.updateInputFile(file);
            context.addMessage(null, new FacesMessage("Successfully Saved!"));

        } catch (Exception ex) {
            Logger log = Logger.getLogger("viewLogger");
            log.log(Level.WARNING, "update file exception: {0}", ex.getMessage());
            context.addMessage(null, new FacesMessage("Error saving file please contact Administrator."));
        } finally {
            refreshData();
        }
        
        
    }

    /* CRUD METHODS */
    //update dirty input file
    public String updateFileInput() {
        //validation performed on entity bean - sufficient?

        this.selectedInputFile.setConcatenateFileGrpId((this.selectedConcatFileGroup) == null ? 0 : this.selectedConcatFileGroup.getConcatenateFileGroupId());
        this.selectedInputFile.setFileSchemaId((this.selectedFileSchema) == null ? null : this.selectedFileSchema.getInputFileSchemaId());
        this.selectedInputFile.setInputFilePathId((this.selectedFilePath) == null ? null : this.selectedFilePath.getFilePathId());

        InputFile thisFile = new InputFile();

        thisFile.setInputFileId(this.selectedInputFile.getInputFileId());
        thisFile.setActive(this.selectedInputFile.isActive());
        thisFile.setConcatenateFileGrpId(this.selectedInputFile.getConcatenateFileGrpId());
        thisFile.setCountry(this.selectedInputFile.getCountry());
        thisFile.setDataSourceName(this.selectedInputFile.getDataSourceName());
        thisFile.setDataSourceType(this.selectedInputFile.getDataSourceType());
        thisFile.setDateModifier(this.selectedInputFile.getDateModifier());
        thisFile.setFileSchemaId(this.selectedInputFile.getFileSchemaId());
        thisFile.setFileSearchPattern(this.selectedInputFile.getFileSearchPattern());
        thisFile.setInputFilePathId(this.selectedInputFile.getInputFilePathId());
        thisFile.setNameFormat(this.selectedInputFile.getNameFormat());
        thisFile.setPendingCutOff(this.selectedInputFile.getPendingCutOff());
        thisFile.setTxnDateModifier(this.selectedInputFile.getTxnDateModifier());
        thisFile.setActive(this.selectedInputFile.isActive());

        FacesContext context = FacesContext.getCurrentInstance();

        try {
            this.inputFileService.updateInputFile(thisFile);
            context.addMessage(null, new FacesMessage("Successfully Saved!"));
            RequestContext pfcontext = RequestContext.getCurrentInstance();
            pfcontext.execute("PF('createEditInputFileModal').hide()");
            pfcontext.update("dataForm");
            return "success";

        } catch (Exception ex) {
            Logger log = Logger.getLogger("viewLogger");
            log.log(Level.WARNING, "update file exception: {0}", ex.getMessage());
            context.addMessage(null, new FacesMessage("Error saving file please contact Administrator."));
        } finally {
            refreshData();
        }
        return "fail";
    }

    /* GETTERS AND SETTERS */
    public List<InputFile> getAllInputFiles() {
        return this.allInputFiles;
    }

    public List<FilePath> getAllFilePaths() {
        return this.allFilePaths;
    }

    public List<InputFileSchema> getAllInputFileSchemas() {
        return this.allInputFileSchemas;
    }

    public List<ConcatenateFileGroup> getAllConcatenateFileGroups() {
        return this.allConcatenateFileGroups;
    }

    public InputFileServiceLocal getInputFileService() {
        return inputFileService;
    }

    public void setInputFileService(InputFileServiceLocal inputFileService) {
        this.inputFileService = inputFileService;
    }

    public List<InputFile> getFilterList() {
        return filterList;
    }

    public void setFilterList(List<InputFile> filterList) {
        this.filterList = filterList;
    }

    public InputFile getSelectedInputFile() {
        return selectedInputFile;
    }

    public void setSelectedInputFile(InputFile selectedInputFile) {
        this.selectedInputFile = selectedInputFile;
    }

    public FilePath getSelectedFilePath() {
        return selectedFilePath;
    }

    public void setSelectedFilePath(FilePath selectedFilePath) {
        this.selectedFilePath = selectedFilePath;
    }

    public InputFileSchema getSelectedFileSchema() {
        return selectedFileSchema;
    }

    public void setSelectedFileSchema(InputFileSchema selectedFileSchema) {
        this.selectedFileSchema = selectedFileSchema;
    }

    public ConcatenateFileGroup getSelectedConcatFileGroup() {
        return selectedConcatFileGroup;
    }

    public void setSelectedConcatFileGroup(ConcatenateFileGroup selectedConcatFileGroup) {
        this.selectedConcatFileGroup = selectedConcatFileGroup;
    }

}
