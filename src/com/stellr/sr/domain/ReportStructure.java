package com.stellr.sr.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

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
    @NotNull(message = "Please report filename")
    @Length(min=1, max=64, message="Please enter a string pattern between 1 and 64 characters") 
    private String reportFilename;

    @Column(name = "reportgroups")
    @NotNull(message = "Please enter report group list")
    @Length(min=1, max=64, message="Please enter a string pattern between 1 and 64 characters") 
    private String reportGroups;
    
    @Column(name = "srmailgroupid")
    @NotNull(message = "Please enter a report structure id")
    @Digits(integer = 20, fraction = 0, message = "Incorrect report section content id, must be an integer")
    private int srMailGroupId;

    @Column(name = "active")
    @NotNull (message = "Must be set to true or false")
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

    public int getSrMailGroupId() {
        return srMailGroupId;
    }

    public void setSrMailGroupId(int srMailGroupId) {
        this.srMailGroupId = srMailGroupId;
    }

}
