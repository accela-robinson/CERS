package com.accela.adapter.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.accela.adapter.constants.AdapterConstants;
import com.accela.adapter.model.function.GovXML;
import com.accela.cers.cap.model.RegulatorFacilitySubmittals;
import com.accela.util.AVProperties;

// TODO: Auto-generated Javadoc
/**
 * <pre>
 * 
 * Accela Automation
 * File: CommonUtil.java
 * 
 * Accela, Inc.
 * Copyright (C): 2012
 * 
 * Description:
 * TODO
 * 
 * Notes:
 * $Id: CommonUtil.java 72642 2009-01-01 20:01:57Z ACHIEVO\james.jiang $
 * 
 * Revision History
 * &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 * Nov 29, 2012		james.jiang		Initial.
 * 
 * </pre>
 */
public class CommonUtil
{

	/**
	 * Marshal gov xml.
	 * 
	 * @param govXML the gov xml
	 * 
	 * @return the string
	 * 
	 * @throws JAXBException the JAXB exception
	 */
	private static Log LOGGER = LogFactory.getLog(CommonUtil.class);;

	public static String marshalGovXML(GovXML govXML) throws JAXBException
	{
		JAXBContext context = JAXBContext.newInstance(GovXML.class);
		Marshaller marshaller = context.createMarshaller();
		StringWriter stringWriter = new StringWriter();
		marshaller.marshal(govXML, stringWriter);
		return stringWriter.toString();
	}

	/**
	 * Un marshal gov xml.
	 * 
	 * @param xmlstr the xmlstr
	 * 
	 * @return the gov xml
	 * 
	 * @throws JAXBException the JAXB exception
	 */
	public static GovXML unMarshalGovXML(String xmlstr) throws JAXBException
	{
		JAXBContext context = JAXBContext.newInstance(GovXML.class);
		Unmarshaller unMarshaller = context.createUnmarshaller();
		GovXML govXML = (GovXML) unMarshaller.unmarshal(new StringReader(xmlstr));
		return govXML;
	}

	/**
	 * Un marshal cers.
	 * 
	 * @return the regulator facility submittals
	 * 
	 * @throws Exception the exception
	 */
	public static RegulatorFacilitySubmittals unMarshalCERS(java.io.InputStream in) throws Exception
	{
		JAXBContext context = JAXBContext.newInstance(RegulatorFacilitySubmittals.class);
		Unmarshaller unMarshaller = context.createUnmarshaller();
		BufferedReader br;

		StringBuilder sb = new StringBuilder();
		br = new BufferedReader(new InputStreamReader(in));
		NetUtil.readThruBuffer(br, sb);
		LOGGER.info("get xml data from cers:\n");
		LOGGER.info(sb);
		RegulatorFacilitySubmittals cers = (RegulatorFacilitySubmittals) unMarshaller.unmarshal(new StringReader(sb
				.toString()));
		return cers;
	}

	/**
	 * Gets the http url conn.
	 * 
	 * @param url the url
	 * 
	 * @return the http url conn
	 * 
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	static HttpURLConnection getHttpURLConn(URL url) throws IOException
	{
		HttpURLConnection urlcon;
		if (AVProperties.getBoolProperty(AdapterConstants.CERS_SERVER_PROXY_SET))
		{
			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(
					AVProperties.getProperty(AdapterConstants.CERS_SERVER_PROXY_HOST),
					AVProperties.getIntProperty(AdapterConstants.CERS_SERVER_PROXY_PORT)));
			urlcon = (HttpURLConnection) url.openConnection(proxy);
		}
		else
		{

			urlcon = (HttpURLConnection) url.openConnection();
		}
		return urlcon;
	}

}

/*
 * $Log: av-env.bat,v $
 */