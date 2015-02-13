package com.accela.adapter.model.cap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: CAPIds.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2012
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: CAPIds.java 72642 2009-01-01 20:01:57Z ACHIEVO\james.jiang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Nov 30, 2012		james.jiang		Initial.
 *  
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "capId"
})
public class CAPIds
{
	@XmlElement(name = "CAPId", required = true)
	protected CAPId capId;

	public CAPId getCapId()
	{
		return capId;
	}

	public void setCapId(CAPId capId)
	{
		this.capId = capId;
	}


}

/*
*$Log: av-env.bat,v $
*/