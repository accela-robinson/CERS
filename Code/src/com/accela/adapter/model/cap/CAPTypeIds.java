package com.accela.adapter.model.cap;

import java.util.ArrayList;
import java.util.List;

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
 *         &lt;element name="CAPTypeId">
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
    "capTypeId"
})
public class CAPTypeIds {

    @XmlElement(name = "CAPTypeId", required = true)
    protected List<CAPTypeId> capTypeId;

    /**
     * Gets the value of the capTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link CAPTypeId }
     *     
     */
    public List<CAPTypeId> getCAPTypeId() {
    	if(capTypeId==null){
    		capTypeId= new ArrayList<CAPTypeId>();
    	}
        return capTypeId;
    }

    /**
     * Sets the value of the capTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link CAPTypeId }
     *     
     */
    public void setCAPTypeId(List<CAPTypeId> value) {
        this.capTypeId = value;
    }

}