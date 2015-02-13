package com.accela.adapter.model.cap;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="CAPRelation">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="CAPId">
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
 *                             &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="contextType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="action" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
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
@XmlType(name = "", propOrder = {"capRelation"})
public class CAPRelations
{

	@XmlElement(name = "CAPRelation", required = true)
	protected List<CAPRelation> capRelation;

	/**
	 * Gets the value of the capRelation property.
	 * 
	 * @return possible object is {@link CAPRelation }
	 * 
	 */
	public List<CAPRelation> getCAPRelation()
	{
		if (capRelation == null)
		{
			capRelation = new ArrayList<CAPRelation>();
		}
		return capRelation;
	}

	/**
	 * Sets the value of the capRelation property.
	 * 
	 * @param value allowed object is {@link CAPRelation }
	 * 
	 */
	public void setCAPRelation(List<CAPRelation> value)
	{
		this.capRelation = value;
	}

	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		if (capRelation != null && capRelation.size() != 0)
		{
			for (int i = 0; i < capRelation.size(); i++)
			{
				CAPRelation capr = capRelation.get(i);
				if (capr != null)
					if (i != capRelation.size() - 1)
					{
						sb.append(capr.getCAPId().toString() + ",");
					}
					else
					{
						sb.append(capr.getCAPId().toString());
					}

			}
		}
		return sb.toString();

	}

}