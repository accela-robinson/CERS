package com.accela.adapter.model.contact;

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
 *         &lt;element name="ActorRole">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="role" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="userDefinedRole" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "actorRole"
})
public class Roles {

    @XmlElement(name = "ActorRole", required = true)
    protected ActorRole actorRole;

    /**
     * Gets the value of the actorRole property.
     * 
     * @return
     *     possible object is
     *     {@link ActorRole }
     *     
     */
    public ActorRole getActorRole() {
        return actorRole;
    }

    /**
     * Sets the value of the actorRole property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActorRole }
     *     
     */
    public void setActorRole(ActorRole value) {
        this.actorRole = value;
    }

}