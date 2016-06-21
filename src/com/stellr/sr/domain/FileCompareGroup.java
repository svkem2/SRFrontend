package com.stellr.sr.domain;

import com.stellr.sr.convert.StringListConverter;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/* Entity Class File Compare Groups
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-04-08
 */
@Entity
@Table(name = "filecomparegroup")
public class FileCompareGroup implements java.io.Serializable {

    private static final long serialVersionUID = -9159372386399109032L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "filecompareid")
    private int fileCompareId;

    @Column(name = "filecomparelist")
    @Convert(converter = StringListConverter.class)
    private List<String> fileCompareList;

    @Column(name = "groupname")
    private String groupName;

    @Column(name = "active")
    private boolean active;

    public FileCompareGroup() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.fileCompareId;
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
        final FileCompareGroup other = (FileCompareGroup) obj;
        if (this.fileCompareId != other.fileCompareId) {
            return false;
        }
        return true;
    }

    public int getFileCompareId() {
        return fileCompareId;
    }

    public void setFileCompareId(int fileCompareId) {
        this.fileCompareId = fileCompareId;
    }

    public List<String> getFileCompareList() {
        return fileCompareList;
    }

    public void setFileCompareList(List<String> fileCompareList) {
        this.fileCompareList = fileCompareList;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
