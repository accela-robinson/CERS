package com.accela.adapter.model.Address;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: ElectronicMailAddresses.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2012
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: ElectronicMailAddresses.java 72642 2009-01-01 20:01:57Z ACHIEVO\james.jiang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Nov 30, 2012		james.jiang		Initial.
 *  
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "string"
})
public class ElectronicMailAddresses
{
	 @XmlElement(name = "String")    
	    protected List<String> string;

	    /**
	     * Gets the value of the string property.
	     * 
	     */
	    public List<String> getString() {
	    	if(string==null){
	    		string= new ArrayList<String>();
	    	}
	        return string;
	    }

	    /**
	     * Sets the value of the string property.
	     * 
	     */
	    public void setString(List<String> value) {
	        this.string = value;
	    }
}

/*
*$Log: av-env.bat,v $
*/