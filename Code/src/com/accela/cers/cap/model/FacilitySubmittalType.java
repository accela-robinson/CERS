//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.01.21 at 02:38:20 PM GMT+08:00 
//


package com.accela.cers.cap.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FacilitySubmittalType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FacilitySubmittalType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CERSID" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}CERSIDType"/>
 *         &lt;element name="CERSOrganization" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}CERSOrganizationType"/>
 *         &lt;element name="FacilityID" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="0"/>
 *               &lt;maxLength value="13"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="FacilityRegulatorKey" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="36"/>
 *               &lt;minLength value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="FacilityInformation" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}FacilityInformationType">
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="HazardousMaterialsInventory" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}HazardousMaterialsInventoryType">
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="EmergencyResponseTrainingPlans" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}EmergencyResponseTrainingPlansType">
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="UndergroundStorageTanks" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}UndergroundStorageTanksType">
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="OnsiteHazardousWasteTreatmentNotification" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}OnsiteHazardousWasteTreatmentNotificationType">
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="RecyclableMaterialsReport" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}RecyclableMaterialsReportType" minOccurs="0"/>
 *         &lt;element name="RemoteWasteConsolidationsAnnualNotification" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}RemoteWasteConsolidationsAnnualNotificationType" minOccurs="0"/>
 *         &lt;element name="HWTankClosureCertification" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}HWTankClosureCertificationType" minOccurs="0"/>
 *         &lt;element name="AbovegroundPetroleumStorageTanks" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}AbovegroundPetroleumStorageTanksType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FacilitySubmittalType", propOrder = {
    "cersid",
    "cersOrganization",
    "facilityID",
    "facilityRegulatorKey",
    "facilityInformation",
    "hazardousMaterialsInventory",
    "emergencyResponseTrainingPlans",
    "undergroundStorageTanks",
    "onsiteHazardousWasteTreatmentNotification",
    "recyclableMaterialsReport",
    "remoteWasteConsolidationsAnnualNotification",
    "hwTankClosureCertification",
    "abovegroundPetroleumStorageTanks"
})
@XmlSeeAlso({
    com.accela.cers.cap.model.RegulatorFacilitySubmittals.FacilitySubmittal.class
})
public class FacilitySubmittalType {

    @XmlElement(name = "CERSID")
    protected int cersid;
    @XmlElement(name = "CERSOrganization", required = true)
    protected CERSOrganizationType cersOrganization;
    @XmlElement(name = "FacilityID")
    protected String facilityID;
    @XmlElement(name = "FacilityRegulatorKey")
    protected String facilityRegulatorKey;
    @XmlElement(name = "FacilityInformation")
    protected FacilitySubmittalType.FacilityInformation facilityInformation;
    @XmlElement(name = "HazardousMaterialsInventory")
    protected FacilitySubmittalType.HazardousMaterialsInventory hazardousMaterialsInventory;
    @XmlElement(name = "EmergencyResponseTrainingPlans")
    protected FacilitySubmittalType.EmergencyResponseTrainingPlans emergencyResponseTrainingPlans;
    @XmlElement(name = "UndergroundStorageTanks")
    protected FacilitySubmittalType.UndergroundStorageTanks undergroundStorageTanks;
    @XmlElement(name = "OnsiteHazardousWasteTreatmentNotification")
    protected FacilitySubmittalType.OnsiteHazardousWasteTreatmentNotification onsiteHazardousWasteTreatmentNotification;
    @XmlElement(name = "RecyclableMaterialsReport")
    protected RecyclableMaterialsReportType recyclableMaterialsReport;
    @XmlElement(name = "RemoteWasteConsolidationsAnnualNotification")
    protected RemoteWasteConsolidationsAnnualNotificationType remoteWasteConsolidationsAnnualNotification;
    @XmlElement(name = "HWTankClosureCertification")
    protected HWTankClosureCertificationType hwTankClosureCertification;
    @XmlElement(name = "AbovegroundPetroleumStorageTanks")
    protected AbovegroundPetroleumStorageTanksType abovegroundPetroleumStorageTanks;

    /**
     * Gets the value of the cersid property.
     * 
     */
    public int getCERSID() {
        return cersid;
    }

    /**
     * Sets the value of the cersid property.
     * 
     */
    public void setCERSID(int value) {
        this.cersid = value;
    }

    /**
     * Gets the value of the cersOrganization property.
     * 
     * @return
     *     possible object is
     *     {@link CERSOrganizationType }
     *     
     */
    public CERSOrganizationType getCERSOrganization() {
        return cersOrganization;
    }

    /**
     * Sets the value of the cersOrganization property.
     * 
     * @param value
     *     allowed object is
     *     {@link CERSOrganizationType }
     *     
     */
    public void setCERSOrganization(CERSOrganizationType value) {
        this.cersOrganization = value;
    }

    /**
     * Gets the value of the facilityID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFacilityID() {
        return facilityID;
    }

    /**
     * Sets the value of the facilityID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFacilityID(String value) {
        this.facilityID = value;
    }

    /**
     * Gets the value of the facilityRegulatorKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFacilityRegulatorKey() {
        return facilityRegulatorKey;
    }

    /**
     * Sets the value of the facilityRegulatorKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFacilityRegulatorKey(String value) {
        this.facilityRegulatorKey = value;
    }

    /**
     * Gets the value of the facilityInformation property.
     * 
     * @return
     *     possible object is
     *     {@link FacilitySubmittalType.FacilityInformation }
     *     
     */
    public FacilitySubmittalType.FacilityInformation getFacilityInformation() {
        return facilityInformation;
    }

    /**
     * Sets the value of the facilityInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link FacilitySubmittalType.FacilityInformation }
     *     
     */
    public void setFacilityInformation(FacilitySubmittalType.FacilityInformation value) {
        this.facilityInformation = value;
    }

    /**
     * Gets the value of the hazardousMaterialsInventory property.
     * 
     * @return
     *     possible object is
     *     {@link FacilitySubmittalType.HazardousMaterialsInventory }
     *     
     */
    public FacilitySubmittalType.HazardousMaterialsInventory getHazardousMaterialsInventory() {
        return hazardousMaterialsInventory;
    }

    /**
     * Sets the value of the hazardousMaterialsInventory property.
     * 
     * @param value
     *     allowed object is
     *     {@link FacilitySubmittalType.HazardousMaterialsInventory }
     *     
     */
    public void setHazardousMaterialsInventory(FacilitySubmittalType.HazardousMaterialsInventory value) {
        this.hazardousMaterialsInventory = value;
    }

    /**
     * Gets the value of the emergencyResponseTrainingPlans property.
     * 
     * @return
     *     possible object is
     *     {@link FacilitySubmittalType.EmergencyResponseTrainingPlans }
     *     
     */
    public FacilitySubmittalType.EmergencyResponseTrainingPlans getEmergencyResponseTrainingPlans() {
        return emergencyResponseTrainingPlans;
    }

    /**
     * Sets the value of the emergencyResponseTrainingPlans property.
     * 
     * @param value
     *     allowed object is
     *     {@link FacilitySubmittalType.EmergencyResponseTrainingPlans }
     *     
     */
    public void setEmergencyResponseTrainingPlans(FacilitySubmittalType.EmergencyResponseTrainingPlans value) {
        this.emergencyResponseTrainingPlans = value;
    }

    /**
     * Gets the value of the undergroundStorageTanks property.
     * 
     * @return
     *     possible object is
     *     {@link FacilitySubmittalType.UndergroundStorageTanks }
     *     
     */
    public FacilitySubmittalType.UndergroundStorageTanks getUndergroundStorageTanks() {
        return undergroundStorageTanks;
    }

    /**
     * Sets the value of the undergroundStorageTanks property.
     * 
     * @param value
     *     allowed object is
     *     {@link FacilitySubmittalType.UndergroundStorageTanks }
     *     
     */
    public void setUndergroundStorageTanks(FacilitySubmittalType.UndergroundStorageTanks value) {
        this.undergroundStorageTanks = value;
    }

    /**
     * Gets the value of the onsiteHazardousWasteTreatmentNotification property.
     * 
     * @return
     *     possible object is
     *     {@link FacilitySubmittalType.OnsiteHazardousWasteTreatmentNotification }
     *     
     */
    public FacilitySubmittalType.OnsiteHazardousWasteTreatmentNotification getOnsiteHazardousWasteTreatmentNotification() {
        return onsiteHazardousWasteTreatmentNotification;
    }

    /**
     * Sets the value of the onsiteHazardousWasteTreatmentNotification property.
     * 
     * @param value
     *     allowed object is
     *     {@link FacilitySubmittalType.OnsiteHazardousWasteTreatmentNotification }
     *     
     */
    public void setOnsiteHazardousWasteTreatmentNotification(FacilitySubmittalType.OnsiteHazardousWasteTreatmentNotification value) {
        this.onsiteHazardousWasteTreatmentNotification = value;
    }

    /**
     * Gets the value of the recyclableMaterialsReport property.
     * 
     * @return
     *     possible object is
     *     {@link RecyclableMaterialsReportType }
     *     
     */
    public RecyclableMaterialsReportType getRecyclableMaterialsReport() {
        return recyclableMaterialsReport;
    }

    /**
     * Sets the value of the recyclableMaterialsReport property.
     * 
     * @param value
     *     allowed object is
     *     {@link RecyclableMaterialsReportType }
     *     
     */
    public void setRecyclableMaterialsReport(RecyclableMaterialsReportType value) {
        this.recyclableMaterialsReport = value;
    }

    /**
     * Gets the value of the remoteWasteConsolidationsAnnualNotification property.
     * 
     * @return
     *     possible object is
     *     {@link RemoteWasteConsolidationsAnnualNotificationType }
     *     
     */
    public RemoteWasteConsolidationsAnnualNotificationType getRemoteWasteConsolidationsAnnualNotification() {
        return remoteWasteConsolidationsAnnualNotification;
    }

    /**
     * Sets the value of the remoteWasteConsolidationsAnnualNotification property.
     * 
     * @param value
     *     allowed object is
     *     {@link RemoteWasteConsolidationsAnnualNotificationType }
     *     
     */
    public void setRemoteWasteConsolidationsAnnualNotification(RemoteWasteConsolidationsAnnualNotificationType value) {
        this.remoteWasteConsolidationsAnnualNotification = value;
    }

    /**
     * Gets the value of the hwTankClosureCertification property.
     * 
     * @return
     *     possible object is
     *     {@link HWTankClosureCertificationType }
     *     
     */
    public HWTankClosureCertificationType getHWTankClosureCertification() {
        return hwTankClosureCertification;
    }

    /**
     * Sets the value of the hwTankClosureCertification property.
     * 
     * @param value
     *     allowed object is
     *     {@link HWTankClosureCertificationType }
     *     
     */
    public void setHWTankClosureCertification(HWTankClosureCertificationType value) {
        this.hwTankClosureCertification = value;
    }

    /**
     * Gets the value of the abovegroundPetroleumStorageTanks property.
     * 
     * @return
     *     possible object is
     *     {@link AbovegroundPetroleumStorageTanksType }
     *     
     */
    public AbovegroundPetroleumStorageTanksType getAbovegroundPetroleumStorageTanks() {
        return abovegroundPetroleumStorageTanks;
    }

    /**
     * Sets the value of the abovegroundPetroleumStorageTanks property.
     * 
     * @param value
     *     allowed object is
     *     {@link AbovegroundPetroleumStorageTanksType }
     *     
     */
    public void setAbovegroundPetroleumStorageTanks(AbovegroundPetroleumStorageTanksType value) {
        this.abovegroundPetroleumStorageTanks = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}EmergencyResponseTrainingPlansType">
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class EmergencyResponseTrainingPlans
        extends EmergencyResponseTrainingPlansType
    {


    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}FacilityInformationType">
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class FacilityInformation
        extends FacilityInformationType
    {


    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}HazardousMaterialsInventoryType">
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class HazardousMaterialsInventory
        extends HazardousMaterialsInventoryType
    {


    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}OnsiteHazardousWasteTreatmentNotificationType">
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class OnsiteHazardousWasteTreatmentNotification
        extends OnsiteHazardousWasteTreatmentNotificationType
    {


    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}UndergroundStorageTanksType">
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class UndergroundStorageTanks
        extends UndergroundStorageTanksType
    {


    }

}
