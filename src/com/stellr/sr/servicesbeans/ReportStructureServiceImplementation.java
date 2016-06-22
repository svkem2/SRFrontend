/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stellr.sr.servicesbeans;

import com.stellr.sr.dataaccess.ReportStructureAccess;
import com.stellr.sr.domain.ReportStructure;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/* Report structure services implementation
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-04-21
 */
@Stateless
@RolesAllowed("StellrAdminGroup")
public class ReportStructureServiceImplementation implements ReportStructureServiceLocal {
    @EJB
    ReportStructureAccess dao;

    @Override
    public void createReportStructure(ReportStructure newReportStructure) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateReportStructure(ReportStructure reportStructure) {
        dao.update(reportStructure);
    }

    @Override
    public ReportStructure fetchReportStructurebyId(int reportStructureId) {
        return dao.findById(reportStructureId);
    }

    @Override
    public List<ReportStructure> getAllReportStructure() {
        return dao.getAll();
    }
    
}
