package com.stellr.sr.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/* Entity Class Concatenated File Groups
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-04-08
 */
@Entity
@Table(name = "concatenatefilegrp")
public class ConcatenateFileGroup implements java.io.Serializable {

    private static final long serialVersionUID = 2932863981493173555L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "concatenatefilegrp_id")
    private int concatenateFileGroupId;

    @Column(name = "description")
    @NotNull(message = "Please enter description")
    @Length(min=1, max=64, message="Please enter a string pattern between 1 and 64 characters") 
    private String description;

    @Column(name = "fileconcatlist")
    @NotNull(message = "Please enter concatenate file group/s.")
    @Length(min=1, max=64, message="Please enter a string pattern between 1 and 64 characters") 
    private String fileConcatList;
    
    @Column (name = "active")
    @NotNull (message = "Must be set to true or false")
    private boolean active;

    public ConcatenateFileGroup() {
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.concatenateFileGroupId;
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
        final ConcatenateFileGroup other = (ConcatenateFileGroup) obj;
        if (this.concatenateFileGroupId != other.concatenateFileGroupId) {
            return false;
        }
        return true;
    }

    public int getConcatenateFileGroupId() {
        return concatenateFileGroupId;
    }

    public void setConcatenateFileGroupId(int concatenateFileGroupId) {
        this.concatenateFileGroupId = concatenateFileGroupId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFileConcatList() {
        return fileConcatList;
    }

    public void setFileConcatList(String fileConcatList) {
        this.fileConcatList = fileConcatList;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
