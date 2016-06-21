package com.stellr.sr.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;

/* Entity Class Input File
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-04-08
 */
@Entity
@Table(name = "inputfile")
public class InputFile implements java.io.Serializable {

    private static final long serialVersionUID = 5183464288840298722L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "inputfileid")
    private int inputFileId;

    @Column(name = "nameformat")
    @NotNull(message = "Please enter name format")
    @Length(min=1, max=254, message="Please enter a string pattern between 1 and 255 characters") 
    private String nameFormat;

    @Column(name = "filesearchpattern")
    @NotNull(message = "Please enter file search pattern")
    @Length(min=1, max=254, message="Please enter a string pattern between 1 and 255 characters") 
    private String fileSearchPattern;

    @Column(name = "inputfilepath_id")
    @NotNull (message = "Please enter file path")
    @Digits(integer = 20, fraction = 0, message = "Incorrect file path id, must be an integer")
    private int inputFilePathId;

    @Column(name = "fileschema_id")
    @NotNull(message = "Please enter file schema")
    @Digits(integer = 20, fraction = 0, message = "Incorrect file schema id, must be an integer")
    private int fileSchemaId;

    @Column(name = "concatenatefilegrp_id")
    @NotNull(message = "Please enter concatenate file group")
    @Digits(integer = 20, fraction = 0, message = "Incorrect concatenate file group id, must be an integer")
    private int concatenateFileGrpId;

    @Column(name = "datemodifier")
    @NotNull(message = "Please enter date modifier")
    @Digits(integer = 6, fraction = 0, message = "Incorrect date modifier, must be an integer")
    private int dateModifier;

    @Column(name = "txndatemodifier")
    @NotNull(message = "Please enter txn date modifier")
    @Digits(integer = 6, fraction = 0, message = "Incorrect transaction date modifier, must be an integer")
    private int txnDateModifier;

    @Column(name = "pendingcutoff")
    @Length(min=0, max=6, message="Please enter a string pattern between 0 and 6 characters, default 000000 ") 
    private String pendingCutOff;

    @Column(name = "datasourcename")
    @NotNull(message = "Please enter data source name")
    @Length(min=0, max=32, message="Please enter a string pattern between 0 and 32 characters") 
    private String dataSourceName;

    @Column(name = "datasourcetype")
    @NotNull(message = "Please enter data source type")
    @Length(min=0, max=8, message="Please enter a string pattern between 0 and 8 characters, default HALO") 
    private String dataSourceType;

    @Column(name = "country")
    @NotNull(message = "Please enter country")
    @Length(min=0, max=4, message="Please enter a country prefix between 0 and 4 characters, default ZA") 
    private String country;

    @Column(name = "active")
    @NotNull (message = "Must be set to true or false")
    private boolean active;

    public InputFile() {

    }
    
    public int getInputFileId() {
        return inputFileId;
    }

    public void setInputFileId(int inputFileId) {
        this.inputFileId = inputFileId;
    }

    public String getNameFormat() {
        return nameFormat;
    }

    public void setNameFormat(String nameFormat) {
        this.nameFormat = nameFormat;
    }

    public String getFileSearchPattern() {
        return fileSearchPattern;
    }

    public void setFileSearchPattern(String fileSearchPattern) {
        this.fileSearchPattern = fileSearchPattern;
    }

    public int getInputFilePathId() {
        return inputFilePathId;
    }

    public void setInputFilePathId(int inputFilePathId) {
        this.inputFilePathId = inputFilePathId;
    }

    public int getFileSchemaId() {
        return fileSchemaId;
    }

    public void setFileSchemaId(int fileSchemaId) {
        this.fileSchemaId = fileSchemaId;
    }

    public int getConcatenateFileGrpId() {
        return concatenateFileGrpId;
    }

    public void setConcatenateFileGrpId(int concatenateFileGrpId) {
        this.concatenateFileGrpId = concatenateFileGrpId;
    }

    public int getDateModifier() {
        return dateModifier;
    }

    public void setDateModifier(int dateModifier) {
        this.dateModifier = dateModifier;
    }

    public int getTxnDateModifier() {
        return txnDateModifier;
    }

    public void setTxnDateModifier(int txnDateModifier) {
        this.txnDateModifier = txnDateModifier;
    }

    public String getPendingCutOff() {
        return pendingCutOff;
    }

    public void setPendingCutOff(String pendingCutOff) {
        this.pendingCutOff = pendingCutOff;
    }

    public String getDataSourceName() {
        return dataSourceName;
    }

    public void setDataSourceName(String dataSourceName) {
        this.dataSourceName = dataSourceName;
    }

    public String getDataSourceType() {
        return dataSourceType;
    }

    public void setDataSourceType(String dataSourceType) {
        this.dataSourceType = dataSourceType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
