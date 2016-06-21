package com.stellr.sr.servicesbeans;

import java.util.List;


import com.stellr.sr.domain.ReportSectionContent;
import javax.ejb.Local;

/* Report Section Content Services Bean.
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-04-08
 */

@Local
public interface ReportSectionContentServiceLocal {
	public void createReportSectionContent(ReportSectionContent newReportSectionContent);

	public void updateReportSectionContent(ReportSectionContent reportSectionContent);

	public ReportSectionContent fetchReportSectionContentbyId(int reportSectionContentId);

	public List<ReportSectionContent> getAllReportSectionContent();
}
