//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.12.04 at 06:33:27 PM CST 
//


package com.accela.adapter.model.function;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for inspectionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="inspectionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="allowFailedGuidesheet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="autoAssign" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="carryOverFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dispositions" type="{}dispositions" minOccurs="0"/>
 *         &lt;element name="gradeGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="guidesheetGroups" type="{}guidesheetGroups" minOccurs="0"/>
 *         &lt;element name="guidesheetIds" type="{}guidesheetIds" minOccurs="0"/>
 *         &lt;element name="identifierDisplay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inspectionTypeSecurity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inspectionUnit" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="ivrNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="keys" type="{}keys" minOccurs="0"/>
 *         &lt;element name="maxTotalGuidesheetsValue" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="standardCommentsGroupIds" type="{}standardCommentsGroupIds" minOccurs="0"/>
 *         &lt;element name="timeAccountSecurity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="totalScore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="totalScoreOption" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "inspectionType", propOrder = {
    "allowFailedGuidesheet",
    "autoAssign",
    "carryOverFlag",
    "dispositions",
    "gradeGroup",
    "guidesheetGroups",
    "guidesheetIds",
    "identifierDisplay",
    "inspectionTypeSecurity",
    "inspectionUnit",
    "ivrNumber",
    "keys",
    "maxTotalGuidesheetsValue",
    "standardCommentsGroupIds",
    "timeAccountSecurity",
    "totalScore",
    "totalScoreOption"
})
public class InspectionType {

    protected String allowFailedGuidesheet;
    protected Boolean autoAssign;
    protected String carryOverFlag;
    protected Dispositions dispositions;
    protected String gradeGroup;
    protected GuidesheetGroups guidesheetGroups;
    protected GuidesheetIds guidesheetIds;
    protected String identifierDisplay;
    protected String inspectionTypeSecurity;
    protected Double inspectionUnit;
    protected String ivrNumber;
    protected Keys keys;
    protected Double maxTotalGuidesheetsValue;
    protected StandardCommentsGroupIds standardCommentsGroupIds;
    protected String timeAccountSecurity;
    protected String totalScore;
    protected String totalScoreOption;

    /**
     * Gets the value of the allowFailedGuidesheet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAllowFailedGuidesheet() {
        return allowFailedGuidesheet;
    }

    /**
     * Sets the value of the allowFailedGuidesheet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAllowFailedGuidesheet(String value) {
        this.allowFailedGuidesheet = value;
    }

    /**
     * Gets the value of the autoAssign property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAutoAssign() {
        return autoAssign;
    }

    /**
     * Sets the value of the autoAssign property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAutoAssign(Boolean value) {
        this.autoAssign = value;
    }

    /**
     * Gets the value of the carryOverFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarryOverFlag() {
        return carryOverFlag;
    }

    /**
     * Sets the value of the carryOverFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarryOverFlag(String value) {
        this.carryOverFlag = value;
    }

    /**
     * Gets the value of the dispositions property.
     * 
     * @return
     *     possible object is
     *     {@link Dispositions }
     *     
     */
    public Dispositions getDispositions() {
        return dispositions;
    }

    /**
     * Sets the value of the dispositions property.
     * 
     * @param value
     *     allowed object is
     *     {@link Dispositions }
     *     
     */
    public void setDispositions(Dispositions value) {
        this.dispositions = value;
    }

    /**
     * Gets the value of the gradeGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGradeGroup() {
        return gradeGroup;
    }

    /**
     * Sets the value of the gradeGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGradeGroup(String value) {
        this.gradeGroup = value;
    }

    /**
     * Gets the value of the guidesheetGroups property.
     * 
     * @return
     *     possible object is
     *     {@link GuidesheetGroups }
     *     
     */
    public GuidesheetGroups getGuidesheetGroups() {
        return guidesheetGroups;
    }

    /**
     * Sets the value of the guidesheetGroups property.
     * 
     * @param value
     *     allowed object is
     *     {@link GuidesheetGroups }
     *     
     */
    public void setGuidesheetGroups(GuidesheetGroups value) {
        this.guidesheetGroups = value;
    }

    /**
     * Gets the value of the guidesheetIds property.
     * 
     * @return
     *     possible object is
     *     {@link GuidesheetIds }
     *     
     */
    public GuidesheetIds getGuidesheetIds() {
        return guidesheetIds;
    }

    /**
     * Sets the value of the guidesheetIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link GuidesheetIds }
     *     
     */
    public void setGuidesheetIds(GuidesheetIds value) {
        this.guidesheetIds = value;
    }

    /**
     * Gets the value of the identifierDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentifierDisplay() {
        return identifierDisplay;
    }

    /**
     * Sets the value of the identifierDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentifierDisplay(String value) {
        this.identifierDisplay = value;
    }

    /**
     * Gets the value of the inspectionTypeSecurity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInspectionTypeSecurity() {
        return inspectionTypeSecurity;
    }

    /**
     * Sets the value of the inspectionTypeSecurity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInspectionTypeSecurity(String value) {
        this.inspectionTypeSecurity = value;
    }

    /**
     * Gets the value of the inspectionUnit property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getInspectionUnit() {
        return inspectionUnit;
    }

    /**
     * Sets the value of the inspectionUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setInspectionUnit(Double value) {
        this.inspectionUnit = value;
    }

    /**
     * Gets the value of the ivrNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIvrNumber() {
        return ivrNumber;
    }

    /**
     * Sets the value of the ivrNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIvrNumber(String value) {
        this.ivrNumber = value;
    }

    /**
     * Gets the value of the keys property.
     * 
     * @return
     *     possible object is
     *     {@link Keys }
     *     
     */
    public Keys getKeys() {
        return keys;
    }

    /**
     * Sets the value of the keys property.
     * 
     * @param value
     *     allowed object is
     *     {@link Keys }
     *     
     */
    public void setKeys(Keys value) {
        this.keys = value;
    }

    /**
     * Gets the value of the maxTotalGuidesheetsValue property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMaxTotalGuidesheetsValue() {
        return maxTotalGuidesheetsValue;
    }

    /**
     * Sets the value of the maxTotalGuidesheetsValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMaxTotalGuidesheetsValue(Double value) {
        this.maxTotalGuidesheetsValue = value;
    }

    /**
     * Gets the value of the standardCommentsGroupIds property.
     * 
     * @return
     *     possible object is
     *     {@link StandardCommentsGroupIds }
     *     
     */
    public StandardCommentsGroupIds getStandardCommentsGroupIds() {
        return standardCommentsGroupIds;
    }

    /**
     * Sets the value of the standardCommentsGroupIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardCommentsGroupIds }
     *     
     */
    public void setStandardCommentsGroupIds(StandardCommentsGroupIds value) {
        this.standardCommentsGroupIds = value;
    }

    /**
     * Gets the value of the timeAccountSecurity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeAccountSecurity() {
        return timeAccountSecurity;
    }

    /**
     * Sets the value of the timeAccountSecurity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeAccountSecurity(String value) {
        this.timeAccountSecurity = value;
    }

    /**
     * Gets the value of the totalScore property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalScore() {
        return totalScore;
    }

    /**
     * Sets the value of the totalScore property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalScore(String value) {
        this.totalScore = value;
    }

    /**
     * Gets the value of the totalScoreOption property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalScoreOption() {
        return totalScoreOption;
    }

    /**
     * Sets the value of the totalScoreOption property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalScoreOption(String value) {
        this.totalScoreOption = value;
    }

}
