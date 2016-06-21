package com.stellr.sr.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/* Entity Class Report Structure
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-04-08
 */
@Entity
@Table(name = "reportstructure")
public class ReportStructure implements java.io.Serializable {

    private static final long serialVersionUID = -5700768781565576681L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reportstructureid")
    private int reportStructureId;

    @Column(name = "reportfilename")
    private String reportFilename;

    @Column(name = "reportgroups")
    private String reportGroups;

    @Column(name = "active")
    private boolean active;

    public ReportStructure() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.reportStructureId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ReportStructure other = (ReportStructure) obj;
        if (this.reportStructureId != other.reportStructureId) {
            return false;
        }
        return true;
    }

    public int getReportStructureId() {
        return reportStructureId;
    }

    public void setReportStructureId(int reportStructureId) {
        this.reportStructureId = reportStructureId;
    }

    public String getReportFilename() {
        return reportFilename;
    }

    public void setReportFilename(String reportFilename) {
        this.reportFilename = reportFilename;
    }

    public String getReportGroups() {
        return reportGroups;
    }

    public void setReportGroups(String reportGroups) {
        this.reportGroups = reportGroups;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
