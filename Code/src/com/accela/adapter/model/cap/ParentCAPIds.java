package com.accela.adapter.model.cap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.accela.adapter.model.Address.DetailAddress;

// TODO: Auto-generated Javadoc
/**
 * <pre>
 * 
 * Accela Automation
 * File: ParentCAPIds.java
 * 
 * Accela, Inc.
 * Copyright (C): 2012
 * 
 * Description:
 * TODO
 * 
 * Notes:
 * $Id: ParentCAPIds.java 72642 2009-01-01 20:01:57Z ACHIEVO\evan.cai $
 * 
 * Revision History
 * &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 * Nov 30, 2012		evan.cai		Initial.
 * 
 * </pre>
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "capId"
})
public class ParentCAPIds
{
	
	/** The parent cap id. */
	@XmlElement(name = "CAPId", required = true)
	protected CAPId capId;

	/**
	 * @return the capId
	 */
	public CAPId getCapId()
	{
		return capId;
	}

	/**
	 * @param capId the capId to set
	 */
	public void setCapId(CAPId capId)
	{
		this.capId = capId;
	}
	
}

/*
*$Log: av-env.bat,v $
*/