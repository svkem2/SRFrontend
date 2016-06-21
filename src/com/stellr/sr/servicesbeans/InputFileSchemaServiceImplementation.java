/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stellr.sr.servicesbeans;

import com.stellr.sr.dataaccess.InputFileSchemaAccess;
import com.stellr.sr.domain.InputFileSchema;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/* Input File Schema Services Implementation
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-04-21
 */
@Stateless
public class InputFileSchemaServiceImplementation implements InputFileSchemaServiceLocal {
    
    @EJB
    InputFileSchemaAccess dao;

    @Override
    public void createInputFileSchema(InputFileSchema newInputFileSchema) {
        dao.insert(newInputFileSchema);
    }

    @Override
    public void updateInputFileSchema(InputFileSchema inputFileSchema) {
        dao.update(inputFileSchema);
    }

    @Override
    public InputFileSchema fetchInputFileSchemabyId(int InputFileSchemaId) {
        return dao.findById(InputFileSchemaId);
    }

    @Override
    public List<InputFileSchema> getAllInputFileSchema() {
        return dao.getAll();
    }
    
}
