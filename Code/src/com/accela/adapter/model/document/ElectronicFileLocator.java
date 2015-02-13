package com.accela.adapter.model.document;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import com.accela.adapter.model.common.Keys;

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
 *         &lt;element name="fileName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fileSize" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
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
    "keys",   
    "fileName",
    "fileDateTime",
    "fileSize",
    "fileType",
    "fileLocation",      
    "serverAddress",
    "serverType",
    "serverVendor",
    "filename",
    "globalId",
    "identifierDisplay",
    "contextType",      
    "serverDescription",
    "serverPlatform"
    
    
})
public class ElectronicFileLocator {

	@XmlElement(name = "fileName",required = true)
    protected String fileName;
    @XmlSchemaType(name = "fileSize")
    protected double fileSize;
    @XmlElement(name = "ContextType", required = true)
    protected String contextType;
    @XmlElement(name = "fileDateTime", required = true)
    protected String fileDateTime;
    @XmlElement(name = "FileLocation", required = true)
    protected String fileLocation;
    @XmlElement(name = "fileType", required = true)
    protected String fileType;
    @XmlElement(name = "filename", required = true)
    protected String filename;
    protected String globalId;
    protected String identifierDisplay;
    @XmlElement(name = "Keys", required = true)
    protected Keys keys;
    @XmlElement(name = "serverAddress", required = true)
    protected String serverAddress;
    @XmlElement(name = "ServerDescription", required = true)
    protected String serverDescription;
    @XmlElement(name = "ServerPlatform", required = true)
    protected String serverPlatform;
    @XmlElement(name = "serverType", required = true)
    protected String serverType;
    @XmlElement(name = "serverVendor", required = true)
    protected String serverVendor;
    
    public String getContextType()
	{
		return contextType;
	}

	public void setContextType(String contextType)
	{
		this.contextType = contextType;
	}

	public String getFileDateTime()
	{
		return fileDateTime;
	}

	public void setFileDateTime(String fileDateTime)
	{
		this.fileDateTime = fileDateTime;
	}

	public String getFileLocation()
	{
		return fileLocation;
	}

	public void setFileLocation(String fileLocation)
	{
		this.fileLocation = fileLocation;
	}

	public String getFileType()
	{
		return fileType;
	}

	public void setFileType(String fileType)
	{
		this.fileType = fileType;
	}

	public String getFilename()
	{
		return filename;
	}

	public void setFilename(String filename)
	{
		this.filename = filename;
	}

	public String getGlobalId()
	{
		return globalId;
	}

	public void setGlobalId(String globalId)
	{
		this.globalId = globalId;
	}

	public String getIdentifierDisplay()
	{
		return identifierDisplay;
	}

	public void setIdentifierDisplay(String identifierDisplay)
	{
		this.identifierDisplay = identifierDisplay;
	}

	public Keys getKeys()
	{
		return keys;
	}

	public void setKeys(Keys keys)
	{
		this.keys = keys;
	}

	public String getServerAddress()
	{
		return serverAddress;
	}

	public void setServerAddress(String serverAddress)
	{
		this.serverAddress = serverAddress;
	}

	public String getServerDescription()
	{
		return serverDescription;
	}

	public void setServerDescription(String serverDescription)
	{
		this.serverDescription = serverDescription;
	}

	public String getServerPlatform()
	{
		return serverPlatform;
	}

	public void setServerPlatform(String serverPlatform)
	{
		this.serverPlatform = serverPlatform;
	}

	public String getServerType()
	{
		return serverType;
	}

	public void setServerType(String serverType)
	{
		this.serverType = serverType;
	}

	public String getServerVendor()
	{
		return serverVendor;
	}

	public void setServerVendor(String serverVendor)
	{
		this.serverVendor = serverVendor;
	}



    /**
     * Gets the value of the fileName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Sets the value of the fileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileName(String value) {
        this.fileName = value;
    }

    /**
     * Gets the value of the fileSize property.
     * 
     */
    public double getFileSize() {
        return fileSize;
    }

    /**
     * Sets the value of the fileSize property.
     * 
     */
    public void setFileSize(double value) {
        this.fileSize = value;
    }

}