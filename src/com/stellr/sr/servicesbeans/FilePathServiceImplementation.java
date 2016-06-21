/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stellr.sr.servicesbeans;

import com.stellr.sr.dataaccess.FilePathAccess;
import com.stellr.sr.domain.FilePath;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/* File path services implementation
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-04-21
 */
@Stateless
@RolesAllowed("StellrAdminGroup")
public class FilePathServiceImplementation implements FilePathServiceLocal {
    
    @EJB
    FilePathAccess dao;
    
    @Override
    public void createFilePath(FilePath newFilePath) {
        dao.insert(newFilePath);
    }
    
    @Override
    public void updateFilePath(FilePath FilePath) {
        dao.update(FilePath);
    }
    
    @Override
    public FilePath fetchFilePathbyId(int FilePathId) {
        return dao.findById(FilePathId);
    }
    
    @Override
    public List<FilePath> getAllFilePath() {
        return dao.getAll();
    }
    
}
