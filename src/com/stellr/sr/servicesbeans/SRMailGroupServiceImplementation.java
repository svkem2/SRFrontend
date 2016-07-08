/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stellr.sr.servicesbeans;

import com.stellr.sr.dataaccess.SRMailGroupAccess;
import com.stellr.sr.domain.FilePath;
import com.stellr.sr.domain.SRMailGroup;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Stuart Kemp
 */
@Stateless
@RolesAllowed("StellrAdminGroup")
public class SRMailGroupServiceImplementation implements SRMailGroupServiceLocal {

    @EJB
    SRMailGroupAccess dao;

    @Override
    public void createSRMailGroup(SRMailGroup newGroup) {
        dao.insert(newGroup);
    }

    @Override
    public void updateSRMailGroup(SRMailGroup group) {
        dao.update(group);
    }

    @Override
    public SRMailGroup fetchSRMailGroupbyId(int groupId) {
        return dao.findById(groupId);
    }

    @Override
    public List<SRMailGroup> getAllSRMailGroup() {
        return dao.getAll();
    }

}
