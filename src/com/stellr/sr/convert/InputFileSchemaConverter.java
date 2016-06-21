/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stellr.sr.convert;

import com.stellr.sr.domain.InputFileSchema;
import com.stellr.sr.servicesbeans.InputFileSchemaServiceImplementation;
import com.stellr.sr.servicesbeans.InputFileSchemaServiceLocal;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.stellr.sr.util.EJB;

/**
 *
 * @author stu
 */
@FacesConverter(forClass = InputFileSchema.class, value = "inputFileSchemaConverter")
public class InputFileSchemaConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && value.trim().length() > 0) {
            try {
                InputFileSchemaServiceLocal service = EJB.lookup(InputFileSchemaServiceImplementation.class);
                return service.fetchInputFileSchemabyId(Integer.parseInt(value));
            } catch (NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please select a valid input file schema", "Not a valid schema."));
            }
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return String.valueOf(((InputFileSchema) value).getInputFileSchemaId());
        } else {
            return null;
        }
    }

}
