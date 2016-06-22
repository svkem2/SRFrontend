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

/* Entity Class Report Section
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-04-08
 */
@Entity
@Table(name = "reportsection")
public class ReportSection implements java.io.Serializable {

    private static final long serialVersionUID = -764520882771835173L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reportsectionid")
    private int reportSectionId;

    @Column(name = "reportstructureid")
    @NotNull(message = "Please enter a section structure id")
    @Digits(integer = 20, fraction = 0, message = "Incorrect section structure id, must be an integer")
    private int sectionStructureId;

    @Column(name = "sectionposition")
    @NotNull(message = "Please enter a section position")
    @Digits(integer = 6, fraction = 0, message = "Incorrect section position, must be an integer")
    private int sectionPosition;

    @Column(name = "sectionheading")
    @NotNull(message = "Please enter a section heading")
    @Length(min=1, max=64, message="Please enter a string pattern between 1 and 64 characters") 
    private String sectionHeading;

    @Column(name = "active")
    @NotNull (message = "Must be set to true or false")
    private boolean active;

    public ReportSection() {
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.reportSectionId;
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
        final ReportSection other = (ReportSection) obj;
        if (this.reportSectionId != other.reportSectionId) {
            return false;
        }
        return true;
    }

    public int getReportSectionId() {
        return reportSectionId;
    }

    public void setReportSectionId(int reportSectionId) {
        this.reportSectionId = reportSectionId;
    }

    public int getSectionStructureId() {
        return sectionStructureId;
    }

    public void setSectionStructureId(int sectionStructureId) {
        this.sectionStructureId = sectionStructureId;
    }

    public int getSectionPosition() {
        return sectionPosition;
    }

    public void setSectionPosition(int sectionPosition) {
        this.sectionPosition = sectionPosition;
    }

    public String getSectionHeading() {
        return sectionHeading;
    }

    public void setSectionHeading(String sectionHeading) {
        this.sectionHeading = sectionHeading;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
