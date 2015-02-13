package com.accela.adapter.model.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

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
 *         &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DataType">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="inputRange">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="minValue" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                             &lt;element name="maxValue" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="readOnly" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                   &lt;element name="inputRequired" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                   &lt;element name="fieldType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="security" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="drillDown" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *       &lt;attribute name="action" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"keys", "identifierDisplay", "dataType", "name", "value", "security", "drillDown"})
public class AdditionalItem
{

	@XmlElement(name = "Keys", required = true)
	protected Keys keys;

	@XmlElement(name = "IdentifierDisplay", required = true)
	protected String identifierDisplay;

	@XmlElement(name = "DataType", required = true)
	protected DataType dataType;

	@XmlElement(name = "Name", required = true)
	protected String name;

	@XmlElement(name = "Value", required = true)
	protected String value;

	@XmlElement(required = true)
	protected String security;

	protected boolean drillDown;

	@XmlAttribute
	protected String action;

	/**
	 * Gets the value of the keys property.
	 * 
	 * @return possible object is
	 *         {@link GovXML_newCAP.InitiateCAP.AdditionalInformation.AdditionalInformationGroup.AdditionalInformationSubGroup.AdditionalItems.AdditionalItem.Keys }
	 * 
	 */
	public Keys getKeys()
	{
		return keys;
	}

	/**
	 * Sets the value of the keys property.
	 * 
	 * @param value allowed object is
	 *            {@link GovXML_newCAP.InitiateCAP.AdditionalInformation.AdditionalInformationGroup.AdditionalInformationSubGroup.AdditionalItems.AdditionalItem.Keys }
	 * 
	 */
	public void setKeys(Keys value)
	{
		this.keys = value;
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
	 * Gets the value of the dataType property.
	 * 
	 * @return possible object is {@link DataType }
	 * 
	 */
	public DataType getDataType()
	{
		return dataType;
	}

	/**
	 * Sets the value of the dataType property.
	 * 
	 * @param value allowed object is {@link DataType }
	 * 
	 */
	public void setDataType(DataType value)
	{
		this.dataType = value;
	}

	/**
	 * Gets the value of the name property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Sets the value of the name property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setName(String value)
	{
		this.name = value;
	}

	/**
	 * Gets the value of the value property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getValue()
	{
		return value;
	}

	/**
	 * Sets the value of the value property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setValue(String value)
	{
		this.value = value;
	}

	/**
	 * Gets the value of the security property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSecurity()
	{
		return security;
	}

	/**
	 * Sets the value of the security property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setSecurity(String value)
	{
		this.security = value;
	}

	/**
	 * Gets the value of the drillDown property.
	 * 
	 */
	public boolean isDrillDown()
	{
		return drillDown;
	}

	/**
	 * Sets the value of the drillDown property.
	 * 
	 */
	public void setDrillDown(boolean value)
	{
		this.drillDown = value;
	}

	/**
	 * Gets the value of the action property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAction()
	{
		return action;
	}

	/**
	 * Sets the value of the action property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setAction(String value)
	{
		this.action = value;
	}

	public AdditionalItem clone()
	{
		AdditionalItem addItem = new AdditionalItem();
		addItem.keys = this.keys.clone();
		addItem.identifierDisplay = this.identifierDisplay;
		addItem.dataType = this.dataType;
		addItem.name = this.name;
		addItem.value = this.value;
		addItem.security = this.security;
		addItem.drillDown = this.drillDown;
		return addItem;

	}
}