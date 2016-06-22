/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stellr.sr.servicesbeans;

import com.stellr.sr.dataaccess.ReportSectionContentAccess;
import com.stellr.sr.domain.ReportSectionContent;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/* Report Section Content Services Implementation
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-04-21
 */
@Stateless
@RolesAllowed("StellrAdminGroup")
public class ReportSectionContentServiceImplementation implements ReportSectionContentServiceLocal {

    @EJB
    ReportSectionContentAccess dao;
    
    @Override
    public void createReportSectionContent(ReportSectionContent newReportSectionContent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateReportSectionContent(ReportSectionContent reportSectionContent) {
        dao.update(reportSectionContent);
    }

    @Override
    public ReportSectionContent fetchReportSectionContentbyId(int reportSectionContentId) {
        return dao.findById(reportSectionContentId);
    }

    @Override
    public List<ReportSectionContent> getAllReportSectionContent() {
        return dao.getAll();
    }
    
}
