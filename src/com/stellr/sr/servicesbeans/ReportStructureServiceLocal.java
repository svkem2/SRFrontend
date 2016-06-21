package com.stellr.sr.servicesbeans;

import java.util.List;


import com.stellr.sr.domain.ReportStructure;
import javax.ejb.Local;

/* Report Structure Services Bean.
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-04-08
 */

@Local
public interface ReportStructureServiceLocal {
	public void createReportStructure(ReportStructure newReportStructure);

	public void updateReportStructure(ReportStructure reportStructure);

	public ReportStructure fetchReportStructurebyId(int reportStructureId);

	public List<ReportStructure> getAllReportStructure();
}
