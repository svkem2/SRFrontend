package com.stellr.sr.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/* Entity Class SR Mail Groups
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-07-07
 */
@Entity
@Table(name = "srmailgroup")
public class SRMailGroup implements java.io.Serializable {

    private static final long serialVersionUID = -2443514515470583679L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "srmailgroupid")
    private int srMailGroupId;

    @Column(name = "srmailsendto")
    @NotNull(message = "Please enter a send to email addresses")
    @Length(min=1, max=128, message="Please enter send to email addresses with string pattern between 1 and 128 characters") 
    private String srMailSendTo;

    @Column(name = "srmailcc")
    @Length(min=1, max=128, message="Please enter cc email addresses with string pattern between 1 and 128 characters") 
    private String srMailCc;

    @Column(name = "active")
    @NotNull (message = "Must be set to true or false")
    private boolean active;

    public SRMailGroup() {
    }

    public int getSrMailGroupId() {
        return srMailGroupId;
    }

    public void setSrMailGroupId(int srMailGroupId) {
        this.srMailGroupId = srMailGroupId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getSrMailSendTo() {
        return srMailSendTo;
    }

    public void setSrMailSendTo(String srMailSendTo) {
        this.srMailSendTo = srMailSendTo;
    }

    public String getSrMailCc() {
        return srMailCc;
    }

    public void setSrMailCc(String srMailCc) {
        this.srMailCc = srMailCc;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.srMailGroupId;
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
        final SRMailGroup other = (SRMailGroup) obj;
        if (this.srMailGroupId != other.srMailGroupId) {
            return false;
        }
        return true;
    }

    

}
