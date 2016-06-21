package com.stellr.sr.servicesbeans;

import java.util.List;


import com.stellr.sr.domain.ReportSection;
import javax.ejb.Local;

/* Report Section Services Bean.
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-04-08
 */

@Local
public interface ReportSectionServiceLocal {
	public void createReportSection(ReportSection newReportSection);

	public void updateReportSection(ReportSection reportSection);

	public ReportSection fetchReportSectionbyId(int reportSectionId);

	public List<ReportSection> getAllReportSection();
}
