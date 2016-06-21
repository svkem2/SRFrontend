/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stellr.sr.servicesbeans;

import com.stellr.sr.dataaccess.FileCompareGroupAccess;
import com.stellr.sr.domain.FileCompareGroup;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/* File compare group services implementation
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-04-21
 */
@Stateless
@RolesAllowed("StellrAdminGroup")
public class FileCompareGroupServiceImplementation implements FileCompareGroupServiceLocal {
    @EJB
    FileCompareGroupAccess dao;
    
    @Override
    public void createFileCompareGroup(FileCompareGroup newFileCompareGroup) {
        dao.insert(newFileCompareGroup);
    }

    @Override
    public void updateFileCompareGroup(FileCompareGroup FileCompareGroup) {
        dao.update(FileCompareGroup);
    }

    @Override
    public FileCompareGroup fetchFileCompareGroupbyId(int FileCompareGroupId) {
        return dao.findById(FileCompareGroupId);
    }

    @Override
    public List<FileCompareGroup> getAllFileCompareGroup() {
        return dao.getAll();
    }
    
}
