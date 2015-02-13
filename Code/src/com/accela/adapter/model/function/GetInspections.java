package com.accela.adapter.model.function;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.accela.adapter.model.cap.CAPId;
import com.accela.adapter.model.cap.CAPIds;
import com.accela.adapter.model.cap.CAPTypeIds;
import com.accela.adapter.model.common.ReturnElements;
import com.accela.adapter.model.common.System;
import com.accela.adapter.model.inspection.InspectionDateRanges;
import com.accela.adapter.model.inspection.InspectionStatus;
import com.accela.adapter.model.inspection.InspectionTypes;
import com.accela.adapter.model.inspection.ScheduledDateRanges;

/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="System">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="XMLVersion" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                   &lt;element name="ServiceProviderCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Username" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="MaxRows" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="StartRow" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="EndRow" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="TotalRows" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="ApplicationState" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                   &lt;element name="Context" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="LanguageID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Contacts" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;element name="InspectionTypes">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="InspectionType">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Keys">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="autoAssign" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="scheduledDateRanges">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="DateRange">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="from" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                             &lt;element name="to" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="InspectionStatus">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Keys">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="returnElements">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="returnElement" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CAPTypeIds">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="CAPTypeId">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Keys">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "system",
    "contacts",
    "inspectionTypes",
    "inspectionDateRanges",
    "scheduledDateRanges",
    "inspectionStatus",
    "returnElements",
    "capTypeIds",
    "capId"
})
public class GetInspections {

    @XmlElement(name = "System", required = true)
    protected System system;
    @XmlElement(name = "Contacts", required = true)
    protected Object contacts;
    @XmlElement(name = "InspectionTypes", required = true)
    protected InspectionTypes inspectionTypes;
    @XmlElement(required = true)
    protected InspectionDateRanges inspectionDateRanges;
    @XmlElement(required = false)
    protected ScheduledDateRanges scheduledDateRanges;
    @XmlElement(name = "InspectionStatus", required = true)
    protected InspectionStatus inspectionStatus;
    @XmlElement(required = true)
    protected ReturnElements returnElements;
    @XmlElement(name = "CAPTypeIds", required = true)
    protected CAPTypeIds capTypeIds;
    @XmlElement(name = "CAPId", required = true)
    protected CAPId capId;

    /**
     * Gets the value of the system property.
     * 
     * @return
     *     possible object is
     *     {@link GovXML_getInsp.GetInspections.System }
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
     *     {@link GovXML_getInsp.GetInspections.System }
     *     
     */
    public void setSystem(System value) {
        this.system = value;
    }

    /**
     * Gets the value of the contacts property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getContacts() {
        return contacts;
    }

    /**
     * Sets the value of the contacts property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setContacts(Object value) {
        this.contacts = value;
    }

    /**
     * Gets the value of the inspectionTypes property.
     * 
     * @return
     *     possible object is
     *     {@link InspectionTypes }
     *     
     */
    public InspectionTypes getInspectionTypes() {
        return inspectionTypes;
    }

    /**
     * Sets the value of the inspectionTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link InspectionTypes }
     *     
     */
    public void setInspectionTypes(InspectionTypes value) {
        this.inspectionTypes = value;
    }

    /**
     * Gets the value of the scheduledDateRanges property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduledDateRanges }
     *     
     */
    public ScheduledDateRanges getScheduledDateRanges() {
        return scheduledDateRanges;
    }

    /**
     * Sets the value of the scheduledDateRanges property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduledDateRanges }
     *     
     */
    public void setScheduledDateRanges(ScheduledDateRanges value) {
        this.scheduledDateRanges = value;
    }
    /**
     * Gets the value of the inspectionDateRanges property.
     * 
     * @return
     *     possible object is
     *     {@link InspectionDateRanges }
     *     
     */
    public InspectionDateRanges getInspectionDateRanges() {
        return inspectionDateRanges;
    }

    /**
     * Sets the value of the inspectionDateRanges property.
     * 
     * @param value
     *     allowed object is
     *     {@link InspectionDateRanges }
     *     
     */
    public void setInspectionRanges(InspectionDateRanges value) {
        this.inspectionDateRanges = value;
    }
    /**
     * Gets the value of the inspectionStatus property.
     * 
     * @return
     *     possible object is
     *     {@link InspectionStatus }
     *     
     */
    public InspectionStatus getInspectionStatus() {
        return inspectionStatus;
    }

    /**
     * Sets the value of the inspectionStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link InspectionStatus }
     *     
     */
    public void setInspectionStatus(InspectionStatus value) {
        this.inspectionStatus = value;
    }

    /**
     * Gets the value of the returnElements property.
     * 
     * @return
     *     possible object is
     *     {@link GovXML_getInsp.GetInspections.ReturnElements }
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
     *     {@link GovXML_getInsp.GetInspections.ReturnElements }
     *     
     */
    public void setReturnElements(ReturnElements value) {
        this.returnElements = value;
    }

    /**
     * Gets the value of the capTypeIds property.
     * 
     * @return
     *     possible object is
     *     {@link GovXML_getInsp.GetInspections.CAPTypeIds }
     *     
     */
    public CAPTypeIds getCAPTypeIds() {
        return capTypeIds;
    }

    /**
     * Sets the value of the capTypeIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link GovXML_getInsp.GetInspections.CAPTypeIds }
     *     
     */
    public void setCAPTypeIds(CAPTypeIds value) {
        this.capTypeIds = value;
    }

    public CAPId getCapId()
	{
		return capId;
	}

	public void setCapId(CAPId capId)
	{
		this.capId = capId;
	}
}