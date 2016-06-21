/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stellr.sr.backingbeans;

import com.stellr.sr.domain.FieldFunction;
import com.stellr.sr.servicesbeans.FieldFunctionServiceLocal;
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

/* Backing bean for displaying all field functions
 * in a data table and display CRUD options
 * 
 * @author Stuart Kemp
 * @version 1.0
 */
@Named("fieldFunctionAdminBean")
@SessionScoped
public class FieldFunctionAdminBean implements Serializable {
     //Input File CRUD Services Bean
    @EJB
    FieldFunctionServiceLocal fieldFunctionService;
    
    List<FieldFunction> allFieldFunction;
    
    FieldFunction selectedFieldFunction;
    
    //hold filtered results for datatable
    List<FieldFunction> filterList;

    //use post construct to contain single database calls
    //getter called by jsf too often
    @PostConstruct
    public void init() {
        refreshData();
    }
    
    public void refreshData() {
        allFieldFunction = fetchAllFieldFunction();
    }
    
    /* METHODS */
    //FETCH ALL CALLS
    private List<FieldFunction> fetchAllFieldFunction() {
        return fieldFunctionService.getAllFieldFunction();
    }
    
    public void deactivateEntry(Boolean isActive, FieldFunction field) {
        field.setActive(isActive);
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            this.fieldFunctionService.updateFieldFunction(field);
            context.addMessage(null, new FacesMessage("Successfully Saved!"));

        } catch (Exception ex) {
            Logger log = Logger.getLogger("viewLogger");
            log.log(Level.WARNING, "update field function exception: {0}", ex.getMessage());
            context.addMessage(null, new FacesMessage("Error saving field function please contact Administrator."));
        } finally {
            refreshData();
        }
        
        
    }
    
    /* ACTION LISTENERS */
    public void newEntryAction() {
        selectedFieldFunction = new FieldFunction();
        selectedFieldFunction.setActive(true);
    }
    
    public void saveEntryAction(ActionEvent actionEvent) {
        updateFieldFunction();
    }
    
     /* CRUD METHODS */
    //update dirty input file
    public String updateFieldFunction() {
        //validation performed on entity bean - sufficient?
        FieldFunction field = new FieldFunction();
        field.setFieldFunctionId(this.selectedFieldFunction.getFieldFunctionId());
        field.setActive(this.selectedFieldFunction.isActive());
        field.setFunctionArgType(this.selectedFieldFunction.getFunctionArgType());
        field.setFunctionName(this.selectedFieldFunction.getFunctionName());
        field.setFunctionRetType(this.selectedFieldFunction.getFunctionRetType());
        
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            this.fieldFunctionService.updateFieldFunction(field);
            context.addMessage(null, new FacesMessage("Successfully Saved!"));
            RequestContext pfcontext = RequestContext.getCurrentInstance();
            pfcontext.execute("PF('createEditFieldFunctionModal').hide()");
            pfcontext.update("dataForm");
            return "success";

        } catch (Exception ex) {
            Logger log = Logger.getLogger("viewLogger");
            log.log(Level.WARNING, "update field function exception: {0}", ex.getMessage());
            context.addMessage(null, new FacesMessage("Error saving field function please contact Administrator."));
        } finally {
            refreshData();
        }
        return "fail";
    }
    
    /* GETTERS AND SETTERS */

    public FieldFunctionServiceLocal getFieldFunctionService() {
        return fieldFunctionService;
    }

    public void setFieldFunctionService(FieldFunctionServiceLocal fieldFunctionService) {
        this.fieldFunctionService = fieldFunctionService;
    }

    public List<FieldFunction> getAllFieldFunction() {
        return allFieldFunction;
    }

    public void setAllFieldFunction(List<FieldFunction> allFieldFunction) {
        this.allFieldFunction = allFieldFunction;
    }

    public FieldFunction getSelectedFieldFunction() {
        return selectedFieldFunction;
    }

    public void setSelectedFieldFunction(FieldFunction selectedFieldFunction) {
        this.selectedFieldFunction = selectedFieldFunction;
    }

    public List<FieldFunction> getFilterList() {
        return filterList;
    }

    public void setFilterList(List<FieldFunction> filterList) {
        this.filterList = filterList;
    }
    

}
