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

/* Entity Class Input File Schema
 * 
 * @author Stuart Kemp
 * @version 1.0
 * @since 2016-04-08
 */
@Entity
@Table(name = "inputfileschema")
public class InputFileSchema implements java.io.Serializable {

    private static final long serialVersionUID = 655836767382564270L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "inputfileschemaid")
    private int inputFileSchemaId;

    @Column(name = "description")
    @NotNull(message = "Please enter a description")
    @Length(min=0, max=64, message="Please enter a string pattern between 0 and 64 characters") 
    private String description;

    @Column(name = "gotheader")
    @NotNull (message = "Must be set to true or false")
    private boolean gotHeader;

    @Column(name = "headerstart")
    @NotNull(message = "Please enter a header start")
    @Length(min=0, max=32, message="Please enter a string pattern between 0 and 32 characters") 
    private String headerStart;

    @Column(name = "numberheadercolumns")
    @NotNull(message = "Please enter the number of header columns")
    @Digits(integer = 6, fraction = 0, message = "Incorrect number of header columns, must be an integer")
    private int numberHeaderColumns;

    @Column(name = "headerdelimiter")
    @NotNull(message = "Please enter a header delimiter")
    @Length(min=0, max=8, message="Please enter a string pattern between 0 and 8 characters") 
    private String headerDelimiter;

    @Column(name = "headerfluff")
    @NotNull(message = "Please enter header fluff")
    @Length(min=0, max=4, message="Please enter a string pattern between 0 and 4 characters") 
    private String headerFluff;

    @Column(name = "gotfooter")
    @NotNull(message = "Must be set to true or false")
    private boolean gotFooter;

    @Column(name = "footerstart")
    @NotNull(message = "Please enter a footer start")
    @Length(min=0, max=32, message="Please enter a string pattern between 0 and 32 characters") 
    private String footerStart;

    @Column(name = "numberfootercolumns")
    @NotNull(message = "Please enter the number of footer columns")
    @Digits(integer = 6, fraction = 0, message = "Incorrect number of footer columns, must be an integer")
    private int numberFooterColumns;

    @Column(name = "footerdelimiter")
    @NotNull(message = "Please enter a footer delimiter")
    @Length(min=0, max=8, message="Please enter a string pattern between 0 and 8 characters") 
    private String footerDelimiter;

    @Column(name = "footerfluff")
    @NotNull(message = "Please enter footer fluff")
    @Length(min=0, max=4, message="Please enter a string pattern between 0 and 4 characters") 
    private String footerFluff;

    @Column(name = "numberdetailcolumns")
    @NotNull(message = "Please enter the number of detail columns")
    @Digits(integer = 6, fraction = 0, message = "Incorrect number of detail columns, must be an integer")
    private int numberDetailColumns;

    @Column(name = "detaildelimiter")
    @NotNull(message = "Please enter a detail delimiter")
    @Length(min=0, max=8, message="Please enter a string pattern between 0 and 8 characters")
    private String detailDelimiter;

    @Column(name = "fieldfluff")
    @NotNull(message = "Please enter field fluff")
    @Length(min=0, max=4, message="Please enter a string pattern between 0 and 4 characters")
    private String fieldFluff;

    @Column(name = "fieldextract")
    @NotNull(message = "Please enter field extract")
    @Length(min=0, max=128, message="Please enter a string pattern between 0 and 128 characters")
    private String fieldExtract;

    @Column(name = "fieldmatch")
    @NotNull(message = "Please enter a field match")
    @Length(min=0, max=128, message="Please enter a string pattern between 0 and 128 characters")
    private String fieldMatch;

    @Column(name = "fieldtransform")
    @NotNull(message = "Please enter field transform")
    @Length(min=0, max=128, message="Please enter a string pattern between 0 and 128 characters")
    private String fieldTransform;

    @Column(name = "gotskiprows")
    @NotNull(message = "Must be set to true or false")
    private boolean gotSkipRows;

    @Column(name = "numberskiprowcolumns")
    @NotNull(message = "Please enter the number of skip row columns")
    @Digits(integer = 6, fraction = 0, message = "Incorrect number of detail columns, must be an integer")
    private int numberSkipRowColumns;

    @Column(name = "skiprowdelimiter")
    @NotNull(message = "Please enter skip row delimiter")
    @Length(min=0, max=8, message="Please enter a string pattern between 0 and 8 characters")
    private String skipRowDelimiter;

    @Column(name = "skipstartingwith")
    @NotNull(message = "Please enter skip starting with")
    @Length(min=0, max=255, message="Please enter a string pattern between 0 and 255 characters")
    private String skipStartingWith;

    @Column(name = "active")
    @NotNull(message = "Must be set to true or false")
    private boolean active;

    public InputFileSchema() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.inputFileSchemaId;
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
        final InputFileSchema other = (InputFileSchema) obj;
        if (this.inputFileSchemaId != other.inputFileSchemaId) {
            return false;
        }
        return true;
    }

    public int getInputFileSchemaId() {
        return inputFileSchemaId;
    }

    public void setInputFileSchemaId(int inputFileSchemaId) {
        this.inputFileSchemaId = inputFileSchemaId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isGotHeader() {
        return gotHeader;
    }

    public void setGotHeader(boolean gotHeader) {
        this.gotHeader = gotHeader;
    }

    public String getHeaderStart() {
        return headerStart;
    }

    public void setHeaderStart(String headerStart) {
        this.headerStart = headerStart;
    }

    public int getNumberHeaderColumns() {
        return numberHeaderColumns;
    }

    public void setNumberHeaderColumns(int numberHeaderColumns) {
        this.numberHeaderColumns = numberHeaderColumns;
    }

    public String getHeaderDelimiter() {
        return headerDelimiter;
    }

    public void setHeaderDelimiter(String headerDelimiter) {
        this.headerDelimiter = headerDelimiter;
    }

    public String getHeaderFluff() {
        return headerFluff;
    }

    public void setHeaderFluff(String headerFluff) {
        this.headerFluff = headerFluff;
    }

    public boolean isGotFooter() {
        return gotFooter;
    }

    public void setGotFooter(boolean gotFooter) {
        this.gotFooter = gotFooter;
    }

    public String getFooterStart() {
        return footerStart;
    }

    public void setFooterStart(String footerStart) {
        this.footerStart = footerStart;
    }

    public int getNumberFooterColumns() {
        return numberFooterColumns;
    }

    public void setNumberFooterColumns(int numberFooterColumns) {
        this.numberFooterColumns = numberFooterColumns;
    }

    public String getFooterDelimiter() {
        return footerDelimiter;
    }

    public void setFooterDelimiter(String footerDelimiter) {
        this.footerDelimiter = footerDelimiter;
    }

    public String getFooterFluff() {
        return footerFluff;
    }

    public void setFooterFluff(String footerFluff) {
        this.footerFluff = footerFluff;
    }

    public int getNumberDetailColumns() {
        return numberDetailColumns;
    }

    public void setNumberDetailColumns(int numberDetailColumns) {
        this.numberDetailColumns = numberDetailColumns;
    }

    public String getDetailDelimiter() {
        return detailDelimiter;
    }

    public void setDetailDelimiter(String detailDelimiter) {
        this.detailDelimiter = detailDelimiter;
    }

    public String getFieldFluff() {
        return fieldFluff;
    }

    public void setFieldFluff(String fieldFluff) {
        this.fieldFluff = fieldFluff;
    }

    public String getFieldExtract() {
        return fieldExtract;
    }

    public void setFieldExtract(String fieldExtract) {
        this.fieldExtract = fieldExtract;
    }

    public String getFieldMatch() {
        return fieldMatch;
    }

    public void setFieldMatch(String filedMatch) {
        this.fieldMatch = filedMatch;
    }

    public String getFieldTransform() {
        return fieldTransform;
    }

    public void setFieldTransform(String fieldTransform) {
        this.fieldTransform = fieldTransform;
    }

    public boolean isGotSkipRows() {
        return gotSkipRows;
    }

    public void setGotSkipRows(boolean gotSkipRows) {
        this.gotSkipRows = gotSkipRows;
    }

    public int getNumberSkipRowColumns() {
        return numberSkipRowColumns;
    }

    public void setNumberSkipRowColumns(int numberSkipRowColumns) {
        this.numberSkipRowColumns = numberSkipRowColumns;
    }

    public String getSkipRowDelimiter() {
        return skipRowDelimiter;
    }

    public void setSkipRowDelimiter(String skipRowDelimiter) {
        this.skipRowDelimiter = skipRowDelimiter;
    }

    public String getSkipStartingWith() {
        return skipStartingWith;
    }

    public void setSkipStartingWith(String skipStartingWith) {
        this.skipStartingWith = skipStartingWith;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
