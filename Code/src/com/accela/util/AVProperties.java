package com.accela.util;

/**
 Accela Automation
 File: AVProperties.java
 Accela, Inc.
 Copyright (C): 2007-2012

 $Id: AVProperties.java 213929 2012-02-17 07:30:15Z ACHIEVO\victor.tan $
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.accela.adapter.constants.AdapterConstants;

/**
 * AVProperties manages Properties for the Accela V360 Architecture.
 * <p>
 * Properties are retrieved using getProperty to retrieve configuration properties. They will be returned with their
 * other string values substituted by other property values. This Facade uses the org.jboss.util.StringPropertyReplacer
 * found in jboss-common.jar to provide the proeprty substitution. Substitution rules: replaces ${key} with the value of
 * property p. Leaves ${key} intact if property not found replaces ${key:default} with the value of property p. Replaces
 * ${key:default} with default if property not found replaces ${/} with the value of
 * System.getProperty("file.separator"); replaces ${:} with the value of System.getProperty("path.separator"); this
 * algorithm is single pass. It will not recursively substitute multiple values. Examples: myPropertyValue =
 * AVProperties.getProperty(name); myPropertyValue = AVProperties.getProperty(name, defaultValue);
 * 
 * @author Vernon Crandall
 * @since 6.4.1
 */
public class AVProperties
{
	// WARNING: Do not use AVLogger in this class! AVLogger will be dependent (indirectly) on this class.
	// private static AVLogger logger = AVLogger.getLogger(AVProperties.class);
	private static final Log LOGGER = LogFactory.getLog(AVProperties.class);

	/**
	 * start with an empty Properties instance for graceful error handling.
	 */
	private static Properties props = new Properties();

	private static String govxmlURL;
	
	private static String cersGetURL;
	
	private static String cersPostURL;
	
	/**
	 * Static initializer
	 */
	static
	{
		try
		{
			FileInputStream file;		  
		    String path = "./config/ServerConfig.properties";		   
		    file = new FileInputStream(path);
			props.load(file);
			govxmlURL = getBizServerURL()+"/wireless/GovXMLServlet";
			cersGetURL=AVProperties.getProperty(AdapterConstants.CERS_SERVER)+"/Regulator/FacilitySubmittal/Query?regulatorCode="+AVProperties.getProperty(AdapterConstants.CERS_REGULATORCODE)+"&status=4";
			cersPostURL=AVProperties.getProperty(AdapterConstants.CERS_SERVER)+"/Regulator/CME/Submit?regulatorCode="+AVProperties.getProperty(AdapterConstants.CERS_REGULATORCODE);
		}
		catch (IOException e)
		{
			LOGGER.error("Load ServerConfig.properties failed", e);
			//e.printStackTrace();
		}
	}

	/**
	 * Get Property with all variables substituted by other properties. This is done non-recursively.
	 * 
	 * @param name - name of property
	 * @return property value or null if not found
	 * @see #getProperty
	 * @see #getURLProperty
	 * @see #getRawProperty
	 */
	public static String getProperty(final String name)
	{
		return props.getProperty(name);
	}

	/**
	 * Gets the bool property.
	 * 
	 * @param name the name
	 * 
	 * @return the bool property
	 */
	public static Boolean getBoolProperty(final String name)
	{
		return Boolean.valueOf(props.getProperty(name));
	}
	
	/**
	 * Gets the int property.
	 * 
	 * @param name the name
	 * 
	 * @return the int property
	 */
	public static int getIntProperty(final String name)
	{
		try
		{
			return Integer.valueOf(props.getProperty(name));
		}
		catch (NumberFormatException e)
		{
			return 0;
		}
	}
	/**
	 * Set Property programatically. Allows overriding of system/server property for testing purposes.
	 * 
	 * @param name - name of property
	 * @param value - new value of property
	 * @return previous property value or null if not found
	 */
	public static String setProperty(final String name, final String value)
	{
		return (String) props.setProperty(name, value);
	}

	/**
	 * Get Property with all variables substituted by other properties. This is done non-recursively.
	 * 
	 * @param name - name of property
	 * @param defaultValue - default value if property not found
	 * @return property value or defaultValue if not found
	 * @see #getProperty
	 * @see #getURLProperty
	 * @see #getRawProperty
	 */
	public static String getProperty(final String name, final String defaultValue)
	{
		return props.getProperty(name, defaultValue);
	}

	public static String getBizServerURL()
	{
		return props.getProperty(AdapterConstants.AA_SERVER);
	}

	public static String getGovxmlURL()
	{
		
		return govxmlURL;
	}
	
	
	public static String getAAUser()
	{
		return props.getProperty(AdapterConstants.AA_USER);
	}

	public static String getAAAgency()
	{
		return props.getProperty(AdapterConstants.AA_AGENCY);
	}

	public static String getAAPassword()
	{
		return props.getProperty(AdapterConstants.AA_PASSWORD);
	}
	
	public static String getCersGetURL()
	{
		return cersGetURL;
	}

	public static String getCersPostURL()
	{
		return cersPostURL;
	}

} // -- end class AVProperties

