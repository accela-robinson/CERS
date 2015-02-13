package com.accela.adapter.model.cap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.accela.adapter.model.common.Keys;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TrackingNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Keys" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Key" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
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
@XmlType(name = "", propOrder = {"identifierDisplay", "trackingNumber", "keys", "value"})
public class CAPId
{

	@XmlElement(name = "IdentifierDisplay")
	protected String identifierDisplay;

	@XmlElement(name = "TrackingNumber")
	protected String trackingNumber;

	@XmlElement(name = "Keys")
	protected List<Keys> keys;

	@XmlElement(name = "Value")
	protected String value;

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	/**
	 * Gets the value of the identifierDisplay property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getIdentifierDisplay()
	{
		return identifierDisplay;
	}

	/**
	 * Sets the value of the identifierDisplay property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setIdentifierDisplay(String value)
	{
		this.identifierDisplay = value;
	}

	/**
	 * Gets the value of the trackingNumber property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTrackingNumber()
	{
		return trackingNumber;
	}

	/**
	 * Sets the value of the trackingNumber property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setTrackingNumber(String value)
	{
		this.trackingNumber = value;
	}

	/**
	 * Gets the value of the keys property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
	 * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
	 * the keys property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getKeys().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link CAPId.Keys }
	 * 
	 * 
	 */
	public List<Keys> getKeys()
	{
		if (keys == null)
		{
			keys = new ArrayList<Keys>();
		}
		return this.keys;
	}
     @Override
	public String toString()
	{
		if (keys != null&&keys.get(0)!=null&&keys.get(0).getKey()!=null)
		{
			return Arrays.toString(keys.get(0).getKey().toArray());
		}
		else
		{
			return super.toString();
		}
	}

}