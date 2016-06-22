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

/* Entity Class Report Section Content
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-04-08
 */
@Entity
@Table(name = "reportsectioncontent")
public class ReportSectionContent implements java.io.Serializable {

    private static final long serialVersionUID = 724547407864916810L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sectioncontentid")
    private int sectionContentId;

    @Column(name = "reportsectionid")
    @NotNull(message = "Please enter a section structure id")
    @Digits(integer = 20, fraction = 0, message = "Incorrect report section content id, must be an integer")
    private int reportSectionId;

    @Column(name = "grouplist")
    @NotNull(message = "Please enter group list")
    @Length(min=1, max=64, message="Please enter a string pattern between 1 and 64 characters") 
    private String groupList;

    @Column(name = "filename")
    @NotNull(message = "Please enter a filename")
    @Length(min=1, max=96, message="Please enter a string pattern between 1 and 96 characters") 
    private String filename;

    @Column(name = "identifier")
    @NotNull(message = "Please enter a identifier")
    @Length(min=1, max=32, message="Please enter a string pattern between 1 and 32 characters") 
    private String identifier;
    
    @Column(name = "active")
    @NotNull (message = "Must be set to true or false")
    private boolean active;

    public ReportSectionContent() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.sectionContentId;
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
        final ReportSectionContent other = (ReportSectionContent) obj;
        if (this.sectionContentId != other.sectionContentId) {
            return false;
        }
        return true;
    }

    public int getSectionContentId() {
        return sectionContentId;
    }

    public void setSectionContentId(int sectionContentId) {
        this.sectionContentId = sectionContentId;
    }

    public int getReportSectionId() {
        return reportSectionId;
    }

    public void setReportSectionId(int reportSectionId) {
        this.reportSectionId = reportSectionId;
    }

    public String getGroupList() {
        return groupList;
    }

    public void setGroupList(String groupList) {
        this.groupList = groupList;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
