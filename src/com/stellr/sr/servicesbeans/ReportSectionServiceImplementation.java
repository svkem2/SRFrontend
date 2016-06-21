/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stellr.sr.servicesbeans;

import com.stellr.sr.domain.ReportSection;
import java.util.List;
import javax.ejb.Stateless;

/* Report section services implementation
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-04-21
 */
@Stateless
public class ReportSectionServiceImplementation implements ReportSectionServiceLocal {

    @Override
    public void createReportSection(ReportSection newReportSection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateReportSection(ReportSection reportSection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ReportSection fetchReportSectionbyId(int reportSectionId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ReportSection> getAllReportSection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
