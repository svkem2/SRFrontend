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
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

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
    @NotNull(message = "Please enter a file compare list")
    @Length(min=1, max=16, message="Please enter a string pattern between 1 and 16 characters") 
    private List<String> fileCompareList;

    @Column(name = "groupname")
    @NotNull(message = "Please enter a group name")
    @Length(min=1, max=24, message="Please enter a string pattern between 1 and 24 characters") 
    private String groupName;

    @Column(name = "active")
    @NotNull (message = "Must be set to true or false")
    private boolean active;

    public FileCompareGroup() {
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

    @Override
    public int hashCode() {
        int hash = 5;
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
    
    

}
