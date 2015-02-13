package com.accela.adapter.model.function;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.accela.adapter.model.cap.CAPIds;
import com.accela.adapter.model.cap.CAPStatuses;
import com.accela.adapter.model.cap.CAPTypeIds;
import com.accela.adapter.model.cap.ParentCAPId;
import com.accela.adapter.model.common.DateRange;
import com.accela.adapter.model.common.ReturnElements;
import com.accela.adapter.model.common.StatusDateRange;
import com.accela.adapter.model.common.SubsidiaryCAPId;
import com.accela.adapter.model.common.System;

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
 *         &lt;element name="StatusDateRange">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="from" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element name="to" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CAPStatuses">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="CAPStatus">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Keys">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
 *         &lt;element name="parentCAPId">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Keys">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
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
 *         &lt;element name="subsidiaryCAPId">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Keys">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
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
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="useCachedCAPs" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="withOpenInspectionsOnly" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "returnElements",
    "capIds",
    "capTypeIds",
    "statusDateRange",
    "capStatuses",
    "parentCAPId",
    "subsidiaryCAPId",
    "type",
    "useCachedCAPs",
    "withOpenInspectionsOnly","dateRange"
})
public class GetCAPs {

    @XmlElement(name = "System", required = true)
    protected System system;
    @XmlElement(required = true)
    protected ReturnElements returnElements;
    @XmlElement(name = "CAPIds", required = true)
    protected CAPIds capIds;
	@XmlElement(name = "CAPTypeIds", required = true)
    protected CAPTypeIds capTypeIds;
    @XmlElement(name = "StatusDateRange", required = true)
    protected StatusDateRange statusDateRange;
    @XmlElement(name = "CAPStatuses", required = true)
    protected CAPStatuses capStatuses;
    @XmlElement(required = true)
    protected ParentCAPId parentCAPId;
    @XmlElement(required = true)
    protected SubsidiaryCAPId subsidiaryCAPId;
    @XmlElement(required = true)
    protected String type;
    @XmlElement(required = true)
    protected String useCachedCAPs;
    protected boolean withOpenInspectionsOnly;

    @XmlElement(name = "DateRange", required = true)
    protected DateRange dateRange;

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
     * Gets the value of the capTypeIds property.
     * 
     * @return
     *     possible object is
     *     {@link CAPTypeIds }
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
     *     {@link CAPTypeIds }
     *     
     */
    public void setCAPTypeIds(CAPTypeIds value) {
        this.capTypeIds = value;
    }

    /**
     * Gets the value of the statusDateRange property.
     * 
     * @return
     *     possible object is
     *     {@link StatusDateRange }
     *     
     */
    public StatusDateRange getStatusDateRange() {
        return statusDateRange;
    }

    /**
     * Sets the value of the statusDateRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusDateRange }
     *     
     */
    public void setStatusDateRange(StatusDateRange value) {
        this.statusDateRange = value;
    }

    /**
     * Gets the value of the capStatuses property.
     * 
     * @return
     *     possible object is
     *     {@link CAPStatuses }
     *     
     */
    public CAPStatuses getCAPStatuses() {
        return capStatuses;
    }

    /**
     * Sets the value of the capStatuses property.
     * 
     * @param value
     *     allowed object is
     *     {@link CAPStatuses }
     *     
     */
    public void setCAPStatuses(CAPStatuses value) {
        this.capStatuses = value;
    }

    /**
     * Gets the value of the parentCAPId property.
     * 
     * @return
     *     possible object is
     *     {@link ParentCAPId }
     *     
     */
    public ParentCAPId getParentCAPId() {
        return parentCAPId;
    }

    /**
     * Sets the value of the parentCAPId property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParentCAPId }
     *     
     */
    public void setParentCAPId(ParentCAPId value) {
        this.parentCAPId = value;
    }

    /**
     * Gets the value of the subsidiaryCAPId property.
     * 
     * @return
     *     possible object is
     *     {@link SubsidiaryCAPId }
     *     
     */
    public SubsidiaryCAPId getSubsidiaryCAPId() {
        return subsidiaryCAPId;
    }

    /**
     * Sets the value of the subsidiaryCAPId property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubsidiaryCAPId }
     *     
     */
    public void setSubsidiaryCAPId(SubsidiaryCAPId value) {
        this.subsidiaryCAPId = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the useCachedCAPs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUseCachedCAPs() {
        return useCachedCAPs;
    }

    /**
     * Sets the value of the useCachedCAPs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUseCachedCAPs(String value) {
        this.useCachedCAPs = value;
    }

    /**
     * Gets the value of the withOpenInspectionsOnly property.
     * 
     */
    public boolean isWithOpenInspectionsOnly() {
        return withOpenInspectionsOnly;
    }

    /**
     * Sets the value of the withOpenInspectionsOnly property.
     * 
     */
    public void setWithOpenInspectionsOnly(boolean value) {
        this.withOpenInspectionsOnly = value;
    }

    public CAPIds getCapIds()
	{
		return capIds;
	}

	public void setCapIds(CAPIds capIds)
	{
		this.capIds = capIds;
	}
}