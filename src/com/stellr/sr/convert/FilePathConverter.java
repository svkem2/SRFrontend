/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stellr.sr.convert;

import com.stellr.sr.domain.FilePath;
import com.stellr.sr.servicesbeans.FilePathServiceImplementation;
import com.stellr.sr.servicesbeans.FilePathServiceLocal;
import java.util.logging.Logger;
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
@FacesConverter(forClass = FilePath.class, value = "filePathConverter")
public class FilePathConverter implements Converter {

    private static final Logger Log = Logger.getLogger(FilePathConverter.class.getName());

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && value.trim().length() > 0) {
            try {
                FilePathServiceLocal service = EJB.lookup(FilePathServiceImplementation.class);
                return service.fetchFilePathbyId(Integer.parseInt(value));
            } catch (NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please select a valid File Path", "Not a valid file path."));
            }
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return String.valueOf(((FilePath) value).getFilePathId());
        } else {
            return null;
        }
    }

}
