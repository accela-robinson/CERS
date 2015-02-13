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
 * <p>Java class for getParcels complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getParcels">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CAPId" type="{}capId" minOccurs="0"/>
 *         &lt;element name="CAPIds" type="{}capIds" minOccurs="0"/>
 *         &lt;element name="CAPStatus" type="{}capStatus" minOccurs="0"/>
 *         &lt;element name="CAPStatuses" type="{}capStatuses" minOccurs="0"/>
 *         &lt;element name="compactAddressId" type="{}compactAddressId" minOccurs="0"/>
 *         &lt;element name="compactAddressIds" type="{}compactAddressIds" minOccurs="0"/>
 *         &lt;element name="contact" type="{}contact" minOccurs="0"/>
 *         &lt;element name="contactIds" type="{}contactIds" minOccurs="0"/>
 *         &lt;element name="contacts" type="{}contacts" minOccurs="0"/>
 *         &lt;element name="dateRange" type="{}dateRange" minOccurs="0"/>
 *         &lt;element name="dateRanges" type="{}dateRanges" minOccurs="0"/>
 *         &lt;element name="detailAddress" type="{}detailAddress" minOccurs="0"/>
 *         &lt;element name="detailAddresses" type="{}detailAddresses" minOccurs="0"/>
 *         &lt;element name="GISObjectId" type="{}gisObjectId" minOccurs="0"/>
 *         &lt;element name="GISObjects" type="{}gisObjects" minOccurs="0"/>
 *         &lt;element name="parcelId" type="{}parcelId" minOccurs="0"/>
 *         &lt;element name="parcelIds" type="{}parcelIds" minOccurs="0"/>
 *         &lt;element name="returnDisableParcels" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="returnElements" type="{}returnElements" minOccurs="0"/>
 *         &lt;element name="returnRefParcels" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="spatialDescriptors" type="{}spatialDescriptors" minOccurs="0"/>
 *         &lt;element name="system" type="{}system" minOccurs="0"/>
 *         &lt;element name="templateFields" type="{}templateFields" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getParcels", propOrder = {
    "capId",
    "capIds",
    "capStatus",
    "capStatuses",
    "compactAddressId",
    "compactAddressIds",
    "contact",
    "contactIds",
    "contacts",
    "dateRange",
    "dateRanges",
    "detailAddress",
    "detailAddresses",
    "gisObjectId",
    "gisObjects",
    "parcelId",
    "parcelIds",
    "returnDisableParcels",
    "returnElements",
    "returnRefParcels",
    "spatialDescriptors",
    "system",
    "templateFields"
})
public class GetParcels {

    @XmlElement(name = "CAPId")
    protected CapId capId;
    @XmlElement(name = "CAPIds")
    protected CapIds capIds;
    @XmlElement(name = "CAPStatus")
    protected CapStatus capStatus;
    @XmlElement(name = "CAPStatuses")
    protected CapStatuses capStatuses;
    protected CompactAddressId compactAddressId;
    protected CompactAddressIds compactAddressIds;
    protected Contact contact;
    protected ContactIds contactIds;
    protected Contacts contacts;
    protected DateRange dateRange;
    protected DateRanges dateRanges;
    protected DetailAddress detailAddress;
    protected DetailAddresses detailAddresses;
    @XmlElement(name = "GISObjectId")
    protected GisObjectId gisObjectId;
    @XmlElement(name = "GISObjects")
    protected GisObjects gisObjects;
    protected ParcelId parcelId;
    protected ParcelIds parcelIds;
    protected boolean returnDisableParcels;
    protected ReturnElements returnElements;
    protected boolean returnRefParcels;
    protected SpatialDescriptors spatialDescriptors;
    protected System system;
    protected TemplateFields templateFields;

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
     * Gets the value of the capIds property.
     * 
     * @return
     *     possible object is
     *     {@link CapIds }
     *     
     */
    public CapIds getCAPIds() {
        return capIds;
    }

    /**
     * Sets the value of the capIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link CapIds }
     *     
     */
    public void setCAPIds(CapIds value) {
        this.capIds = value;
    }

    /**
     * Gets the value of the capStatus property.
     * 
     * @return
     *     possible object is
     *     {@link CapStatus }
     *     
     */
    public CapStatus getCAPStatus() {
        return capStatus;
    }

    /**
     * Sets the value of the capStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link CapStatus }
     *     
     */
    public void setCAPStatus(CapStatus value) {
        this.capStatus = value;
    }

    /**
     * Gets the value of the capStatuses property.
     * 
     * @return
     *     possible object is
     *     {@link CapStatuses }
     *     
     */
    public CapStatuses getCAPStatuses() {
        return capStatuses;
    }

    /**
     * Sets the value of the capStatuses property.
     * 
     * @param value
     *     allowed object is
     *     {@link CapStatuses }
     *     
     */
    public void setCAPStatuses(CapStatuses value) {
        this.capStatuses = value;
    }

    /**
     * Gets the value of the compactAddressId property.
     * 
     * @return
     *     possible object is
     *     {@link CompactAddressId }
     *     
     */
    public CompactAddressId getCompactAddressId() {
        return compactAddressId;
    }

    /**
     * Sets the value of the compactAddressId property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompactAddressId }
     *     
     */
    public void setCompactAddressId(CompactAddressId value) {
        this.compactAddressId = value;
    }

    /**
     * Gets the value of the compactAddressIds property.
     * 
     * @return
     *     possible object is
     *     {@link CompactAddressIds }
     *     
     */
    public CompactAddressIds getCompactAddressIds() {
        return compactAddressIds;
    }

    /**
     * Sets the value of the compactAddressIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompactAddressIds }
     *     
     */
    public void setCompactAddressIds(CompactAddressIds value) {
        this.compactAddressIds = value;
    }

    /**
     * Gets the value of the contact property.
     * 
     * @return
     *     possible object is
     *     {@link Contact }
     *     
     */
    public Contact getContact() {
        return contact;
    }

    /**
     * Sets the value of the contact property.
     * 
     * @param value
     *     allowed object is
     *     {@link Contact }
     *     
     */
    public void setContact(Contact value) {
        this.contact = value;
    }

    /**
     * Gets the value of the contactIds property.
     * 
     * @return
     *     possible object is
     *     {@link ContactIds }
     *     
     */
    public ContactIds getContactIds() {
        return contactIds;
    }

    /**
     * Sets the value of the contactIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactIds }
     *     
     */
    public void setContactIds(ContactIds value) {
        this.contactIds = value;
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
     * Gets the value of the dateRange property.
     * 
     * @return
     *     possible object is
     *     {@link DateRange }
     *     
     */
    public DateRange getDateRange() {
        return dateRange;
    }

    /**
     * Sets the value of the dateRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateRange }
     *     
     */
    public void setDateRange(DateRange value) {
        this.dateRange = value;
    }

    /**
     * Gets the value of the dateRanges property.
     * 
     * @return
     *     possible object is
     *     {@link DateRanges }
     *     
     */
    public DateRanges getDateRanges() {
        return dateRanges;
    }

    /**
     * Sets the value of the dateRanges property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateRanges }
     *     
     */
    public void setDateRanges(DateRanges value) {
        this.dateRanges = value;
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
     * Gets the value of the gisObjectId property.
     * 
     * @return
     *     possible object is
     *     {@link GisObjectId }
     *     
     */
    public GisObjectId getGISObjectId() {
        return gisObjectId;
    }

    /**
     * Sets the value of the gisObjectId property.
     * 
     * @param value
     *     allowed object is
     *     {@link GisObjectId }
     *     
     */
    public void setGISObjectId(GisObjectId value) {
        this.gisObjectId = value;
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
     * Gets the value of the parcelId property.
     * 
     * @return
     *     possible object is
     *     {@link ParcelId }
     *     
     */
    public ParcelId getParcelId() {
        return parcelId;
    }

    /**
     * Sets the value of the parcelId property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParcelId }
     *     
     */
    public void setParcelId(ParcelId value) {
        this.parcelId = value;
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
     * Gets the value of the returnDisableParcels property.
     * 
     */
    public boolean isReturnDisableParcels() {
        return returnDisableParcels;
    }

    /**
     * Sets the value of the returnDisableParcels property.
     * 
     */
    public void setReturnDisableParcels(boolean value) {
        this.returnDisableParcels = value;
    }

    /**
     * Gets the value of the returnElements property.
     * 
     * @return
     *     possible object is
     *     {@link ReturnElements }
     *     
     */
    public ReturnElements getReturnElements() {
        return returnElements;
    }

    /**
     * Sets the value of the returnElements property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReturnElements }
     *     
     */
    public void setReturnElements(ReturnElements value) {
        this.returnElements = value;
    }

    /**
     * Gets the value of the returnRefParcels property.
     * 
     */
    public boolean isReturnRefParcels() {
        return returnRefParcels;
    }

    /**
     * Sets the value of the returnRefParcels property.
     * 
     */
    public void setReturnRefParcels(boolean value) {
        this.returnRefParcels = value;
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
     * Gets the value of the templateFields property.
     * 
     * @return
     *     possible object is
     *     {@link TemplateFields }
     *     
     */
    public TemplateFields getTemplateFields() {
        return templateFields;
    }

    /**
     * Sets the value of the templateFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link TemplateFields }
     *     
     */
    public void setTemplateFields(TemplateFields value) {
        this.templateFields = value;
    }

}
