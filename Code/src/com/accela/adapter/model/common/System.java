package com.accela.adapter.model.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

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
 *         &lt;element name="XMLVersion" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="ServiceProviderCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Username" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MaxRows" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *         &lt;element name="StartRow" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *         &lt;element name="EndRow" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *         &lt;element name="TotalRows" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *         &lt;element name="ApplicationState" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Context" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="LanguageID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Error" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ErrorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ErrorMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "xmlVersion",
    "serviceProviderCode",
    "username",
    "maxRows",
    "startRow",
    "endRow",
    "totalRows",
    "applicationState",
    "context",
    "languageID",
    "error"
})
public class System {

    @XmlElement(name = "XMLVersion")
    @XmlSchemaType(name = "unsignedShort")
    protected int xmlVersion;
    @XmlElement(name = "ServiceProviderCode", required = true)
    protected String serviceProviderCode;
    @XmlElement(name = "Username", required = true)
    protected String username;
    @XmlElement(name = "MaxRows")
    @XmlSchemaType(name = "unsignedByte")
    protected short maxRows;
    @XmlElement(name = "StartRow")
    @XmlSchemaType(name = "unsignedByte")
    protected short startRow;
    @XmlElement(name = "EndRow")
    @XmlSchemaType(name = "unsignedByte")
    protected short endRow;
    @XmlElement(name = "TotalRows")
    @XmlSchemaType(name = "unsignedByte")
    protected short totalRows;
    @XmlElement(name = "ApplicationState", required = true)
    protected String applicationState;
    @XmlElement(name = "Context", required = true)
    protected String context;
    @XmlElement(name = "LanguageID", required = true)
    protected String languageID;
    @XmlElement(name = "Error")
    protected Error error;

    /**
     * Gets the value of the xmlVersion property.
     * 
     */
    public int getXMLVersion() {
        return xmlVersion;
    }

    /**
     * Sets the value of the xmlVersion property.
     * 
     */
    public void setXMLVersion(int value) {
        this.xmlVersion = value;
    }

    /**
     * Gets the value of the serviceProviderCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceProviderCode() {
        return serviceProviderCode;
    }

    /**
     * Sets the value of the serviceProviderCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceProviderCode(String value) {
        this.serviceProviderCode = value;
    }

    /**
     * Gets the value of the username property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the value of the username property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername(String value) {
        this.username = value;
    }

    /**
     * Gets the value of the maxRows property.
     * 
     */
    public short getMaxRows() {
        return maxRows;
    }

    /**
     * Sets the value of the maxRows property.
     * 
     */
    public void setMaxRows(short value) {
        this.maxRows = value;
    }

    /**
     * Gets the value of the startRow property.
     * 
     */
    public short getStartRow() {
        return startRow;
    }

    /**
     * Sets the value of the startRow property.
     * 
     */
    public void setStartRow(short value) {
        this.startRow = value;
    }

    /**
     * Gets the value of the endRow property.
     * 
     */
    public short getEndRow() {
        return endRow;
    }

    /**
     * Sets the value of the endRow property.
     * 
     */
    public void setEndRow(short value) {
        this.endRow = value;
    }

    /**
     * Gets the value of the totalRows property.
     * 
     */
    public short getTotalRows() {
        return totalRows;
    }

    /**
     * Sets the value of the totalRows property.
     * 
     */
    public void setTotalRows(short value) {
        this.totalRows = value;
    }

    /**
     * Gets the value of the applicationState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicationState() {
        return applicationState;
    }

    /**
     * Sets the value of the applicationState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicationState(String value) {
        this.applicationState = value;
    }

    /**
     * Gets the value of the context property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContext() {
        return context;
    }

    /**
     * Sets the value of the context property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContext(String value) {
        this.context = value;
    }

    /**
     * Gets the value of the languageID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguageID() {
        return languageID;
    }

    /**
     * Sets the value of the languageID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguageID(String value) {
        this.languageID = value;
    }

    /**
     * Gets the value of the error property.
     * 
     * @return
     *     possible object is
     *     {@link Error }
     *     
     */
    public Error getError() {
        return error;
    }

    /**
     * Sets the value of the error property.
     * 
     * @param value
     *     allowed object is
     *     {@link Error }
     *     
     */
    public void setError(Error value) {
        this.error = value;
    }

}