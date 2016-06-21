/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stellr.sr.convert;

import com.stellr.sr.domain.InputFile;
import com.stellr.sr.servicesbeans.InputFileSchemaServiceImplementation;
import com.stellr.sr.servicesbeans.InputFileServiceImplementation;
import com.stellr.sr.servicesbeans.InputFileServiceLocal;
import com.stellr.sr.util.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author stu
 */
@FacesConverter(forClass = InputFile.class, value = "inputFileConverter")
public class InputFileConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
         if (value != null && value.trim().length() > 0) {
            try {
                InputFileServiceLocal service = EJB.lookup(InputFileServiceImplementation.class);
                return service.fetchInputFilebyId(Integer.parseInt(value));
            } catch (NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please select a valid input file ", "Not a valid input file."));
            }
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return String.valueOf(((InputFile) value).getInputFileId());
        } else {
            return null;
        }
    }
    
}
