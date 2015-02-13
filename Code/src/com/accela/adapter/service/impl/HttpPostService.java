package com.accela.adapter.service.impl;

import java.io.IOException;
import java.net.URLEncoder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.accela.adapter.constants.AdapterConstants;
import com.accela.adapter.model.function.GovXML;
import com.accela.adapter.util.CommonUtil;
import com.accela.adapter.util.NetUtil;
import com.accela.util.AVProperties;

/**
 * <pre>
 *
 *  Accela Automation
 *  File: HttpPostService.java
 *
 *  Accela, Inc.
 *  Copyright (C): 2012
 *
 *  Description:
 *  TODO
 *
 *  Notes:
 * 	$Id: HttpPostService.java 72642 2009-01-01 20:01:57Z ACHIEVO\evan.cai $
 *
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Nov 28, 2012		evan.cai		Initial.
 *
 * </pre>
 */
public class HttpPostService
{
	private static final String govxmlURL = AVProperties.getGovxmlURL();

	private static final Log LOGGER = LogFactory.getLog(HttpPostService.class);

	/**
	 * Gets the http post response str.
	 *
	 * @param postStr the post str
	 *
	 * @return the http post response str
	 *
	 * @throws Exception the exception
	 */
	public static String getHttpPostResponseStr(String postStr) throws Exception
	{
		return getHttpPostResponseStr(govxmlURL, postStr, "UTF-8");
	}

	/**
	 * Gets the gov xml response.
	 *
	 * @param postStr the post str
	 *
	 * @return the gov xml response
	 *
	 * @throws Exception the exception
	 */
	public static GovXML getGovXMLResponse(String postStr, Boolean... bls) throws Exception
	{
		String response = null;

		if ( Boolean.getBoolean("testing.aacers") ) {
			// TEST ONLY
			String fileName = null;
			if ( postStr.indexOf("AuthenticateUser") > 0 ) {
				fileName = "AuthenticateUserResponse.xml";
			}
			else if ( postStr.indexOf("GetAdditionalInformationGroups") > 0 && postStr.indexOf("<Key>Facility</Key>") > 0) {
				fileName = "GetAdditionalInformationGroupsResponse_LUEG-DEH-HMD-UPFP-Facility.xml";
			}
			else if ( postStr.indexOf("GetAdditionalInformationGroups") > 0 && postStr.indexOf("<Key>Chemical</Key>") > 0) {
				fileName = "GetAdditionalInformationGroupsResponse_LUEG-DEH-HMD-UPFP-Chemical.xml";
			}
			else if ( postStr.indexOf("GetAdditionalInformationGroups") > 0 && postStr.indexOf("<Key>UST</Key>") > 0) {
				fileName = "GetAdditionalInformationGroupsResponse_LUEG-DEH-HMD-UPFP-UST.xml";
			}
			else if ( postStr.indexOf("GetAdditionalInformationGroups") > 0 && postStr.indexOf("<Key>Waste</Key>") > 0) {
				fileName = "GetAdditionalInformationGroupsResponse_LUEG-DEH-HMD-UPFP-Waste.xml";
			}
			else if ( postStr.indexOf("GetCAPs") > 0 ) {
				fileName = "GetCAPsResponse.xml";
			}
			else if ( postStr.indexOf("GetInspections") > 0 ) {
				fileName = "GetInspectionsResponse.xml";
			}
			else if ( postStr.indexOf("GetInspections") > 0 &&
					postStr.indexOf("<CAPTypeId><Keys><Key>LUEG-DEH</Key><Key>HMD</Key><Key>Enforcement</Key><Key>Case</Key></Keys></CAPTypeId>") >0
				) {
				fileName = "GetEnforcementsResponse.xml";
			}
			
			if ( fileName != null ) {
				try {
					java.io.FileInputStream fin = new java.io.FileInputStream(fileName);
					byte[] content = new byte[4000*1024];
					int length = fin.read(content);
					fin.close();
					response = new String(content, 0, length);
				}catch(Exception e) {
					LOGGER.warn("Failed to response " + e);
					response = null;
				}
			}
		}

		if ( response == null ) {
			response = getHttpPostResponseStr(govxmlURL, postStr, "UTF-8", bls);
		}

		return CommonUtil.unMarshalGovXML(response);
	}

	public static GovXML doPostGovmxl(GovXML request, Boolean... bls) throws Exception
	{
		String requestxml = CommonUtil.marshalGovXML(request);
		GovXML response = getGovXMLResponse(requestxml, bls);
		return response;
	}

	/**
	 * Make HTTP/POST connection to a network URL and return the response content as a string.
	 *
	 * @param urlStr the target URL.
	 * @param postStr the posted request data string.
	 * @param encoding the expected response content encoding, e.g. "UTF-8", and use the default encoding if it is null.
	 * @return the response content string.
	 */
	public static String getHttpPostResponseStr(String urlStr, String requestStr, String encoding, Boolean... bls)
			throws Exception, IOException
	{

		boolean printDocument = false;
		if (bls != null && bls.length > 0)
		{
			printDocument = bls[0];
		}

		String postStr = null;
		String responseStr = null;
		try {
			postStr = AdapterConstants.GOVXML_KEY + "=" + URLEncoder.encode(requestStr, encoding) + "&"
					+ AdapterConstants.ORIGIN_KEY + "="; // + AdapterConstants.ORIGIN_VALUE;
			responseStr = NetUtil.getHttpPostResponseStr(urlStr, postStr, encoding);
		}
		finally 
		{
			// log even if exception happens
			if (responseStr!= null && (!responseStr.contains("<Error>") || responseStr.contains("<ErrorCode>0</ErrorCode>")))
			{
				printDebug(requestStr, responseStr, printDocument);
			}
			else
			{
				printWarn(requestStr, responseStr, printDocument);
			}
		}
		return responseStr;
	}

	private static void printDebug(String requestStr, String responseStr, boolean printDocument)
	{
		if (!printDocument)
		{
			LOGGER.debug("--------request xml---------\r\n\r\n" + requestStr);
			LOGGER.debug("--------response xml---------\r\n\r\n" + responseStr);
		}
		else
		{
			if (requestStr != null && requestStr.length() > 4096)
			{
				String beStr = requestStr.substring(0, 2048);
				String enStr = requestStr.substring(requestStr.length() - 1024, requestStr.length());
				LOGGER.debug("--------request xml---------\r\n\r\n" + beStr + "\r\n.............\r\n" + enStr);
				LOGGER.debug("--------response xml---------\r\n\r\n" + responseStr);
				LOGGER.debug(" log total length of the request: " + requestStr.length() / 1024 + "K");
			}
			else
			{
				LOGGER.debug("--------request xml---------\r\n\r\n" + requestStr);
				LOGGER.debug("--------response xml---------\r\n\r\n" + responseStr);
			}
		}
	}

	private static void printWarn(String requestStr, String responseStr, boolean printDocument)
	{
		if (!printDocument)
		{
			LOGGER.warn("--------request xml---------\r\n\r\n" + requestStr);
			LOGGER.warn("--------response xml---------\r\n\r\n" + responseStr);
		}
		else
		{
			if (requestStr != null && requestStr.length() > 4096)
			{
				String beStr = requestStr.substring(0, 2048);
				String enStr = requestStr.substring(requestStr.length() - 1024, requestStr.length());
				LOGGER.warn("--------request xml---------\r\n\r\n" + beStr + "\r\n.............\r\n" + enStr);
				LOGGER.warn("--------response xml---------\r\n\r\n" + responseStr);
				LOGGER.warn(" log total length of the request: " + requestStr.length() / 1024 + "K");
			}
			else
			{
				LOGGER.warn("--------request xml---------\r\n\r\n" + requestStr);
				LOGGER.warn("--------response xml---------\r\n\r\n" + responseStr);
			}

		}
	}

}

/*
 * $Log: av-env.bat,v $
 */