package com.stellr.sr.dataaccess;

import java.util.List;

import com.stellr.sr.domain.ReportSectionContent;

/* Report Section Content CRUD Operations
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-04-08
 */
public interface ReportSectionContentAccess {
	public abstract void insert(ReportSectionContent newReportSectionContent);

	public abstract void update(ReportSectionContent reportSectionContent);

	public abstract ReportSectionContent findById(int reportSectionContentId);

	public abstract List<ReportSectionContent> getAll();
}
