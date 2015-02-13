//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.12.04 at 06:33:27 PM CST 
//


package com.accela.adapter.model.function;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for initiateCAP complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="initiateCAP">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="additionalInformation" type="{}additionalInformation" minOccurs="0"/>
 *         &lt;element name="applicant" type="{}applicant" minOccurs="0"/>
 *         &lt;element name="assets" type="{}assets" minOccurs="0"/>
 *         &lt;element name="assignedDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CAPDetail" type="{}capDetail" minOccurs="0"/>
 *         &lt;element name="CAPId" type="{}capId" minOccurs="0"/>
 *         &lt;element name="CAPRelations" type="{}capRelations" minOccurs="0"/>
 *         &lt;element name="CAPTypeId" type="{}capTypeId" minOccurs="0"/>
 *         &lt;element name="conditions" type="{}conditions" minOccurs="0"/>
 *         &lt;element name="contacts" type="{}contacts" minOccurs="0"/>
 *         &lt;element name="costItems" type="{}costItems" minOccurs="0"/>
 *         &lt;element name="department" type="{}department" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="detailAddress" type="{}detailAddress" minOccurs="0"/>
 *         &lt;element name="detailAddresses" type="{}detailAddresses" minOccurs="0"/>
 *         &lt;element name="finalizeNow" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GISObjects" type="{}gisObjects" minOccurs="0"/>
 *         &lt;element name="licenses" type="{}licenses" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parcelIds" type="{}parcelIds" minOccurs="0"/>
 *         &lt;element name="parcels" type="{}parcels" minOccurs="0"/>
 *         &lt;element name="parentCAPIds" type="{}parentCAPIds" minOccurs="0"/>
 *         &lt;element name="parts" type="{}parts" minOccurs="0"/>
 *         &lt;element name="scheduleDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="scheduleTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="spatialDescriptors" type="{}spatialDescriptors" minOccurs="0"/>
 *         &lt;element name="staffPerson" type="{}staffPerson" minOccurs="0"/>
 *         &lt;element name="status" type="{}capStatus" minOccurs="0"/>
 *         &lt;element name="system" type="{}system" minOccurs="0"/>
 *         &lt;element name="workOrderTasks" type="{}workOrderTasks" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "initiateCAP", propOrder = {
    "additionalInformation",
    "applicant",
    "assets",
    "assignedDate",
    "capDetail",
    "capId",
    "capRelations",
    "capTypeId",
    "conditions",
    "contacts",
    "costItems",
    "department",
    "description",
    "detailAddress",
    "detailAddresses",
    "finalizeNow",
    "gisObjects",
    "licenses",
    "name",
    "parcelIds",
    "parcels",
    "parentCAPIds",
    "parts",
    "scheduleDate",
    "scheduleTime",
    "spatialDescriptors",
    "staffPerson",
    "status",
    "system",
    "workOrderTasks"
})
public class InitiateCAP {

    protected AdditionalInformation additionalInformation;
    protected Applicant applicant;
    protected Assets assets;
    protected String assignedDate;
    @XmlElement(name = "CAPDetail")
    protected CapDetail capDetail;
    @XmlElement(name = "CAPId")
    protected CapId capId;
    @XmlElement(name = "CAPRelations")
    protected CapRelations capRelations;
    @XmlElement(name = "CAPTypeId")
    protected CapTypeId capTypeId;
    protected Conditions conditions;
    protected Contacts contacts;
    protected CostItems costItems;
    protected Department department;
    protected String description;
    protected DetailAddress detailAddress;
    protected DetailAddresses detailAddresses;
    protected String finalizeNow;
    @XmlElement(name = "GISObjects")
    protected GisObjects gisObjects;
    protected Licenses licenses;
    protected String name;
    protected ParcelIds parcelIds;
    protected Parcels parcels;
    protected ParentCAPIds parentCAPIds;
    protected Parts parts;
    protected String scheduleDate;
    protected String scheduleTime;
    protected SpatialDescriptors spatialDescriptors;
    protected StaffPerson staffPerson;
    protected CapStatus status;
    protected System system;
    protected WorkOrderTasks workOrderTasks;

    /**
     * Gets the value of the additionalInformation property.
     * 
     * @return
     *     possible object is
     *     {@link AdditionalInformation }
     *     
     */
    public AdditionalInformation getAdditionalInformation() {
        return additionalInformation;
    }

    /**
     * Sets the value of the additionalInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdditionalInformation }
     *     
     */
    public void setAdditionalInformation(AdditionalInformation value) {
        this.additionalInformation = value;
    }

    /**
     * Gets the value of the applicant property.
     * 
     * @return
     *     possible object is
     *     {@link Applicant }
     *     
     */
    public Applicant getApplicant() {
        return applicant;
    }

    /**
     * Sets the value of the applicant property.
     * 
     * @param value
     *     allowed object is
     *     {@link Applicant }
     *     
     */
    public void setApplicant(Applicant value) {
        this.applicant = value;
    }

    /**
     * Gets the value of the assets property.
     * 
     * @return
     *     possible object is
     *     {@link Assets }
     *     
     */
    public Assets getAssets() {
        return assets;
    }

    /**
     * Sets the value of the assets property.
     * 
     * @param value
     *     allowed object is
     *     {@link Assets }
     *     
     */
    public void setAssets(Assets value) {
        this.assets = value;
    }

    /**
     * Gets the value of the assignedDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssignedDate() {
        return assignedDate;
    }

    /**
     * Sets the value of the assignedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssignedDate(String value) {
        this.assignedDate = value;
    }

    /**
     * Gets the value of the capDetail property.
     * 
     * @return
     *     possible object is
     *     {@link CapDetail }
     *     
     */
    public CapDetail getCAPDetail() {
        return capDetail;
    }

    /**
     * Sets the value of the capDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link CapDetail }
     *     
     */
    public void setCAPDetail(CapDetail value) {
        this.capDetail = value;
    }

    /**
     * Gets the value of the capId property.
     * 
     * @return
     *     possible object is
     *     {@link CapId }
     *     
     */
    public CapId getCAPId() {
        return capId;
    }

    /**
     * Sets the value of the capId property.
     * 
     * @param value
     *     allowed object is
     *     {@link CapId }
     *     
     */
    public void setCAPId(CapId value) {
        this.capId = value;
    }

    /**
     * Gets the value of the capRelations property.
     * 
     * @return
     *     possible object is
     *     {@link CapRelations }
     *     
     */
    public CapRelations getCAPRelations() {
        return capRelations;
    }

    /**
     * Sets the value of the capRelations property.
     * 
     * @param value
     *     allowed object is
     *     {@link CapRelations }
     *     
     */
    public void setCAPRelations(CapRelations value) {
        this.capRelations = value;
    }

    /**
     * Gets the value of the capTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link CapTypeId }
     *     
     */
    public CapTypeId getCAPTypeId() {
        return capTypeId;
    }

    /**
     * Sets the value of the capTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link CapTypeId }
     *     
     */
    public void setCAPTypeId(CapTypeId value) {
        this.capTypeId = value;
    }

    /**
     * Gets the value of the conditions property.
     * 
     * @return
     *     possible object is
     *     {@link Conditions }
     *     
     */
    public Conditions getConditions() {
        return conditions;
    }

    /**
     * Sets the value of the conditions property.
     * 
     * @param value
     *     allowed object is
     *     {@link Conditions }
     *     
     */
    public void setConditions(Conditions value) {
        this.conditions = value;
    }

    /**
     * Gets the value of the contacts property.
     * 
     * @return
     *     possible object is
     *     {@link Contacts }
     *     
     */
    public Contacts getContacts() {
        return contacts;
    }

    /**
     * Sets the value of the contacts property.
     * 
     * @param value
     *     allowed object is
     *     {@link Contacts }
     *     
     */
    public void setContacts(Contacts value) {
        this.contacts = value;
    }

    /**
     * Gets the value of the costItems property.
     * 
     * @return
     *     possible object is
     *     {@link CostItems }
     *     
     */
    public CostItems getCostItems() {
        return costItems;
    }

    /**
     * Sets the value of the costItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link CostItems }
     *     
     */
    public void setCostItems(CostItems value) {
        this.costItems = value;
    }

    /**
     * Gets the value of the department property.
     * 
     * @return
     *     possible object is
     *     {@link Department }
     *     
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Sets the value of the department property.
     * 
     * @param value
     *     allowed object is
     *     {@link Department }
     *     
     */
    public void setDepartment(Department value) {
        this.department = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the detailAddress property.
     * 
     * @return
     *     possible object is
     *     {@link DetailAddress }
     *     
     */
    public DetailAddress getDetailAddress() {
        return detailAddress;
    }

    /**
     * Sets the value of the detailAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link DetailAddress }
     *     
     */
    public void setDetailAddress(DetailAddress value) {
        this.detailAddress = value;
    }

    /**
     * Gets the value of the detailAddresses property.
     * 
     * @return
     *     possible object is
     *     {@link DetailAddresses }
     *     
     */
    public DetailAddresses getDetailAddresses() {
        return detailAddresses;
    }

    /**
     * Sets the value of the detailAddresses property.
     * 
     * @param value
     *     allowed object is
     *     {@link DetailAddresses }
     *     
     */
    public void setDetailAddresses(DetailAddresses value) {
        this.detailAddresses = value;
    }

    /**
     * Gets the value of the finalizeNow property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFinalizeNow() {
        return finalizeNow;
    }

    /**
     * Sets the value of the finalizeNow property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFinalizeNow(String value) {
        this.finalizeNow = value;
    }

    /**
     * Gets the value of the gisObjects property.
     * 
     * @return
     *     possible object is
     *     {@link GisObjects }
     *     
     */
    public GisObjects getGISObjects() {
        return gisObjects;
    }

    /**
     * Sets the value of the gisObjects property.
     * 
     * @param value
     *     allowed object is
     *     {@link GisObjects }
     *     
     */
    public void setGISObjects(GisObjects value) {
        this.gisObjects = value;
    }

    /**
     * Gets the value of the licenses property.
     * 
     * @return
     *     possible object is
     *     {@link Licenses }
     *     
     */
    public Licenses getLicenses() {
        return licenses;
    }

    /**
     * Sets the value of the licenses property.
     * 
     * @param value
     *     allowed object is
     *     {@link Licenses }
     *     
     */
    public void setLicenses(Licenses value) {
        this.licenses = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the parcelIds property.
     * 
     * @return
     *     possible object is
     *     {@link ParcelIds }
     *     
     */
    public ParcelIds getParcelIds() {
        return parcelIds;
    }

    /**
     * Sets the value of the parcelIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParcelIds }
     *     
     */
    public void setParcelIds(ParcelIds value) {
        this.parcelIds = value;
    }

    /**
     * Gets the value of the parcels property.
     * 
     * @return
     *     possible object is
     *     {@link Parcels }
     *     
     */
    public Parcels getParcels() {
        return parcels;
    }

    /**
     * Sets the value of the parcels property.
     * 
     * @param value
     *     allowed object is
     *     {@link Parcels }
     *     
     */
    public void setParcels(Parcels value) {
        this.parcels = value;
    }

    /**
     * Gets the value of the parentCAPIds property.
     * 
     * @return
     *     possible object is
     *     {@link ParentCAPIds }
     *     
     */
    public ParentCAPIds getParentCAPIds() {
        return parentCAPIds;
    }

    /**
     * Sets the value of the parentCAPIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParentCAPIds }
     *     
     */
    public void setParentCAPIds(ParentCAPIds value) {
        this.parentCAPIds = value;
    }

    /**
     * Gets the value of the parts property.
     * 
     * @return
     *     possible object is
     *     {@link Parts }
     *     
     */
    public Parts getParts() {
        return parts;
    }

    /**
     * Sets the value of the parts property.
     * 
     * @param value
     *     allowed object is
     *     {@link Parts }
     *     
     */
    public void setParts(Parts value) {
        this.parts = value;
    }

    /**
     * Gets the value of the scheduleDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScheduleDate() {
        return scheduleDate;
    }

    /**
     * Sets the value of the scheduleDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScheduleDate(String value) {
        this.scheduleDate = value;
    }

    /**
     * Gets the value of the scheduleTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScheduleTime() {
        return scheduleTime;
    }

    /**
     * Sets the value of the scheduleTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScheduleTime(String value) {
        this.scheduleTime = value;
    }

    /**
     * Gets the value of the spatialDescriptors property.
     * 
     * @return
     *     possible object is
     *     {@link SpatialDescriptors }
     *     
     */
    public SpatialDescriptors getSpatialDescriptors() {
        return spatialDescriptors;
    }

    /**
     * Sets the value of the spatialDescriptors property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpatialDescriptors }
     *     
     */
    public void setSpatialDescriptors(SpatialDescriptors value) {
        this.spatialDescriptors = value;
    }

    /**
     * Gets the value of the staffPerson property.
     * 
     * @return
     *     possible object is
     *     {@link StaffPerson }
     *     
     */
    public StaffPerson getStaffPerson() {
        return staffPerson;
    }

    /**
     * Sets the value of the staffPerson property.
     * 
     * @param value
     *     allowed object is
     *     {@link StaffPerson }
     *     
     */
    public void setStaffPerson(StaffPerson value) {
        this.staffPerson = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link CapStatus }
     *     
     */
    public CapStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link CapStatus }
     *     
     */
    public void setStatus(CapStatus value) {
        this.status = value;
    }

    /**
     * Gets the value of the system property.
     * 
     * @return
     *     possible object is
     *     {@link System }
     *     
     */
    public System getSystem() {
        return system;
    }

    /**
     * Sets the value of the system property.
     * 
     * @param value
     *     allowed object is
     *     {@link System }
     *     
     */
    public void setSystem(System value) {
        this.system = value;
    }

    /**
     * Gets the value of the workOrderTasks property.
     * 
     * @return
     *     possible object is
     *     {@link WorkOrderTasks }
     *     
     */
    public WorkOrderTasks getWorkOrderTasks() {
        return workOrderTasks;
    }

    /**
     * Sets the value of the workOrderTasks property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkOrderTasks }
     *     
     */
    public void setWorkOrderTasks(WorkOrderTasks value) {
        this.workOrderTasks = value;
    }

}
