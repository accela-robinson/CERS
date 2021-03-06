//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.12.04 at 06:33:27 PM CST 
//


package com.accela.adapter.model.function;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for operationRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="operationRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="system" type="{}system" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "operationRequest", propOrder = {
    "system"
})
@XmlSeeAlso({
    GetAssetCAStatus.class,
    PostPayment.class,
    GetAssets.class,
    GetDepartments.class,
    DeleteDocument.class,
    GetPartInventory.class,
    GetTimeAccountingGroups.class,
    GetStandardChoices.class,
    GetDocumentList.class,
    GetInspectionUnitNumbers.class,
    GetAssetCATypes.class,
    GetInvoices.class,
    PostTransactionLog.class,
    GetTimeAccountingTypes.class,
    LocatingCAPs.class,
    GetDocumentGroups.class,
    CountDailyRecords.class,
    UpdateAssetCA.class,
    GetAuditLogs.class,
    CreateAsset.class,
    GetAssetTypes.class,
    GetAvailableInspectionDates.class,
    UpdateDocument.class,
    GetEDMSAdapters.class,
    UpdateAsset.class,
    GetCostTypes.class,
    GetCAPDetail.class,
    GetDocument.class,
    GetAssetCAs.class,
    CreateDocument.class,
    GetContacts.class,
    GetPartTypes.class
})
public class OperationRequest {

    protected System system;

    /**
     * Gets the value of the system property.
     * 
     * @return
     *     possible object is
     *     {@link System }
     *     
     */
    public System getSystem() {
        return system;
    }

    /**
     * Sets the value of the system property.
     * 
     * @param value
     *     allowed object is
     *     {@link System }
     *     
     */
    public void setSystem(System value) {
        this.system = value;
    }

}
