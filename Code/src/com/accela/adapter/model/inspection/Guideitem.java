package com.accela.adapter.model.inspection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import com.accela.adapter.model.common.AdditionalInformation;
import com.accela.adapter.model.common.Keys;

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
 *         &lt;element name="globalId" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;element name="ownerHistory" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;element name="Keys">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="contextType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DescriptionEnumeration">
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
 *                   &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="Time" type="{http://www.w3.org/2001/XMLSchema}time"/>
 *         &lt;element name="DataType">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *         &lt;element name="Text" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="applicability" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Status">
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
 *                   &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="EnumerationType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="StatusEnumerationListId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="applicabilityEnumerationListId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="violationCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="class" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="carryOverFlag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AdditionalInformation">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="AdditionalInformationGroup" maxOccurs="unbounded">
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
 *                             &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="addRemoveSubGroups" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                             &lt;element name="AdditionalInformationSubGroup" maxOccurs="unbounded">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Keys">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="AdditionalItems">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="AdditionalItem" maxOccurs="unbounded">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="Keys">
 *                                                             &lt;complexType>
 *                                                               &lt;complexContent>
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                   &lt;sequence>
 *                                                                     &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                   &lt;/sequence>
 *                                                                 &lt;/restriction>
 *                                                               &lt;/complexContent>
 *                                                             &lt;/complexType>
 *                                                           &lt;/element>
 *                                                           &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="DataType">
 *                                                             &lt;complexType>
 *                                                               &lt;complexContent>
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                   &lt;sequence>
 *                                                                     &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                     &lt;element name="enumeration" minOccurs="0">
 *                                                                       &lt;complexType>
 *                                                                         &lt;complexContent>
 *                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                             &lt;sequence>
 *                                                                               &lt;element name="String" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                                                                             &lt;/sequence>
 *                                                                           &lt;/restriction>
 *                                                                         &lt;/complexContent>
 *                                                                       &lt;/complexType>
 *                                                                     &lt;/element>
 *                                                                     &lt;element name="inputRange">
 *                                                                       &lt;complexType>
 *                                                                         &lt;complexContent>
 *                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                             &lt;sequence>
 *                                                                               &lt;element name="minValue" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                                                                               &lt;element name="maxValue" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                                                                             &lt;/sequence>
 *                                                                           &lt;/restriction>
 *                                                                         &lt;/complexContent>
 *                                                                       &lt;/complexType>
 *                                                                     &lt;/element>
 *                                                                     &lt;element name="readOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                                                                     &lt;element name="Enumerations" minOccurs="0">
 *                                                                       &lt;complexType>
 *                                                                         &lt;complexContent>
 *                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                             &lt;sequence>
 *                                                                               &lt;element name="Enumeration" maxOccurs="unbounded">
 *                                                                                 &lt;complexType>
 *                                                                                   &lt;complexContent>
 *                                                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                       &lt;sequence>
 *                                                                                         &lt;element name="Keys">
 *                                                                                           &lt;complexType>
 *                                                                                             &lt;complexContent>
 *                                                                                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                                 &lt;sequence>
 *                                                                                                   &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                                 &lt;/sequence>
 *                                                                                               &lt;/restriction>
 *                                                                                             &lt;/complexContent>
 *                                                                                           &lt;/complexType>
 *                                                                                         &lt;/element>
 *                                                                                         &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                       &lt;/sequence>
 *                                                                                     &lt;/restriction>
 *                                                                                   &lt;/complexContent>
 *                                                                                 &lt;/complexType>
 *                                                                               &lt;/element>
 *                                                                             &lt;/sequence>
 *                                                                           &lt;/restriction>
 *                                                                         &lt;/complexContent>
 *                                                                       &lt;/complexType>
 *                                                                     &lt;/element>
 *                                                                     &lt;element name="inputRequired" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                                                                     &lt;element name="fieldType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                   &lt;/sequence>
 *                                                                 &lt;/restriction>
 *                                                               &lt;/complexContent>
 *                                                             &lt;/complexType>
 *                                                           &lt;/element>
 *                                                           &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="security" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="drillDown" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="security" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                     &lt;/sequence>
 *                                     &lt;attribute name="action" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="security" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
 *         &lt;element name="critical" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "globalId",
    "ownerHistory",
    "keys",
    "identifierDisplay",
    "contextType",
    "description",
    "descriptionEnumeration",
    "date",
    "time",
    "dataType",
    "value",
    "text",
    "applicability",
    "status",
    "statusEnumerationListId",
    "applicabilityEnumerationListId",
    "violationCode",
    "clazz",
    "carryOverFlag",
    "additionalInformation",
    "critical"
})
public class Guideitem {

    @XmlElement(required = true)
    protected Object globalId;
    @XmlElement(required = true)
    protected Object ownerHistory;
    @XmlElement(name = "Keys", required = true)
    protected Keys keys;
    @XmlElement(name = "IdentifierDisplay")
    @XmlSchemaType(name = "unsignedShort")
    protected int identifierDisplay;
    @XmlElement(required = true)
    protected String contextType;
    @XmlElement(name = "Description", required = true)
    protected String description;
    @XmlElement(name = "DescriptionEnumeration", required = true)
    protected DescriptionEnumeration descriptionEnumeration;
    @XmlElement(name = "Date", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar date;
    @XmlElement(name = "Time", required = true)
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar time;
    @XmlElement(name = "DataType", required = true)
    protected DataType dataType;
    @XmlElement(name = "Value")
    @XmlSchemaType(name = "unsignedByte")
    protected short value;
    @XmlElement(name = "Text", required = true)
    protected String text;
    @XmlElement(required = true)
    protected String applicability;
    @XmlElement(name = "Status", required = true)
    protected Status status;
    @XmlElement(name = "StatusEnumerationListId", required = true)
    protected String statusEnumerationListId;
    @XmlElement(required = true)
    protected String applicabilityEnumerationListId;
    @XmlElement(required = true)
    protected String violationCode;
    @XmlElement(name = "class", required = true)
    protected String clazz;
    @XmlElement(required = true)
    protected String carryOverFlag;
    @XmlElement(name = "AdditionalInformation", required = true)
    protected AdditionalInformation additionalInformation;
    @XmlElement(required = true)
    protected String critical;

    /**
     * Gets the value of the globalId property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getGlobalId() {
        return globalId;
    }

    /**
     * Sets the value of the globalId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setGlobalId(Object value) {
        this.globalId = value;
    }

    /**
     * Gets the value of the ownerHistory property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getOwnerHistory() {
        return ownerHistory;
    }

    /**
     * Sets the value of the ownerHistory property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setOwnerHistory(Object value) {
        this.ownerHistory = value;
    }

    /**
     * Gets the value of the keys property.
     * 
     * @return
     *     possible object is
     *     {@link Inspection.Guidesheets.Guidesheet.Guideitems.Guideitem.Keys }
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
     *     {@link Inspection.Guidesheets.Guidesheet.Guideitems.Guideitem.Keys }
     *     
     */
    public void setKeys(Keys value) {
        this.keys = value;
    }

    /**
     * Gets the value of the identifierDisplay property.
     * 
     */
    public int getIdentifierDisplay() {
        return identifierDisplay;
    }

    /**
     * Sets the value of the identifierDisplay property.
     * 
     */
    public void setIdentifierDisplay(int value) {
        this.identifierDisplay = value;
    }

    /**
     * Gets the value of the contextType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContextType() {
        return contextType;
    }

    /**
     * Sets the value of the contextType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContextType(String value) {
        this.contextType = value;
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
     * Gets the value of the descriptionEnumeration property.
     * 
     * @return
     *     possible object is
     *     {@link DescriptionEnumeration }
     *     
     */
    public DescriptionEnumeration getDescriptionEnumeration() {
        return descriptionEnumeration;
    }

    /**
     * Sets the value of the descriptionEnumeration property.
     * 
     * @param value
     *     allowed object is
     *     {@link DescriptionEnumeration }
     *     
     */
    public void setDescriptionEnumeration(DescriptionEnumeration value) {
        this.descriptionEnumeration = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Gets the value of the time property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTime() {
        return time;
    }

    /**
     * Sets the value of the time property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTime(XMLGregorianCalendar value) {
        this.time = value;
    }

    /**
     * Gets the value of the dataType property.
     * 
     * @return
     *     possible object is
     *     {@link DataType }
     *     
     */
    public DataType getDataType() {
        return dataType;
    }

    /**
     * Sets the value of the dataType property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataType }
     *     
     */
    public void setDataType(DataType value) {
        this.dataType = value;
    }

    /**
     * Gets the value of the value property.
     * 
     */
    public short getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     */
    public void setValue(short value) {
        this.value = value;
    }

    /**
     * Gets the value of the text property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the value of the text property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setText(String value) {
        this.text = value;
    }

    /**
     * Gets the value of the applicability property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicability() {
        return applicability;
    }

    /**
     * Sets the value of the applicability property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicability(String value) {
        this.applicability = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link Status }
     *     
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link Status }
     *     
     */
    public void setStatus(Status value) {
        this.status = value;
    }

    /**
     * Gets the value of the statusEnumerationListId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusEnumerationListId() {
        return statusEnumerationListId;
    }

    /**
     * Sets the value of the statusEnumerationListId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusEnumerationListId(String value) {
        this.statusEnumerationListId = value;
    }

    /**
     * Gets the value of the applicabilityEnumerationListId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicabilityEnumerationListId() {
        return applicabilityEnumerationListId;
    }

    /**
     * Sets the value of the applicabilityEnumerationListId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicabilityEnumerationListId(String value) {
        this.applicabilityEnumerationListId = value;
    }

    /**
     * Gets the value of the violationCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getViolationCode() {
        return violationCode;
    }

    /**
     * Sets the value of the violationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setViolationCode(String value) {
        this.violationCode = value;
    }

    /**
     * Gets the value of the clazz property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClazz() {
        return clazz;
    }

    /**
     * Sets the value of the clazz property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClazz(String value) {
        this.clazz = value;
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
     * Gets the value of the additionalInformation property.
     * 
     * @return
     *     possible object is
     *     {@link Inspection.Guidesheets.Guidesheet.Guideitems.Guideitem.AdditionalInformation }
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
     *     {@link Inspection.Guidesheets.Guidesheet.Guideitems.Guideitem.AdditionalInformation }
     *     
     */
    public void setAdditionalInformation(AdditionalInformation value) {
        this.additionalInformation = value;
    }

    /**
     * Gets the value of the critical property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCritical() {
        return critical;
    }

    /**
     * Sets the value of the critical property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCritical(String value) {
        this.critical = value;
    }

}