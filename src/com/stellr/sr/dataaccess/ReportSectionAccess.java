package com.stellr.sr.dataaccess;

import java.util.List;

import com.stellr.sr.domain.ReportSection;

/* Report Section CRUD Operations
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-04-08
 */
public interface ReportSectionAccess {
	public abstract void insert(ReportSection newReportSection);

	public abstract void update(ReportSection reportSection);

	public abstract ReportSection findById(int reportSectionId);

	public abstract List<ReportSection> getAll();
}
