package com.accela.adapter.model.cap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.accela.adapter.model.common.Keys;
import com.accela.adapter.model.function.GovXML;

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
 *                   &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "keys","value"
		
})
public class CAPStatus {

    @XmlElement(name = "Keys", required = true)
    protected Keys keys;
    
    @XmlElement(name = "value", required = true)
    protected String value;

    

	/**
     * Gets the value of the keys property.
     * 
     * @return
     *     possible object is
     *     {@link GovXML.GetCAPs.CAPStatuses.CAPStatus.Keys }
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
     *     {@link GovXML.GetCAPs.CAPStatuses.CAPStatus.Keys }
     *     
     */
    public void setKeys(Keys value) {
        this.keys = value;
    }

    public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}
}