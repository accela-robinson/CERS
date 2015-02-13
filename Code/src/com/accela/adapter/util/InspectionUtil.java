package com.accela.adapter.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;

import com.accela.adapter.constants.AdapterConstants;
import com.accela.adapter.model.cap.CAPId;
import com.accela.adapter.model.cap.CAPTypeId;
import com.accela.adapter.model.cap.CAPTypeIds;
import com.accela.adapter.model.common.DateRange;
import com.accela.adapter.model.common.Keys;
import com.accela.adapter.model.common.ReturnElements;
import com.accela.adapter.model.function.GetInspections;
import com.accela.adapter.model.function.GovXML;
import com.accela.adapter.model.inspection.InspectionDateRanges;
import com.accela.adapter.model.inspection.InspectionSheet;
import com.accela.adapter.model.inspection.InspectionStatus;
import com.accela.adapter.model.inspection.Inspections;
import com.accela.adapter.service.impl.AuthService;
import com.accela.adapter.service.impl.HttpPostService;
import com.accela.cers.DateConvertUtil;
import com.accela.cers.inspection.model.CMEHeaderType;
import com.accela.cers.inspection.model.CMESubmittalsType;
import com.accela.cers.response.CMESubmittalResponse;

/**
 * <pre>
 *
 *  Accela Automation
 *  File: InspectionUtil.java
 *
 *  Accela, Inc.
 *  Copyright (C): 2012-2014
 *
 *  Description:
 *  TODO
 *
 *  Notes:
 * 	$Id: InspectionUtil.java 72642 2009-01-01 20:01:57Z ACHIEVO\evan.cai $
 *
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Nov 30, 2012		evan.cai		Initial.
 *
 * </pre>
 */
public class InspectionUtil
{
	private static Logger logger = Logger.getLogger(InspectionUtil.class);

	public static GovXML getInspectionRequest(String fromdate, String date)
	{
		GovXML getInspectionsRequest = new GovXML();
		GetInspections getInspections = new GetInspections();

		// 1. Get System Information(logic information)
		getInspections.setSystem(AuthService.getSystem());

		// 2.0 Get record Types.
		CAPTypeId capTypeId = CapUtil.getCapTypeIdByString(AdapterConstants.FACILITY_SUBMIT_TALTYPE);
		CAPTypeIds capTypeIds = new CAPTypeIds();
		capTypeIds.getCAPTypeId().add(capTypeId);
		getInspections.setCAPTypeIds(capTypeIds);

		// 3.0 Get inspection status.
		InspectionStatus status = new InspectionStatus();
		Keys keys = new Keys();
		keys.getKey().add(AdapterConstants.COMPLETE);
		keys.getKey().add(AdapterConstants.INSPECTION_STATUS_DELETE);
		keys.getKey().add(AdapterConstants.INSPECTION_STATUS_NO_VIOLATIONS);
		status.setKeys(keys);
		status.setKeys(keys);
		getInspections.setInspectionStatus(status);

		// Get inspection schedule date.
		InspectionDateRanges inspectionDateRange = new InspectionDateRanges();
		DateRange dateRnage = new DateRange();

		dateRnage.setFrom(fromdate);

		dateRnage.setTo(date);
		inspectionDateRange.setDateRange(dateRnage);
		getInspections.setInspectionRanges(inspectionDateRange);

		// Set Inspection return elements.
		ReturnElements returnElements = new ReturnElements();
		returnElements.getReturnElement().add(AdapterConstants.CAPIDS);
		getInspections.setReturnElements(returnElements);

		getInspectionsRequest.setGetInspections(getInspections);
		return getInspectionsRequest;
	}

	public static GovXML getInspectionRequestByCapAltId(List<String> capIds)
	{
		GovXML getInspectionsRequest = new GovXML();
		GetInspections getInspections = new GetInspections();

		// 1. Get System Information(logic information)
		getInspections.setSystem(AuthService.getSystem());

		// 2.0 Get record Types.
		CAPTypeId capTypeId = CapUtil.getCapTypeIdByString(AdapterConstants.FACILITY_SUBMIT_TALTYPE);
		CAPTypeIds capTypeIds = new CAPTypeIds();
		capTypeIds.getCAPTypeId().add(capTypeId);
		getInspections.setCAPTypeIds(capTypeIds);

		// 3.0 Get inspection status.
		InspectionStatus status = new InspectionStatus();
		Keys keys = new Keys();
		keys.getKey().add(AdapterConstants.COMPLETE);
		keys.getKey().add(AdapterConstants.INSPECTION_STATUS_DELETE);
		keys.getKey().add(AdapterConstants.INSPECTION_STATUS_NO_VIOLATIONS);
		status.setKeys(keys);
		status.setKeys(keys);
		getInspections.setInspectionStatus(status);

		CAPId capId = new CAPId();
		Keys keys4CapID = new Keys();
		keys4CapID.getKey().addAll(capIds);
		capId.getKeys().add(keys4CapID);
		getInspections.setCapId(capId);

		// Set Inspection return elements.
		ReturnElements returnElements = new ReturnElements();
		returnElements.getReturnElement().add(AdapterConstants.CAPIDS);
		getInspections.setReturnElements(returnElements);

		getInspectionsRequest.setGetInspections(getInspections);
		return getInspectionsRequest;
	}
	
	public static Inspections getInspectionByCapAltId(List<String> capIds) throws Exception
	{
		Inspections inspections = null;
        GovXML response = HttpPostService.doPostGovmxl(getInspectionRequestByCapAltId(capIds));
		if (response != null && response.getGetInspectionsResponse().getInspectionSheets() != null
				&& response.getGetInspectionsResponse().getInspectionSheets().getInspectionSheet() != null
				&& response.getGetInspectionsResponse().getInspectionSheets().getInspectionSheet().size()>0)
		{
			inspections = new Inspections();
			for (InspectionSheet inspectionSheet : response.getGetInspectionsResponse().getInspectionSheets().getInspectionSheet())
			{
				if(inspectionSheet!=null && inspectionSheet.getInspections()!=null
						&& inspectionSheet.getInspections().getInspection()!=null
						&& inspectionSheet.getInspections().getInspection().size()>0)
				{
					inspections.getInspection().addAll(inspectionSheet.getInspections().getInspection());
				}

			}
		}

		return inspections;
	}

	/**
	 * Marshal submittals.
	 *
	 * @param cmeSubmittalsType the cme submittals type
	 * @param out the out
	 *
	 * @throws JAXBException the JAXB exception
	 */
	public static void marshalSubmittals(CMESubmittalsType cmeSubmittalsType, OutputStream out) throws JAXBException
	{
		JAXBContext context = JAXBContext.newInstance(CMESubmittalsType.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.marshal(cmeSubmittalsType, out);
	}

	private static final Log LOGGER = LogFactory.getLog(InspectionUtil.class);

	/**
	 * Upload.
	 *
	 * @param uploadURL the upload url
	 * @param cmeSubmittalsType the cme submittals type
	 *
	 * @return the string
	 *
	 * @throws Exception the exception
	 */
	public static void upload(String uploadURL, CMESubmittalsType cmeSubmittalsType) throws Exception
	{

		HttpURLConnection conn = null;
		OutputStream out = null;
		BufferedReader in = null;
		StringBuilder sb = new StringBuilder(1024);
		String stringOut = null;

		try
		{
			URL url = new URL(uploadURL);
			conn = CommonUtil.getHttpURLConn(url);
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("Authorization", AdapterConstants.AUTH_INFO);
			// Get the output stream to the server
			out = conn.getOutputStream();
			stringOut = marshalRequest(cmeSubmittalsType);

			marshalSubmittals(cmeSubmittalsType, out);
			out.close();
			// Get the input stream from the server
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), AdapterConstants.ENCODING));
			// Receive the response from the server

			NetUtil.readThruBuffer(in, sb);
			// LOGGER.debug("upload xml with response:\r\n" + sb);
			// Receive the response from the server
			CMESubmittalResponse response = unMarshalRes(sb);

			if (response == null)
			{
				// unexpected marshell error
				throw new Exception ("Unexpected CME error.");
			}
			else if ( response.getSummary() != null && response.getSummary().getErrorSummary() != null && response.getSummary().getErrorSummary().length() > 0 ) {
				// error, need to alert
				throw new Exception (response.getSummary().getErrorSummary());
			}
			else if ( response.getSummary() != null && response.getSummary().getRequiredSummary() != null && response.getSummary().getRequiredSummary().length() > 0 ) {
				// error, need to alert
				throw new Exception (response.getSummary().getRequiredSummary());
			}
			else {
				// success
				LOGGER.info("CERS request xml:\n" + stringOut);
				LOGGER.info("CERS reponse xml:\n" + sb.toString());
			}
		}
		catch (Exception e)
		{

			LOGGER.warn("CERS request xml:\n" + stringOut);
			LOGGER.warn("CERS reponse xml:\n" + sb.toString());

			LOGGER.error("CME submittal exception.", e);
			throw e;
		}
		finally
		{
			// Close the input stream and the network connection
			if (in != null)
				in.close();
			if (out != null)
				out.close();
			if (conn != null)
				conn.disconnect();
		}
	}

	public static String marshalRequest(CMESubmittalsType cmeSubmittalsType) throws JAXBException
	{
		JAXBContext context = JAXBContext.newInstance(CMESubmittalsType.class);
		Marshaller marshaller = context.createMarshaller();
		StringWriter stringOut = new StringWriter();
		marshaller.marshal(cmeSubmittalsType, stringOut);
		return stringOut.toString();
	}

	public static CMESubmittalResponse unMarshalRes(StringBuilder sb) throws JAXBException
	{
		JAXBContext context = JAXBContext.newInstance(CMESubmittalResponse.class);
		Unmarshaller unMarshaller = context.createUnmarshaller();
		StringReader reader = new StringReader(sb.toString());
		CMESubmittalResponse response = (CMESubmittalResponse) unMarshaller.unmarshal(reader);
		return response;
	}

	public static CMEHeaderType getEnforcementHeader(boolean isApproveStatus)
	{
		
		CMEHeaderType enforcementHeader = new CMEHeaderType();
		if(isApproveStatus)
		{
			enforcementHeader.setCMEDataStatus(AdapterConstants.CME_DATA_STATUS_TYPE_APPROVE);
		}
		else
		{
			enforcementHeader.setCMEDataStatus(AdapterConstants.CME_DATA_STATUS_TYPE_DELETE);
		}
		enforcementHeader.setRegulatorActionDateTime(DateConvertUtil.dateTime(new Date()));
		enforcementHeader.setRegulatorCode(AdapterConstants.REGULATOR_CODE);
		return enforcementHeader;
	}

	public static BigInteger convertStringToBigInteger(String value)
	{
		BigInteger bigInteger = null;
		try
		{
			bigInteger = new BigInteger(value);
		}
		catch (Exception e)
		{
			bigInteger = null;
			logger.info("Data Convert Error from String to BigInteger, It may be caused by the error configuration.");
		}
		return bigInteger;
	}
}

/*
 * $Log: av-env.bat,v $
 */
