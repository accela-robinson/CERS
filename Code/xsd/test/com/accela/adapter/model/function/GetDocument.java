//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.12.04 at 06:33:27 PM CST 
//


package com.accela.adapter.model.function;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getDocument complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getDocument">
 *   &lt;complexContent>
 *     &lt;extension base="{}operationRequest">
 *       &lt;sequence>
 *         &lt;element name="documentId" type="{}documentId" minOccurs="0"/>
 *         &lt;element name="edmsAdapter" type="{}edmsAdapter" minOccurs="0"/>
 *         &lt;element name="objectId" type="{}objectId" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getDocument", propOrder = {
    "documentId",
    "edmsAdapter",
    "objectId"
})
public class GetDocument
    extends OperationRequest
{

    protected DocumentId documentId;
    protected EdmsAdapter edmsAdapter;
    protected ObjectId objectId;

    /**
     * Gets the value of the documentId property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentId }
     *     
     */
    public DocumentId getDocumentId() {
        return documentId;
    }

    /**
     * Sets the value of the documentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentId }
     *     
     */
    public void setDocumentId(DocumentId value) {
        this.documentId = value;
    }

    /**
     * Gets the value of the edmsAdapter property.
     * 
     * @return
     *     possible object is
     *     {@link EdmsAdapter }
     *     
     */
    public EdmsAdapter getEdmsAdapter() {
        return edmsAdapter;
    }

    /**
     * Sets the value of the edmsAdapter property.
     * 
     * @param value
     *     allowed object is
     *     {@link EdmsAdapter }
     *     
     */
    public void setEdmsAdapter(EdmsAdapter value) {
        this.edmsAdapter = value;
    }

    /**
     * Gets the value of the objectId property.
     * 
     * @return
     *     possible object is
     *     {@link ObjectId }
     *     
     */
    public ObjectId getObjectId() {
        return objectId;
    }

    /**
     * Sets the value of the objectId property.
     * 
     * @param value
     *     allowed object is
     *     {@link ObjectId }
     *     
     */
    public void setObjectId(ObjectId value) {
        this.objectId = value;
    }

}
