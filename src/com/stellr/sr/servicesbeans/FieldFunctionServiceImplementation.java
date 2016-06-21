/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stellr.sr.servicesbeans;

import com.stellr.sr.dataaccess.FieldFunctionAccess;
import com.stellr.sr.domain.FieldFunction;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/* Concatenate File Group CRUD Operations
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-04-21
 */
@Stateless
@RolesAllowed("StellrAdminGroup")
public class FieldFunctionServiceImplementation implements FieldFunctionServiceLocal {
    
    @EJB
    FieldFunctionAccess dao;
    
    @Override
    public void createFieldFunction(FieldFunction newFieldFunction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void updateFieldFunction(FieldFunction fieldFunction) {
        dao.update(fieldFunction);
    }
    
    @Override
    public FieldFunction fetchFieldFunctionbyId(int fieldFunctionId) {
        return dao.findById(fieldFunctionId);
    }
    
    @Override
    public List<FieldFunction> getAllFieldFunction() {
        return dao.getAll();
    }
    
}
