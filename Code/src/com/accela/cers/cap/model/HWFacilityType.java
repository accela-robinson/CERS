//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.01.21 at 02:38:20 PM GMT+08:00 
//


package com.accela.cers.cap.model;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for HWFacilityType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HWFacilityType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PMFacilityPermit" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *         &lt;element name="PMInterimStatus" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *         &lt;element name="PMStandardizedPermit" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *         &lt;element name="PMVariance" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *         &lt;element name="PMConsentAgreement" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *         &lt;element name="ShortenedReviewPeriod" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *         &lt;element name="ReviewPeriodReasonForRequest" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}LargeCommentsType">
 *               &lt;maxLength value="300"/>
 *               &lt;minLength value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="NumberOfUnitsCECL" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}OnSiteHWNumberOfUnitsType" minOccurs="0"/>
 *         &lt;element name="DateCertified" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}Date" minOccurs="0"/>
 *         &lt;element name="OOName" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}PersonNameType">
 *               &lt;minLength value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="OOTitle" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}PersonTitleType">
 *               &lt;minLength value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="HWFacilityRegulatorKey" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}RegulatorEntityKeyType">
 *               &lt;minLength value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CERSUniqueKey">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}CERSUniqueKey">
 *               &lt;minLength value="36"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="HWPlotPlans" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}HWPlotPlansType" minOccurs="0"/>
 *         &lt;element name="HWUnits" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}HWUnitsType" minOccurs="0"/>
 *         &lt;element name="HWCertificationOfFinancialAssurances" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}HWCertificationOfFinancialAssurancesType" minOccurs="0"/>
 *         &lt;element name="HWUnitPriorEnforcementHistories" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}HWUnitPriorEnforcementHistoriesType" minOccurs="0"/>
 *         &lt;element name="HWUnitPBRNotificationOfPropertyOwners" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}HWUnitPBRNotificationOfPropertyOwnersType" minOccurs="0"/>
 *         &lt;element name="HWUnitPBRNotificationOfLocalAgencies" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}HWUnitPBRNotificationOfLocalAgenciesType" minOccurs="0"/>
 *         &lt;element name="HWUnitPBRTankAndContainerCertifications" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}HWUnitPBRTankAndContainerCertificationsType" minOccurs="0"/>
 *         &lt;element name="HWFinancialAssuranceClosureMechanisms" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}HWFinancialAssuranceClosureMechanismsType" minOccurs="0"/>
 *         &lt;element name="HWWrittenEstimateOfClosureCosts" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}HWWrittenEstimateOfClosureCostsType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HWFacilityType", propOrder = {
    "pmFacilityPermit",
    "pmInterimStatus",
    "pmStandardizedPermit",
    "pmVariance",
    "pmConsentAgreement",
    "shortenedReviewPeriod",
    "reviewPeriodReasonForRequest",
    "numberOfUnitsCECL",
    "dateCertified",
    "ooName",
    "ooTitle",
    "hwFacilityRegulatorKey",
    "cersUniqueKey",
    "hwPlotPlans",
    "hwUnits",
    "hwCertificationOfFinancialAssurances",
    "hwUnitPriorEnforcementHistories",
    "hwUnitPBRNotificationOfPropertyOwners",
    "hwUnitPBRNotificationOfLocalAgencies",
    "hwUnitPBRTankAndContainerCertifications",
    "hwFinancialAssuranceClosureMechanisms",
    "hwWrittenEstimateOfClosureCosts"
})
public class HWFacilityType {

    @XmlElementRef(name = "PMFacilityPermit", type = JAXBElement.class, required = false)
    protected JAXBElement<YesNoFlagType> pmFacilityPermit;
    @XmlElementRef(name = "PMInterimStatus", type = JAXBElement.class, required = false)
    protected JAXBElement<YesNoFlagType> pmInterimStatus;
    @XmlElementRef(name = "PMStandardizedPermit", type = JAXBElement.class, required = false)
    protected JAXBElement<YesNoFlagType> pmStandardizedPermit;
    @XmlElementRef(name = "PMVariance", type = JAXBElement.class, required = false)
    protected JAXBElement<YesNoFlagType> pmVariance;
    @XmlElementRef(name = "PMConsentAgreement", type = JAXBElement.class, required = false)
    protected JAXBElement<YesNoFlagType> pmConsentAgreement;
    @XmlElement(name = "ShortenedReviewPeriod", defaultValue = "N")
    protected YesNoFlagType shortenedReviewPeriod;
    @XmlElement(name = "ReviewPeriodReasonForRequest")
    protected String reviewPeriodReasonForRequest;
    @XmlElementRef(name = "NumberOfUnitsCECL", type = JAXBElement.class, required = false)
    protected JAXBElement<BigInteger> numberOfUnitsCECL;
    @XmlElementRef(name = "DateCertified", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> dateCertified;
    @XmlElement(name = "OOName")
    protected String ooName;
    @XmlElement(name = "OOTitle")
    protected String ooTitle;
    @XmlElement(name = "HWFacilityRegulatorKey")
    protected String hwFacilityRegulatorKey;
    @XmlElement(name = "CERSUniqueKey", required = true)
    protected String cersUniqueKey;
    @XmlElement(name = "HWPlotPlans")
    protected HWPlotPlansType hwPlotPlans;
    @XmlElement(name = "HWUnits")
    protected HWUnitsType hwUnits;
    @XmlElement(name = "HWCertificationOfFinancialAssurances")
    protected HWCertificationOfFinancialAssurancesType hwCertificationOfFinancialAssurances;
    @XmlElement(name = "HWUnitPriorEnforcementHistories")
    protected HWUnitPriorEnforcementHistoriesType hwUnitPriorEnforcementHistories;
    @XmlElement(name = "HWUnitPBRNotificationOfPropertyOwners")
    protected HWUnitPBRNotificationOfPropertyOwnersType hwUnitPBRNotificationOfPropertyOwners;
    @XmlElement(name = "HWUnitPBRNotificationOfLocalAgencies")
    protected HWUnitPBRNotificationOfLocalAgenciesType hwUnitPBRNotificationOfLocalAgencies;
    @XmlElement(name = "HWUnitPBRTankAndContainerCertifications")
    protected HWUnitPBRTankAndContainerCertificationsType hwUnitPBRTankAndContainerCertifications;
    @XmlElement(name = "HWFinancialAssuranceClosureMechanisms")
    protected HWFinancialAssuranceClosureMechanismsType hwFinancialAssuranceClosureMechanisms;
    @XmlElement(name = "HWWrittenEstimateOfClosureCosts")
    protected HWWrittenEstimateOfClosureCostsType hwWrittenEstimateOfClosureCosts;

    /**
     * Gets the value of the pmFacilityPermit property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     *     
     */
    public JAXBElement<YesNoFlagType> getPMFacilityPermit() {
        return pmFacilityPermit;
    }

    /**
     * Sets the value of the pmFacilityPermit property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     *     
     */
    public void setPMFacilityPermit(JAXBElement<YesNoFlagType> value) {
        this.pmFacilityPermit = value;
    }

    /**
     * Gets the value of the pmInterimStatus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     *     
     */
    public JAXBElement<YesNoFlagType> getPMInterimStatus() {
        return pmInterimStatus;
    }

    /**
     * Sets the value of the pmInterimStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     *     
     */
    public void setPMInterimStatus(JAXBElement<YesNoFlagType> value) {
        this.pmInterimStatus = value;
    }

    /**
     * Gets the value of the pmStandardizedPermit property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     *     
     */
    public JAXBElement<YesNoFlagType> getPMStandardizedPermit() {
        return pmStandardizedPermit;
    }

    /**
     * Sets the value of the pmStandardizedPermit property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     *     
     */
    public void setPMStandardizedPermit(JAXBElement<YesNoFlagType> value) {
        this.pmStandardizedPermit = value;
    }

    /**
     * Gets the value of the pmVariance property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     *     
     */
    public JAXBElement<YesNoFlagType> getPMVariance() {
        return pmVariance;
    }

    /**
     * Sets the value of the pmVariance property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     *     
     */
    public void setPMVariance(JAXBElement<YesNoFlagType> value) {
        this.pmVariance = value;
    }

    /**
     * Gets the value of the pmConsentAgreement property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     *     
     */
    public JAXBElement<YesNoFlagType> getPMConsentAgreement() {
        return pmConsentAgreement;
    }

    /**
     * Sets the value of the pmConsentAgreement property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     *     
     */
    public void setPMConsentAgreement(JAXBElement<YesNoFlagType> value) {
        this.pmConsentAgreement = value;
    }

    /**
     * Gets the value of the shortenedReviewPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link YesNoFlagType }
     *     
     */
    public YesNoFlagType getShortenedReviewPeriod() {
        return shortenedReviewPeriod;
    }

    /**
     * Sets the value of the shortenedReviewPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link YesNoFlagType }
     *     
     */
    public void setShortenedReviewPeriod(YesNoFlagType value) {
        this.shortenedReviewPeriod = value;
    }

    /**
     * Gets the value of the reviewPeriodReasonForRequest property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReviewPeriodReasonForRequest() {
        return reviewPeriodReasonForRequest;
    }

    /**
     * Sets the value of the reviewPeriodReasonForRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReviewPeriodReasonForRequest(String value) {
        this.reviewPeriodReasonForRequest = value;
    }

    /**
     * Gets the value of the numberOfUnitsCECL property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public JAXBElement<BigInteger> getNumberOfUnitsCECL() {
        return numberOfUnitsCECL;
    }

    /**
     * Sets the value of the numberOfUnitsCECL property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public void setNumberOfUnitsCECL(JAXBElement<BigInteger> value) {
        this.numberOfUnitsCECL = value;
    }

    /**
     * Gets the value of the dateCertified property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getDateCertified() {
        return dateCertified;
    }

    /**
     * Sets the value of the dateCertified property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setDateCertified(JAXBElement<XMLGregorianCalendar> value) {
        this.dateCertified = value;
    }

    /**
     * Gets the value of the ooName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOOName() {
        return ooName;
    }

    /**
     * Sets the value of the ooName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOOName(String value) {
        this.ooName = value;
    }

    /**
     * Gets the value of the ooTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOOTitle() {
        return ooTitle;
    }

    /**
     * Sets the value of the ooTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOOTitle(String value) {
        this.ooTitle = value;
    }

    /**
     * Gets the value of the hwFacilityRegulatorKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHWFacilityRegulatorKey() {
        return hwFacilityRegulatorKey;
    }

    /**
     * Sets the value of the hwFacilityRegulatorKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHWFacilityRegulatorKey(String value) {
        this.hwFacilityRegulatorKey = value;
    }

    /**
     * Gets the value of the cersUniqueKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCERSUniqueKey() {
        return cersUniqueKey;
    }

    /**
     * Sets the value of the cersUniqueKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCERSUniqueKey(String value) {
        this.cersUniqueKey = value;
    }

    /**
     * Gets the value of the hwPlotPlans property.
     * 
     * @return
     *     possible object is
     *     {@link HWPlotPlansType }
     *     
     */
    public HWPlotPlansType getHWPlotPlans() {
        return hwPlotPlans;
    }

    /**
     * Sets the value of the hwPlotPlans property.
     * 
     * @param value
     *     allowed object is
     *     {@link HWPlotPlansType }
     *     
     */
    public void setHWPlotPlans(HWPlotPlansType value) {
        this.hwPlotPlans = value;
    }

    /**
     * Gets the value of the hwUnits property.
     * 
     * @return
     *     possible object is
     *     {@link HWUnitsType }
     *     
     */
    public HWUnitsType getHWUnits() {
        return hwUnits;
    }

    /**
     * Sets the value of the hwUnits property.
     * 
     * @param value
     *     allowed object is
     *     {@link HWUnitsType }
     *     
     */
    public void setHWUnits(HWUnitsType value) {
        this.hwUnits = value;
    }

    /**
     * Gets the value of the hwCertificationOfFinancialAssurances property.
     * 
     * @return
     *     possible object is
     *     {@link HWCertificationOfFinancialAssurancesType }
     *     
     */
    public HWCertificationOfFinancialAssurancesType getHWCertificationOfFinancialAssurances() {
        return hwCertificationOfFinancialAssurances;
    }

    /**
     * Sets the value of the hwCertificationOfFinancialAssurances property.
     * 
     * @param value
     *     allowed object is
     *     {@link HWCertificationOfFinancialAssurancesType }
     *     
     */
    public void setHWCertificationOfFinancialAssurances(HWCertificationOfFinancialAssurancesType value) {
        this.hwCertificationOfFinancialAssurances = value;
    }

    /**
     * Gets the value of the hwUnitPriorEnforcementHistories property.
     * 
     * @return
     *     possible object is
     *     {@link HWUnitPriorEnforcementHistoriesType }
     *     
     */
    public HWUnitPriorEnforcementHistoriesType getHWUnitPriorEnforcementHistories() {
        return hwUnitPriorEnforcementHistories;
    }

    /**
     * Sets the value of the hwUnitPriorEnforcementHistories property.
     * 
     * @param value
     *     allowed object is
     *     {@link HWUnitPriorEnforcementHistoriesType }
     *     
     */
    public void setHWUnitPriorEnforcementHistories(HWUnitPriorEnforcementHistoriesType value) {
        this.hwUnitPriorEnforcementHistories = value;
    }

    /**
     * Gets the value of the hwUnitPBRNotificationOfPropertyOwners property.
     * 
     * @return
     *     possible object is
     *     {@link HWUnitPBRNotificationOfPropertyOwnersType }
     *     
     */
    public HWUnitPBRNotificationOfPropertyOwnersType getHWUnitPBRNotificationOfPropertyOwners() {
        return hwUnitPBRNotificationOfPropertyOwners;
    }

    /**
     * Sets the value of the hwUnitPBRNotificationOfPropertyOwners property.
     * 
     * @param value
     *     allowed object is
     *     {@link HWUnitPBRNotificationOfPropertyOwnersType }
     *     
     */
    public void setHWUnitPBRNotificationOfPropertyOwners(HWUnitPBRNotificationOfPropertyOwnersType value) {
        this.hwUnitPBRNotificationOfPropertyOwners = value;
    }

    /**
     * Gets the value of the hwUnitPBRNotificationOfLocalAgencies property.
     * 
     * @return
     *     possible object is
     *     {@link HWUnitPBRNotificationOfLocalAgenciesType }
     *     
     */
    public HWUnitPBRNotificationOfLocalAgenciesType getHWUnitPBRNotificationOfLocalAgencies() {
        return hwUnitPBRNotificationOfLocalAgencies;
    }

    /**
     * Sets the value of the hwUnitPBRNotificationOfLocalAgencies property.
     * 
     * @param value
     *     allowed object is
     *     {@link HWUnitPBRNotificationOfLocalAgenciesType }
     *     
     */
    public void setHWUnitPBRNotificationOfLocalAgencies(HWUnitPBRNotificationOfLocalAgenciesType value) {
        this.hwUnitPBRNotificationOfLocalAgencies = value;
    }

    /**
     * Gets the value of the hwUnitPBRTankAndContainerCertifications property.
     * 
     * @return
     *     possible object is
     *     {@link HWUnitPBRTankAndContainerCertificationsType }
     *     
     */
    public HWUnitPBRTankAndContainerCertificationsType getHWUnitPBRTankAndContainerCertifications() {
        return hwUnitPBRTankAndContainerCertifications;
    }

    /**
     * Sets the value of the hwUnitPBRTankAndContainerCertifications property.
     * 
     * @param value
     *     allowed object is
     *     {@link HWUnitPBRTankAndContainerCertificationsType }
     *     
     */
    public void setHWUnitPBRTankAndContainerCertifications(HWUnitPBRTankAndContainerCertificationsType value) {
        this.hwUnitPBRTankAndContainerCertifications = value;
    }

    /**
     * Gets the value of the hwFinancialAssuranceClosureMechanisms property.
     * 
     * @return
     *     possible object is
     *     {@link HWFinancialAssuranceClosureMechanismsType }
     *     
     */
    public HWFinancialAssuranceClosureMechanismsType getHWFinancialAssuranceClosureMechanisms() {
        return hwFinancialAssuranceClosureMechanisms;
    }

    /**
     * Sets the value of the hwFinancialAssuranceClosureMechanisms property.
     * 
     * @param value
     *     allowed object is
     *     {@link HWFinancialAssuranceClosureMechanismsType }
     *     
     */
    public void setHWFinancialAssuranceClosureMechanisms(HWFinancialAssuranceClosureMechanismsType value) {
        this.hwFinancialAssuranceClosureMechanisms = value;
    }

    /**
     * Gets the value of the hwWrittenEstimateOfClosureCosts property.
     * 
     * @return
     *     possible object is
     *     {@link HWWrittenEstimateOfClosureCostsType }
     *     
     */
    public HWWrittenEstimateOfClosureCostsType getHWWrittenEstimateOfClosureCosts() {
        return hwWrittenEstimateOfClosureCosts;
    }

    /**
     * Sets the value of the hwWrittenEstimateOfClosureCosts property.
     * 
     * @param value
     *     allowed object is
     *     {@link HWWrittenEstimateOfClosureCostsType }
     *     
     */
    public void setHWWrittenEstimateOfClosureCosts(HWWrittenEstimateOfClosureCostsType value) {
        this.hwWrittenEstimateOfClosureCosts = value;
    }

}