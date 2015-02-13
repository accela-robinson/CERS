package com.accela.cers.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

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
 *         &lt;element name="GuidanceMessage" maxOccurs="unbounded" minOccurs="0" form="unqualified">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="guidanceCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="level" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="entityResource" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="regulatorKey" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
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
    "guidanceMessage"
})
public class GuidanceMessages {

    @XmlElement(name = "GuidanceMessage", nillable = true)
    protected List<GuidanceMessages.GuidanceMessage> guidanceMessage;

    /**
     * Gets the value of the guidanceMessage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the guidanceMessage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGuidanceMessage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GuidanceMessages.GuidanceMessage }
     * 
     * 
     */
    public List<GuidanceMessages.GuidanceMessage> getGuidanceMessage() {
        if (guidanceMessage == null) {
            guidanceMessage = new ArrayList<GuidanceMessages.GuidanceMessage>();
        }
        return this.guidanceMessage;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attribute name="guidanceCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="level" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="entityResource" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="regulatorKey" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class GuidanceMessage {

        @XmlValue
        protected String value;
        @XmlAttribute
        protected String guidanceCode;
        @XmlAttribute
        protected String level;
        @XmlAttribute
        protected String entityResource;
        @XmlAttribute
        protected String regulatorKey;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the guidanceCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getGuidanceCode() {
            return guidanceCode;
        }

        /**
         * Sets the value of the guidanceCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setGuidanceCode(String value) {
            this.guidanceCode = value;
        }

        /**
         * Gets the value of the level property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLevel() {
            return level;
        }

        /**
         * Sets the value of the level property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLevel(String value) {
            this.level = value;
        }

        /**
         * Gets the value of the entityResource property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEntityResource() {
            return entityResource;
        }

        /**
         * Sets the value of the entityResource property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEntityResource(String value) {
            this.entityResource = value;
        }

        /**
         * Gets the value of the regulatorKey property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRegulatorKey() {
            return regulatorKey;
        }

        /**
         * Sets the value of the regulatorKey property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRegulatorKey(String value) {
            this.regulatorKey = value;
        }

    }

}