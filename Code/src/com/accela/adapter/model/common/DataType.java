package com.accela.adapter.model.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="inputRange">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="minValue" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="maxValue" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="readOnly" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="inputRequired" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="fieldType" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "type",
    "inputRange",
    "readOnly",
    "inputRequired",
    "fieldType"
})
public class DataType {

    @XmlElement(required = true)
    protected String type;
    @XmlElement(required = true)
    protected InputRange inputRange;
    protected boolean readOnly;
    protected boolean inputRequired;
    @XmlElement(required = true)
    protected String fieldType;

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
     * Gets the value of the inputRange property.
     * 
     * @return
     *     possible object is
     *     {@link InputRange }
     *     
     */
    public InputRange getInputRange() {
        return inputRange;
    }

    /**
     * Sets the value of the inputRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link InputRange }
     *     
     */
    public void setInputRange(InputRange value) {
        this.inputRange = value;
    }

    /**
     * Gets the value of the readOnly property.
     * 
     */
    public boolean isReadOnly() {
        return readOnly;
    }

    /**
     * Sets the value of the readOnly property.
     * 
     */
    public void setReadOnly(boolean value) {
        this.readOnly = value;
    }

    /**
     * Gets the value of the inputRequired property.
     * 
     */
    public boolean isInputRequired() {
        return inputRequired;
    }

    /**
     * Sets the value of the inputRequired property.
     * 
     */
    public void setInputRequired(boolean value) {
        this.inputRequired = value;
    }

    /**
     * Gets the value of the fieldType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFieldType() {
        return fieldType;
    }

    /**
     * Sets the value of the fieldType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFieldType(String value) {
        this.fieldType = value;
    }

}