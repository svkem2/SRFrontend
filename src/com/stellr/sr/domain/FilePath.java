package com.stellr.sr.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/* Entity Class File Path
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-04-08
 */
@Entity
@Table(name = "filepath")
public class FilePath implements java.io.Serializable {

    private static final long serialVersionUID = -2643514515470583679L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "filepathid")
    private int filePathId;

    @Column(name = "fpath")
    @NotNull(message = "Please enter a file path")
    @Length(min=1, max=255, message="Please enter a string pattern between 1 and 255 characters") 
    private String filePath;

    @Column(name = "pathtype")
    @NotNull(message = "Please enter a file path type")
    @Length(min=1, max=13, message="Please enter a string pattern between 1 and 13 characters") 
    private String pathType;

    @Column(name = "active")
    @NotNull (message = "Must be set to true or false")
    private boolean active;

    public FilePath() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.filePathId;
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
        final FilePath other = (FilePath) obj;
        if (this.filePathId != other.filePathId) {
            return false;
        }
        return true;
    }

    public int getFilePathId() {
        return filePathId;
    }

    public void setFilePathId(int filePathId) {
        this.filePathId = filePathId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getPathType() {
        return pathType;
    }

    public void setPathType(String pathType) {
        this.pathType = pathType;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
