package com.accela.adapter.model.inspection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

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
 *         &lt;element name="autoAssign" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "keys",
    "autoAssign"
})
public class InspectionType {

    @XmlElement(name = "Keys", required = true)
    protected Keys keys;
    protected boolean autoAssign;

    /**
     * Gets the value of the keys property.
     * 
     * @return
     *     possible object is
     *     {@link GovXML_getInsp.GetInspections.InspectionTypes.InspectionType.Keys }
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
     *     {@link GovXML_getInsp.GetInspections.InspectionTypes.InspectionType.Keys }
     *     
     */
    public void setKeys(Keys value) {
        this.keys = value;
    }

    /**
     * Gets the value of the autoAssign property.
     * 
     */
    public boolean isAutoAssign() {
        return autoAssign;
    }

    /**
     * Sets the value of the autoAssign property.
     * 
     */
    public void setAutoAssign(boolean value) {
        this.autoAssign = value;
    }

}