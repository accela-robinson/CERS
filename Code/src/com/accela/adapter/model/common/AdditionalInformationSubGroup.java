package com.accela.adapter.model.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *                   &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}byte" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/>
 *         &lt;element name="AdditionalItems">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="AdditionalItem" maxOccurs="unbounded">
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
 *                             &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="DataType">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="inputRange">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="minValue" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                                                 &lt;element name="maxValue" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="readOnly" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                                       &lt;element name="inputRequired" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                                       &lt;element name="fieldType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="security" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="drillDown" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                           &lt;/sequence>
 *                           &lt;attribute name="action" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="security" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;attribute name="action" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"keys", "identifierDisplay", "additionalItems", "security"})
public class AdditionalInformationSubGroup
{

	@XmlElement(name = "Keys", required = true)
	protected Keys keys;

	@XmlElement(name = "IdentifierDisplay")
	@XmlSchemaType(name = "unsignedByte")
	protected Short identifierDisplay;

	@XmlElement(name = "AdditionalItems", required = true)
	protected AdditionalItems additionalItems;

	@XmlElement(required = true)
	protected String security;

	@XmlAttribute(required = true)
	protected String action;

	@XmlAttribute(required = true)
	protected String type;

	/**
	 * Gets the value of the keys property.
	 * 
	 * @return possible object is
	 *         {@link GovXML_newCAP.InitiateCAP.AdditionalInformation.AdditionalInformationGroup.AdditionalInformationSubGroup.Keys }
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
	 *            {@link GovXML_newCAP.InitiateCAP.AdditionalInformation.AdditionalInformationGroup.AdditionalInformationSubGroup.Keys }
	 * 
	 */
	public void setKeys(Keys value)
	{
		this.keys = value;
	}

	/**
	 * Gets the value of the identifierDisplay property.
	 * 
	 * @return possible object is {@link Short }
	 * 
	 */
	public Short getIdentifierDisplay()
	{
		return identifierDisplay;
	}

	/**
	 * Sets the value of the identifierDisplay property.
	 * 
	 * @param value allowed object is {@link Short }
	 * 
	 */
	public void setIdentifierDisplay(Short value)
	{
		this.identifierDisplay = value;
	}

	/**
	 * Gets the value of the additionalItems property.
	 * 
	 * @return possible object is {@link AdditionalItems }
	 * 
	 */
	public AdditionalItems getAdditionalItems()
	{
		return additionalItems;
	}

	/**
	 * Sets the value of the additionalItems property.
	 * 
	 * @param value allowed object is {@link AdditionalItems }
	 * 
	 */
	public void setAdditionalItems(AdditionalItems value)
	{
		this.additionalItems = value;
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

	/**
	 * Gets the value of the type property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getType()
	{
		return type;
	}

	/**
	 * Sets the value of the type property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setType(String value)
	{
		this.type = value;
	}

	public AdditionalInformationSubGroup clone()
	{
		AdditionalInformationSubGroup ais = new AdditionalInformationSubGroup();
		ais.keys = this.keys.clone();
		ais.identifierDisplay = this.identifierDisplay;
		ais.additionalItems = this.additionalItems.clone();
		ais.security = this.security;
		ais.action = this.action;
		ais.type = this.type;
		return ais;
	}

}