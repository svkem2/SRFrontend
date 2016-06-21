/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stellr.sr.servicesbeans;

import com.stellr.sr.dataaccess.ConcatenateFileGroupAccess;
import com.stellr.sr.domain.ConcatenateFileGroup;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/* Concatenate File Group CRUD Operations
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-04-21
 */
@Stateless
public class ConcatenateFileGroupServiceImplementation implements ConcatenateFileGroupServiceLocal {
    
    @EJB
    ConcatenateFileGroupAccess dao;

    @Override
    public void createConcatenateFileGroup(ConcatenateFileGroup newGroup) {
        dao.insert(newGroup);
    }

    @Override
    public void updateConcatenateFileGroup(ConcatenateFileGroup group) {
        dao.update(group);
    }

    @Override
    public ConcatenateFileGroup fetchConcatenateFileGroupbyId(int groupId) {
        return dao.findById(groupId);
    }

    @Override
    public List<ConcatenateFileGroup> getAllConcatenateFileGroup() {
        return dao.getAll();
    }
    
}
