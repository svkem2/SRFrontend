package com.stellr.sr.dataaccess;

import java.util.List;

import com.stellr.sr.domain.ReportStructure;

/* Report Structure CRUD Operations
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-04-08
 */
public interface ReportStructureAccess {
	public abstract void insert(ReportStructure newReportStructure);

	public abstract void update(ReportStructure ReportStructure);

	public abstract ReportStructure findById(int ReportStructureId);

	public abstract List<ReportStructure> getAll();
}
