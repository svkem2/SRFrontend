package com.stellr.sr.backingbeans;

import com.stellr.sr.domain.InputFileSchema;
import com.stellr.sr.servicesbeans.InputFileSchemaServiceLocal;
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

/* Backing bean for displaying all input file schemas
 * in a data table and display CRUD options
 * 
 * @author Stuart Kemp
 * @version 1.0
 */
@Named("inputFileSchemaAdminBean")
@SessionScoped
public class InputFileSchemaAdminBean implements Serializable {
    //Input File CRUD Services Bean
    @EJB
    InputFileSchemaServiceLocal inputFileSchemaService;
    
    List<InputFileSchema> allInputFileSchema;
    
    InputFileSchema selectedInputFileSchema;
    
    //hold filtered results for datatable
    List<InputFileSchema> filterList;

    //use post construct to contain single database calls
    //getter called by jsf too often
    @PostConstruct
    public void init() {
        refreshData();
    }
    
    public void refreshData() {
        allInputFileSchema = fetchAllInputFileSchema();
    }
    
    /* METHODS */
    //FETCH ALL CALLS
    private List<InputFileSchema> fetchAllInputFileSchema() {
        return inputFileSchemaService.getAllInputFileSchema();
    }
    
    public void deactivateEntry(Boolean isActive, InputFileSchema schema) {
        schema.setActive(isActive);
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            this.inputFileSchemaService.updateInputFileSchema(schema);
            context.addMessage(null, new FacesMessage("Successfully Saved!"));

        } catch (Exception ex) {
            Logger log = Logger.getLogger("viewLogger");
            log.log(Level.WARNING, "update input file schema exception: {0}", ex.getMessage());
            context.addMessage(null, new FacesMessage("Error saving input file schema please contact Administrator."));
        } finally {
            refreshData();
        }
        
        
    }
    
    /* ACTION LISTENERS */
    public void newEntryAction() {
        this.selectedInputFileSchema = new InputFileSchema();
    }
    
    public void saveEntryAction(ActionEvent actionEvent) {
        updateInputFileSchema();
    }
    
     /* CRUD METHODS */
    //update dirty input file
    public String updateInputFileSchema() {
        //validation performed on entity bean - sufficient?
        InputFileSchema thisSchema = new InputFileSchema();

        thisSchema.setActive(this.selectedInputFileSchema.isActive());
        thisSchema.setDescription(this.selectedInputFileSchema.getDescription());
        thisSchema.setDetailDelimiter(this.selectedInputFileSchema.getDetailDelimiter());
        thisSchema.setFieldExtract(this.selectedInputFileSchema.getFieldExtract());
        thisSchema.setFieldFluff(this.selectedInputFileSchema.getFieldFluff());
        thisSchema.setFieldTransform(this.selectedInputFileSchema.getFieldTransform());
        thisSchema.setFieldMatch(this.selectedInputFileSchema.getFieldMatch());
        thisSchema.setFooterDelimiter(this.selectedInputFileSchema.getFooterDelimiter());
        thisSchema.setFooterFluff(this.selectedInputFileSchema.getFooterFluff());
        thisSchema.setFooterStart(this.selectedInputFileSchema.getFooterStart());
        thisSchema.setGotFooter(this.selectedInputFileSchema.isGotHeader());
        thisSchema.setGotHeader(this.selectedInputFileSchema.isGotHeader());
        thisSchema.setGotSkipRows(this.selectedInputFileSchema.isGotSkipRows());
        thisSchema.setHeaderDelimiter(this.selectedInputFileSchema.getHeaderDelimiter());
        thisSchema.setHeaderFluff(this.selectedInputFileSchema.getHeaderFluff());
        thisSchema.setHeaderStart(this.selectedInputFileSchema.getHeaderStart());
        thisSchema.setInputFileSchemaId(this.selectedInputFileSchema.getInputFileSchemaId());
        thisSchema.setNumberDetailColumns(this.selectedInputFileSchema.getNumberDetailColumns());
        thisSchema.setNumberFooterColumns(this.selectedInputFileSchema.getNumberFooterColumns());
        thisSchema.setNumberHeaderColumns(this.selectedInputFileSchema.getNumberHeaderColumns());
        thisSchema.setNumberSkipRowColumns(this.selectedInputFileSchema.getNumberSkipRowColumns());
        thisSchema.setSkipRowDelimiter(this.selectedInputFileSchema.getSkipRowDelimiter());
        thisSchema.setSkipStartingWith(this.selectedInputFileSchema.getSkipStartingWith());

        FacesContext context = FacesContext.getCurrentInstance();

        try {
            this.inputFileSchemaService.updateInputFileSchema(thisSchema);
            context.addMessage(null, new FacesMessage("Successfully Saved!"));
            RequestContext pfcontext = RequestContext.getCurrentInstance();
            pfcontext.execute("PF('createEditInputFileSchemaModal').hide()");
            pfcontext.update("dataForm");
            return "success";

        } catch (Exception ex) {
            Logger log = Logger.getLogger("viewLogger");
            log.log(Level.WARNING, "update input file schema exception: {0}", ex.getMessage());
            context.addMessage(null, new FacesMessage("Error saving input file schema please contact Administrator."));
        } finally {
            refreshData();
        }
        return "fail";
    }

    public InputFileSchemaServiceLocal getInputFileSchemaService() {
        return inputFileSchemaService;
    }

    public void setInputFileSchemaService(InputFileSchemaServiceLocal inputFileSchemaService) {
        this.inputFileSchemaService = inputFileSchemaService;
    }

    public List<InputFileSchema> getAllInputFileSchema() {
        return allInputFileSchema;
    }

    public void setAllInputFileSchema(List<InputFileSchema> allInputFileSchema) {
        this.allInputFileSchema = allInputFileSchema;
    }

    public InputFileSchema getSelectedInputFileSchema() {
        return selectedInputFileSchema;
    }

    public void setSelectedInputFileSchema(InputFileSchema selectedInputFileSchema) {
        this.selectedInputFileSchema = selectedInputFileSchema;
    }

    public List<InputFileSchema> getFilterList() {
        return filterList;
    }

    public void setFilterList(List<InputFileSchema> filterList) {
        this.filterList = filterList;
    }
    
    

}
