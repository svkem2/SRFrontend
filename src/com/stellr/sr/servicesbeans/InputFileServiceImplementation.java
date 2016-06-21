/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stellr.sr.servicesbeans;

import com.stellr.sr.dataaccess.InputFileAccess;
import com.stellr.sr.domain.InputFile;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/* Input File Service Implementation
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-04-21
 */
@Stateless
public class InputFileServiceImplementation implements InputFileServiceLocal {
    
    @EJB
    InputFileAccess dao;

    @Override
    public void createNewInputFile(InputFile newInputFile) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateInputFile(InputFile inputFile) {
        dao.update(inputFile);
    }

    @Override
    public InputFile fetchInputFilebyId(int inputFileId) {
        return dao.findById(inputFileId);
    }

    @Override
    public List<InputFile> getAllInputFiles() {
        return dao.getAll();
    }
    
}
