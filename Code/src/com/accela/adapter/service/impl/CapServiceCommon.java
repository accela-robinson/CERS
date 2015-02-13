package com.accela.adapter.service.impl;

import java.io.File;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.accela.aa.common.ConfigBase;
import com.accela.adapter.constants.AdapterConstants;
import com.accela.adapter.model.cap.CAPId;
import com.accela.adapter.model.cap.CAPRelations;
import com.accela.adapter.model.cap.InitiateCAP;
import com.accela.adapter.model.cap.InitiateCAPResponse;
import com.accela.adapter.model.common.AdditionalInformation;
import com.accela.adapter.model.common.AdditionalInformationGroup;
import com.accela.adapter.model.common.AdditionalInformationSubGroup;
import com.accela.adapter.model.common.AdditionalItem;
import com.accela.adapter.model.common.Error;
import com.accela.adapter.model.common.Keys;
import com.accela.adapter.model.function.GovXML;
import com.accela.adapter.model.function.UpdateCAP;
import com.accela.adapter.model.function.UpdateCAPResponse;
import com.accela.adapter.util.CapUtil;
import com.accela.adapter.util.CommonUtil;
import com.accela.adapter.util.LogPrintUitl;
import com.accela.cers.cap.model.RegulatorFacilitySubmittals;
import com.accela.util.AVProperties;
import com.accela.util.EmailUtil;

/**
 * <pre>
 *
 *  Accela Automation
 *  File: CapServiceCommon.java
 *
 *  Accela, Inc.
 *  Copyright (C): 2012-2013
 *
 *  Description:
 *
 *
 *  Notes:
 * 	$Id: CapServiceCommon.java 72642 2009-01-01 20:01:57Z ACHIEVO\zony.rao $
 *
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  2012-12-13		zony.rao		Initial.
 *
 * </pre>
 */
public class CapServiceCommon
{
	private CapServiceCommon()
	{

	}

	private static CapServiceCommon csc = new CapServiceCommon();

	public static CapServiceCommon getInstance()
	{
		return csc;
	}

	public static final String VERSION = "system.version";

	/** The Constant AV_MAIL_MESSAGE_IMPORT. */
	private static final String AV_MAIL_MESSAGE_IMPORT_ERROR = "av.mail.message.import.error";

	/** The Constant AV_MAIL_SUBJECT_IMPORT. */
	private static final String AV_MAIL_SUBJECT_IMPORT_ERROR = "av.mail.subject.import.error";

	/** The Constant AV_MAIL_MESSAGE_IMPORT. */
	private static final String AV_MAIL_MESSAGE_IMPORT_SUCCESS = "av.mail.message.import.success";

	/** The Constant AV_MAIL_SUBJECT_IMPORT. */
	private static final String AV_MAIL_SUBJECT_IMPORT_SUCCESS = "av.mail.subject.import.success";
	
	/** The Constant AV_MAIL_TO. */
	public static final String AV_MAIL_TO = "av.mail.to";

	/** The Constant AV_MAIL_FROM. */
	public static final String AV_MAIL_FROM = "av.mail.from";

	public final Log LOGGER = LogFactory.getLog(CapServiceCommon.class);

	private ArrayList<String> errorList = new ArrayList<String>();
	private String firstError = null;

	public ConfigBase cb = new ConfigBase("dictionary");

	public final String DEFAULT_DATE_FORMAT = "MM-dd-yyyy HH:mm:ss";

	public final String DEFAULT_DATE_FORMAT_bak = "MM-dd-yyyy";

	public static Map<String, Long> count = new HashMap<String, Long>();

	private Map<String, List<String>> failString = new HashMap<String, List<String>>();
	
	private List<String[]> facilityToSync = new ArrayList<String[]>();
	
	public Map<String, AdditionalInformationGroup> laig = new HashMap<String, AdditionalInformationGroup>();

	public CAPRelations cAPRelations = new CAPRelations();


	/** The Constant format. */
	private final SimpleDateFormat format = new SimpleDateFormat(DEFAULT_DATE_FORMAT);

	private final SimpleDateFormat formatbak = new SimpleDateFormat(DEFAULT_DATE_FORMAT_bak);

	public Map<String, List<AdditionalInformation>> addtion = new HashMap<String, List<AdditionalInformation>>();

	public final static String SUBMITTAL_STATUS = "4";

	public final String types[] = new String[] {"Facility", "Chemical", "UST", "Waste"};

	public void addFacility(int cersId, String altId) {
		facilityToSync.add(new String[] {""+cersId, altId});
	}
	
	public void setFacilityAltId(int cersId, String altId) {
		for(String[] facility : facilityToSync) {
			if ( (""+cersId).equals(facility[0])) {
				facility[1] = altId;
			}
		}
	}
	
	public void addFail(String name, String value)
	{
		if (failString.get(name) == null)
		{
			failString.put(name, new ArrayList<String>());
		}
		List<String> sb = failString.get(name);
		sb.add(value);
	}

	public void addCount(String type)
	{
		if (count.get(type) == null)
		{
			count.put(type, 0L);
		}
		long value = count.get(type) + 1;
		count.put(type, value);
	}

	public void setCount(String type)
	{
		if (count.get(type) == null)
		{
			count.put(type, 0L);
		}

	}

	/**
	 * Log error.
	 *
	 * @param errorstring the errorstring
	 */
	public void logError(String errorstring)
	{
		errorList.add(errorstring);

		if (firstError == null)
		{
			firstError = errorstring;
		}
		LOGGER.error(errorstring);
	}

	public void logError(Exception e, String errorstring)
	{
		errorList.add(errorstring);

		if (firstError == null)
		{
			firstError = errorstring;
		}
		LOGGER.error(errorstring, e);
	}

	public void printSum()
	{
		LOGGER.info("RESULT:\n\r" 
				+ sumFacilities("\n\r") + "\n\r"
				+ LogPrintUitl.getSummaryResult(count, failString) + "\n\r");
	}

	private String sumFacilities(String seperator)
	{
		StringBuilder summaryResult = new StringBuilder();
		for(String[] facility : facilityToSync) {
			summaryResult.append("CERS ID: " + ((facility[0]==null)?"":facility[0]) + ", Record ID: " + ((facility[1]==null)?"":facility[1]))
					.append(seperator);
		}
		return summaryResult.toString();
	}
	
	public void sendMail()
	{
		try
		{
			String facilityList = sumFacilities("<br/>\n\r");
			if ( facilityList.length() == 0 ) {
				facilityList = "N/A";
			}
			
			String resultSummary = count.size()>0?
					LogPrintUitl.getSummaryResult(count, failString, "<br/>\n\r") :
						errorList.size()>0? "Failed" : "Succeded";	// not show confusing message like 0 to sync if there is error like failed to query from CERS
			
			if (failString.size() > 0 || errorList.size() > 0)
			{
				// error alert email
				StringBuilder builder = new StringBuilder();
				if ( errorList.size() > 0 ) {
					for(String error : errorList) {
						builder.append(error).append("<br/>\n\r");
					}
				}
				LOGGER.info("Here is complete list of errors:\n\r" + builder.toString() + "\n\r");
				String errorSummary = (builder.length() > 8192)? builder.substring(0, 8191) + "..."
						: builder.toString();	// not show complete error in email if it's too long >2K
				
				Date now = new Date();
				File[] logfiles = new File[1];
				String logpath = "./log/adapter.log";	// it could be too big in attachment like 20MB, and over mailbox limit
				logfiles[0] = new File(logpath);
				String message = MessageFormat.format(cb.get(AV_MAIL_MESSAGE_IMPORT_ERROR), now,
						facilityList, resultSummary, errorSummary, logfiles[0].getCanonicalPath());
				LOGGER.info("Email sent with message:\n\r" + message + "\n\r");
				
				EmailUtil.sendEmail(AVProperties.getProperty(AV_MAIL_FROM), AVProperties.getProperty(AV_MAIL_TO), "",
					cb.get(AV_MAIL_SUBJECT_IMPORT_ERROR), message, null);	// do not attach log file which could be huge
				
				LOGGER.info("Email sent to: " + AVProperties.getProperty(AV_MAIL_TO));
			}
			else {
				// success notification email
				Date now = new Date();
				String message = MessageFormat.format(cb.get(AV_MAIL_MESSAGE_IMPORT_SUCCESS), now,
						facilityList, resultSummary);
				LOGGER.info("Email sent with message:\n\r" + message + "\n\r");
				
				EmailUtil.sendEmail(AVProperties.getProperty(AV_MAIL_FROM), AVProperties.getProperty(AV_MAIL_TO), "",
					cb.get(AV_MAIL_SUBJECT_IMPORT_SUCCESS), message, null);	// do not attach log file which could be huge
				
				LOGGER.info("Email sent to: " + AVProperties.getProperty(AV_MAIL_TO));
			}

		}
		catch (Exception e)
		{
			LOGGER.error("Send mail failed.", e);
			// e.printStackTrace();
		}
	}

	public RegulatorFacilitySubmittals getData(String[] args) throws Exception
	{

		if ( Boolean.getBoolean("testing.cers") ) {
			java.io.FileInputStream fin = new java.io.FileInputStream("RegulatorFacilitySubmittals.xml");
			RegulatorFacilitySubmittals regulatorFacilitySubmittals = CommonUtil.unMarshalCERS(fin);
			fin.close();
			return regulatorFacilitySubmittals;
		}

		String submittalActionOnStart = "05-01-2012";
		String submittalActionOnEnd = "05-04-2012";

		if (args != null && args.length >= 1)
		{
			Scanner in = new Scanner(System.in);
			submittalActionOnStart = getActionStart(in);
			submittalActionOnEnd = getActionEnd(in);
		}
		else
		{

			int submittalRange = AVProperties.getIntProperty("cers.facility.submittalRange");
			String times[] = AVProperties.getProperty("cers.submittalstartdatetime").split(":");
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(times[0]));
			cal.set(Calendar.MINUTE, Integer.parseInt(times[1]));
			cal.set(Calendar.SECOND, Integer.parseInt(times[2]));
			Date endDate = cal.getTime();
			Date startDate = endDate;
			if (submittalRange != 0)
			{
				Calendar cal2 = Calendar.getInstance();
				cal2.add(Calendar.DAY_OF_MONTH, -1 * submittalRange);
				cal2.set(Calendar.HOUR_OF_DAY, Integer.parseInt(times[0]));
				cal2.set(Calendar.MINUTE, Integer.parseInt(times[1]));
				cal2.set(Calendar.SECOND, Integer.parseInt(times[2]) + 1);
				startDate = cal2.getTime();
			}
			submittalActionOnStart = format.format(startDate);
			submittalActionOnEnd = format.format(endDate);
		}
		setCount(types[0] + ".success");
		setCount(types[0] + ".all");
		if ( AVProperties.getProperty(AdapterConstants.CERS_SERVER) == null || AVProperties.getProperty(AdapterConstants.CERS_SERVER).length() == 0) {
			CapServiceCommon.getInstance().logError(null, "Invalid configuration cers.server in ServerConfig.properties.");
			return null;
		}

		LOGGER.info("Run service use submittalActionOnStart=" + submittalActionOnStart);
		LOGGER.info("Run service use submittalActionOnEnd=" + submittalActionOnEnd);

		@SuppressWarnings("deprecation")
		String requestURL = AVProperties.getCersGetURL() + "&submittalActionOnStart="
				+ java.net.URLEncoder.encode(submittalActionOnStart) + "&submittalActionOnEnd="
				+ java.net.URLEncoder.encode(submittalActionOnEnd);
		LOGGER.info("CERS: start download url:\r\n" + requestURL);

		RegulatorFacilitySubmittals cers = CapUtil.download(requestURL);
		LOGGER.info("CERS: end download");
		return cers;

	}

	/**
	 * Gets the action end.
	 *
	 * @param in the in
	 *
	 * @return the action end
	 */
	private String getActionEnd(Scanner in)
	{
		return getParaFromConsole(in, "submittalActionOnEnd");
	}

	/**
	 * Gets the action start.
	 *
	 * @param in the in
	 *
	 * @return the action start
	 */
	private String getActionStart(Scanner in)
	{
		return getParaFromConsole(in, "submittalActionOnStart");
	}

	/**
	 * Gets the para from console.
	 *
	 * @param in the in
	 * @param paraName the para name
	 *
	 * @return the para from console
	 */
	private String getParaFromConsole(Scanner in, String paraName)
	{
		String resValue = "";
		boolean isValid = false;
		System.out.println("Input " + paraName + "(" + DEFAULT_DATE_FORMAT + ") :");
		while (!isValid)
		{

			resValue = in.nextLine();
			try
			{
				format.parse(resValue);
				isValid = true;
			}
			catch (Exception e)
			{
				try
				{
					resValue = formatbak.format(formatbak.parse(resValue));
					if (paraName.endsWith("Start"))
					{

						resValue += " 00:00:00";
					}
					else
					{
						resValue += " 23:59:59";
					}

					isValid = true;
				}
				catch (Exception e1)
				{
					isValid = false;
					System.out.println("InValid " + paraName + ". Input " + paraName + "(" + DEFAULT_DATE_FORMAT
							+ ") :");
				}

			}
		}
		return resValue;
	}

	/**
	 * Gets the cap id.
	 *
	 * @param capIds the cap ids
	 *
	 * @return the cap id
	 */
	public CAPId getCapId(List<String> capIds)
	{
		CAPId capId = new CAPId();
		Keys keys = new Keys();
		keys.getKey().addAll(capIds);
		capId.getKeys().add(0, keys);
		return capId;
	}

	/**
	 * Call govxml update cap.
	 *
	 * @param updateCap the update cap
	 *
	 * @return the gov xml
	 *
	 * @throws Exception the exception
	 */
	public boolean callGovXMLUpdateCapWithRetry(UpdateCAP updateCap, String sourceName, String sourceKey,
			String cersid, boolean isAdd)
	{
		// start to send data to aa;
		LOGGER.info("Start post data to AA.");
		boolean isok = false;
		if (isAdd)
			addCount(sourceName + ".all");
		//Set the number of retries upon error is 1;
		int reTry = 0;//AVProperties.getIntProperty("cers.facility.reTry");
		Exception latestEx = null;
		for (int i = 0; i < reTry + 1; i++)
		{
			try
			{
				callGovXMLUpdateCap(updateCap);
				isok = true;
				if (isAdd)
				{
					addCount(sourceName + ".success");
					LOGGER.info("Successed to update " + sourceName + " from CERS to AA. " + sourceName + " key:"
							+ sourceKey + "   recordId:"
							+ Arrays.toString(updateCap.getCAPId().getKeys().get(0).getKey().toArray()));
				}
				else
				{
					StringBuilder sb=new StringBuilder();
					sb.append("Successed to related to parent record ");
					sb.append(sourceName);
					if(updateCap.getCAPRelations()!=null&&updateCap.getCAPRelations().getCAPRelation()!=null){
						sb.append(" child recordId:");
						sb.append(Arrays.toString(updateCap.getCAPRelations().getCAPRelation().get(0).getCAPId().getKeys().get(0).getKey().toArray()));
					}
					sb.append(" parent recordId:");
					sb.append(Arrays.toString(updateCap.getCAPId().getKeys().get(0).getKey().toArray()));
					LOGGER.info(sb.toString());
				}
				// start to send data to aa;
				LOGGER.info("End post data to AA.");
				return isok;
			}
			catch (Exception e)
			{
				latestEx = e;
			}
		}
		if (isAdd)
		{
			if (cersid != null)
			{
				addFail(sourceName + ".fail", cersid + "." + sourceKey);
				logError(latestEx, "Failed to update record for cersid: " + cersid + ", " + sourceName + ", key=" + sourceKey + ". " + latestEx.toString());
			}
			else
			{
				addFail(sourceName + ".fail", sourceKey);
				logError(latestEx, "Failed to update record for " + sourceName + ", key=" + sourceKey + ". " + latestEx.toString());				
			}
		}
		else
		{
			// 
			LOGGER.info("Failed to related to parent record. "
					+ " child recordId:"
					+ Arrays.toString(updateCap.getCAPRelations().getCAPRelation().get(0).getCAPId().getKeys().get(0)
							.getKey().toArray()) + " parent recordId:"
					+ Arrays.toString(updateCap.getCAPId().getKeys().get(0).getKey().toArray()));
		}
		LOGGER.info("End post data to AA.");
		return isok;

	}

	public AdditionalInformationGroup getAsitAIG(Collection<AdditionalInformationGroup> addInfoGroup, String groupName,
			String subName)
	{
		for (Iterator<AdditionalInformationGroup> iterGroup = addInfoGroup.iterator(); iterGroup.hasNext();)
		{
			AdditionalInformationGroup addGroup = iterGroup.next();
			List<String> keys = addGroup.getKeys().getKey();
			if (keys.size() == 2 && addGroup.isAddRemoveSubGroups() && keys.get(0).equals(groupName)
					&& keys.get(1).equals(subName))
			{
				return addGroup;
			}
		}
		return null;
	}

	public void setGroupChildId(AdditionalInformationGroup addInfoGroup, String key, String value)
	{
		if (addInfoGroup != null && addInfoGroup.getAdditionalInformationSubGroup() != null)
		{
			List<AdditionalInformationSubGroup> listsub = addInfoGroup.getAdditionalInformationSubGroup();
			for (Iterator<AdditionalInformationSubGroup> iterGroup = listsub.iterator(); iterGroup.hasNext();)
			{
				AdditionalInformationSubGroup addGroup = iterGroup.next();
				List<AdditionalItem> lista = addGroup.getAdditionalItems().getAdditionalItem();
				for (AdditionalItem ai : lista)
				{
					if ("Child Record ID".equals(ai.getKeys().getKey().get(0))) {
						if (key != null && ai != null
								&& key.equals(ai.getValue())) {
							ai.setValue(value);
							break;
						}

					}
				}
				// List<String> keys = addGroup.getKeys().getKey();
				// if (keys.size() == 2 && addGroup.isAddRemoveSubGroups() && keys.get(0).equals(groupName)
				// && keys.get(1).equals(subName))
				// {
				// return addGroup;
				// }
			}
		}
		// return null;
	}

	/**
	 * Call govxml update cap.
	 *
	 * @param updateCap the update cap
	 *
	 * @return the gov xml
	 *
	 * @throws Exception the exception
	 */
	public GovXML callGovXMLCreateCapWithRetry(InitiateCAP initiateCap, String sourceName, String sourceKey,
			String cersid)
	{ // start to send data to aa;
		LOGGER.info("Start post data to AA.");
		addCount(sourceName + ".all");
		//Set the number of retries upon error is 1;
		int reTry = 0;//AVProperties.getIntProperty("cers.facility.reTry");
		Exception latestEx = null;
		for (int i = 0; i < reTry + 1; i++)
		{
			try
			{
				GovXML response = callGovXMLCreateCap(initiateCap);
				LOGGER.info("Successed to insert "
						+ sourceName
						+ " from CERS to AA. "
						+ sourceName
						+ " key:"
						+ sourceKey
						+ " recordId :"
						+ Arrays.toString(response.getInitiateCAPResponse().get(0).getCAPId().get(0).getKeys().get(0)
								.getKey().toArray()));
				addCount(sourceName + ".success");
				LOGGER.info("End post data to AA.");

				return response;
			}
			catch (Exception e)
			{
				latestEx = e;
			}
		}
		
		// report error in the last retry
		if (cersid != null)
		{
			addFail(sourceName + ".fail", cersid + "." + sourceKey);
			logError(latestEx, "Failed to create record for cersid: " + cersid + ", " + sourceName + ", key=" + sourceKey + ". " + latestEx.toString());
		}
		else
		{
			addFail(sourceName + ".fail", sourceKey);
			logError(latestEx, "Failed to create record for " + sourceName + ", key=" + sourceKey + ". " + latestEx.toString());
		}
		
		return null;

	}

	public GovXML callGovXMLUpdateCap(UpdateCAP updateCap) throws Exception
	{
		String capKeys = Arrays.toString(updateCap.getCAPId().getKeys().get(0).getKey().toArray());
		GovXML request = new GovXML();
		request.setUpdateCAP(updateCap);
		GovXML response = HttpPostService.doPostGovmxl(request);
		UpdateCAPResponse updateRes = response.getUpdateCAPResponse().get(0);
		if (updateRes == null || haveUpdateError(updateRes))
		{
			String errorstring = "Update CAP failed. capKeys:" + capKeys;
			if (haveUpdateError(updateRes))
			{
				Error error = updateRes.getSystem().getError();
				errorstring = errorstring + "\r\n ErrorCode:" + error.getErrorCode() + "\r\n ErrorMessage:"
						+ error.getErrorMessage();
			}
			//CapUtil.logInfo(request, response);
			throw new Exception(errorstring);
		}
		// CapUtil.logInfo(request, response);
		// LOGGER.info("Update CAP success. capKeys:" + capKeys);
		return response;
	}

	/**
	 * Have update error.
	 *
	 * @param updateRes the update res
	 *
	 * @return true, if successful
	 */
	public boolean haveUpdateError(UpdateCAPResponse updateRes)
	{
		if (updateRes == null)
		{
			return false;
		}
		return updateRes.getSystem() != null && updateRes.getSystem().getError() != null
				&& !"0".equals(updateRes.getSystem().getError().getErrorCode());
	}

	/**
	 * Have insert error.
	 *
	 * @param initiateCAPResponse the initiate cap response
	 *
	 * @return true, if successful
	 */
	public boolean haveInsertError(InitiateCAPResponse initiateCAPResponse)
	{
		if (initiateCAPResponse == null)
		{
			return false;
		}
		return initiateCAPResponse.getSystem() != null && initiateCAPResponse.getSystem().getError() != null
				&& !"0".equals(initiateCAPResponse.getSystem().getError().getErrorCode());
	}

	/**
	 * Call govxml create cap.
	 *
	 * @param initiateCap the initiate cap
	 *
	 * @return the gov xml
	 *
	 * @throws Exception the exception
	 */
	public GovXML callGovXMLCreateCap(InitiateCAP initiateCap) throws Exception
	{
		GovXML request = new GovXML();
		request.setInitiateCAP(initiateCap);
		GovXML response = HttpPostService.doPostGovmxl(request);
		InitiateCAPResponse initiateCAPResponse = response.getInitiateCAPResponse().get(0);
		if (initiateCAPResponse == null || haveInsertError(initiateCAPResponse))
		{
			String errorstring = "Failed to create record.";
			if (haveInsertError(initiateCAPResponse))
			{
				Error error = initiateCAPResponse.getSystem().getError();
				errorstring = errorstring + "\r\n ErrorCode:" + error.getErrorCode() + "\r\n ErrorMessage:"
						+ error.getErrorMessage();
			}
			//CapUtil.logInfo(request, response);
			throw new Exception(errorstring);

		}
		// String capKeys = Arrays.toString(initiateCAPResponse.getCAPId().get(0).getKeys().get(0).getKey().toArray());
		// LOGGER.info("Insert CAP success. capKeys:" + capKeys);
		// CapUtil.logInfo(request, response);
		return response;
	}

	public List<String> getChildCaps4Deleting(List<String> list, boolean chemicalStatusFlag, boolean wasteStatusFlag, boolean ustStatusFlag)
			throws Exception
	{
		StringBuilder capId = new StringBuilder();
		for (int i = 0; i < list.size() - 1; i++)
		{
			capId.append(list.get(i)).append("-");
		}
		capId.append(list.get(list.size() - 1));
		List<List<String>> childRecords;
		try
		{
			childRecords = CapUtil.getChildRecord(list.get(0), list.get(1), list.get(2));

			List<String> childList = new ArrayList<String>();
			for (List<String> childRecord : childRecords)
			{
				String group = childRecord.get(3);
				String type = childRecord.get(4);
				String subType = childRecord.get(5);
				String category = childRecord.get(6); 
				if ((!chemicalStatusFlag && ("Chemical").equalsIgnoreCase(category))
						|| (!wasteStatusFlag && ("Waste").equalsIgnoreCase(category))
						|| (!ustStatusFlag && ("UST").equalsIgnoreCase(category))
						|| !("LUEG-DEH".equals(group) && "HMD".equals(type) && "UPFP".equals(subType) && ("Chemical"
								.equals(category) || "Waste".equals(category) || "UST".equals(category))))
				{
					continue;
				}
				StringBuilder sb = new StringBuilder();
				sb.append(childRecord.get(0)).append("-");
				sb.append(childRecord.get(1)).append("-");
				sb.append(childRecord.get(2));
				childList.add(sb.toString());
			}

			return childList;

		}
		catch (Exception e)
		{
			LOGGER.info("query child record fail.");
			throw e;

		}

	}

	public List<String> getDocumentIDs4Deleting(List<String> list) throws Exception
	{
		try
		{
			List<String> documentIDs = CapUtil.getDocumentIDs(list.get(0), list.get(1), list.get(2));
			return documentIDs;
		}
		catch (Exception e)
		{
			LOGGER.info("query document fail.");
			throw e;

		}

	}

	public void deleteChildCap(List<String> childList) throws Exception
	{
		try
		{
			LOGGER.info("Start to delete child records,total is " + childList.size() + " ,These recordIds are:"
					+ Arrays.toString(childList.toArray()));
			for (int i = 0, j = 30; i < childList.size(); i = i + 30, j = i + 30)
			{
				if (j > childList.size())
				{
					j = childList.size();
				}
				List<String> result;
				try
				{
					result = CapUtil.deleteCaps(childList.subList(i, j));
					if (result.size() != 0)
					{
						LOGGER.info("There are some records fail in delete operation,These failed recordIds are:"
								+ Arrays.toString(result.toArray()));
					}
				}
				catch (Exception e)
				{
					LOGGER.info("Delete child records fail,These failed recordIds are:"
							+ Arrays.toString(childList.subList(i, j).toArray()));
					throw e;
				}

			}
			LOGGER.info("End to delete child records.");
		}
		catch (Exception e)
		{
			LOGGER.info("query child record fail.");
			throw e;

		}

	}

	public void deleteDocuments(String capId, List<String> docIdslist) throws Exception
	{
		try
		{
			LOGGER.info("Start to delete document,total is " + docIdslist.size() + " ,These recordIds are:" + capId);
			for (int i = 0, j = 30; i < docIdslist.size(); i = i + 30, j = i + 30)
			{
				if (j > docIdslist.size())
				{
					j = docIdslist.size();
				}
				try
				{
					CapUtil.deleteDocuments(capId, docIdslist.subList(i, j));
				}
				catch (Exception e)
				{
					LOGGER.info("Delete child document fail,These failed recordIds are:"
							+ Arrays.toString(docIdslist.subList(i, j).toArray()));
					throw e;
				}

			}
			LOGGER.info("End to delete document,The parent recordIds is:" + capId.toString());

		}
		catch (Exception e)
		{
			LOGGER.info("query child record fail.");
			throw e;

		}

	}

}

/*
 * $Log: av-env.bat,v $
 */
