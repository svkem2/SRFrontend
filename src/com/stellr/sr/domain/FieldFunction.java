package com.stellr.sr.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/* Entity Class Field Functions
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-04-08
 */
@Entity
@Table(name = "fieldfunction")
public class FieldFunction implements java.io.Serializable {

    private static final long serialVersionUID = 8940391392630954612L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "fieldfunctionid")
    private int fieldFunctionId;

    @Column(name = "functionname")
    private String functionName;

    @Column(name = "functionargtype")
    private String functionArgType;

    @Column(name = "functionrettype")
    private String functionRetType;

    public FieldFunction() {
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + this.fieldFunctionId;
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
        final FieldFunction other = (FieldFunction) obj;
        if (this.fieldFunctionId != other.fieldFunctionId) {
            return false;
        }
        return true;
    }

    public int getFieldFunctionId() {
        return fieldFunctionId;
    }

    public void setFieldFunctionId(int fieldFunctionId) {
        this.fieldFunctionId = fieldFunctionId;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getFunctionArgType() {
        return functionArgType;
    }

    public void setFunctionArgType(String functionArgType) {
        this.functionArgType = functionArgType;
    }

    public String getFunctionRetType() {
        return functionRetType;
    }

    public void setFunctionRetType(String functionRetType) {
        this.functionRetType = functionRetType;
    }

}
