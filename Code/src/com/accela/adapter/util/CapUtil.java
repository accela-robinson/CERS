package com.accela.adapter.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONObject;

import com.accela.aa.common.ConfigBase;
import com.accela.aa.wsquery.ParameterModel;
import com.accela.aa.wsquery.ReturnInfo;
import com.accela.adapter.constants.AdapterConstants;
import com.accela.adapter.model.cap.CAP;
import com.accela.adapter.model.cap.CAPId;
import com.accela.adapter.model.cap.CAPIds;
import com.accela.adapter.model.cap.CAPStatus;
import com.accela.adapter.model.cap.CAPStatuses;
import com.accela.adapter.model.cap.CAPTypeId;
import com.accela.adapter.model.cap.CAPTypeIds;
import com.accela.adapter.model.cap.GetAdditionalInformationGroups;
import com.accela.adapter.model.common.AdditionalInformation;
import com.accela.adapter.model.common.Keys;
import com.accela.adapter.model.common.ReturnElements;
import com.accela.adapter.model.common.Status;
import com.accela.adapter.model.common.StatusDateRange;
import com.accela.adapter.model.function.GetCAPs;
import com.accela.adapter.model.function.GovXML;
import com.accela.adapter.service.impl.AuthService;
import com.accela.adapter.service.impl.CapServiceCommon;
import com.accela.adapter.service.impl.HttpPostService;
import com.accela.cers.DateConvertUtil;
import com.accela.cers.cap.model.FacilitySubmittalType;
import com.accela.cers.cap.model.RegulatorFacilitySubmittals;
import com.accela.util.AVProperties;
import com.accela.ws.service.GenericQueryProxy;

/**
 * <pre>
 *
 * Accela Automation
 * File: CapUtil.java
 *
 * Accela, Inc.
 * Copyright (C): 2012-2014
 *
 * Description:
 *
 * Notes:
 * $Id: CapUtil.java 72642 2009-01-01 20:01:57Z ACHIEVO\james.jiang $
 *
 * Revision History
 * &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 * Nov 29, 2012		james.jiang		Initial.
 *
 * </pre>
 */
public class CapUtil
{
	/** The Constant LOGGER. */
	private static final Log LOGGER = LogFactory.getLog(CapUtil.class);

	/** key: cap ID; value: CERS ID **/
	private static HashMap<String, String> capId2CERSId = new HashMap<String, String>();

	/** key: CERS ID; value: cap ID **/
	private static HashMap<String, List<String>> cersId2CapId = new HashMap<String, List<String>>();
	
	private static Map<String, Status> mapStatus = new HashMap<String, Status>();

	/** The cap statuses. */
	public static CAPStatuses capStatuses;

	/** The cap type id. */
	public static CAPTypeId capTypeId = null;
	
	private static ConfigBase cb = new ConfigBase("dictionary");
	
	public static final String FACILITY_STATUS= "facilityStatus";
	
	public static final String CHEMICAL_STATUS= "chemicalStatus";
	
	public static final String WASTE_STATUS= "wasteStatus";
	
	public static final String UST_STATUS= "ustStatus";
	
	static {
		// FOR TEST ONLY
		if ( Boolean.getBoolean("testing.aacers") ) {
			ArrayList<String> capId = new ArrayList<String>();
			capId.add("13CAP");
			capId.add("00000");
			capId.add("001VT");
			//cersId2CapId.put("10208272", capId);
			
			//capId2CERSId.put("13CAP-00000-0001H", "10207834");
			//capId2CERSId.put("13CAP-00000-0001B", "10169875");
		}
	}

	public static Map<String, String> getShortCountry() throws Exception
	{
		GenericQueryProxy gqp = new GenericQueryProxy();

		// String cersId = params.get("cersId");
		// String sqlName = params.get("sqlName");

		ParameterModel[] p = new ParameterModel[1];
		p[0] = new ParameterModel("BIZDOMAIN", "COUNTRY");
		Map<String, String> li = new HashMap<String, String>();

		String sessionId = AuthService.getSystem().getApplicationState();

		LOGGER.info("Generic query - CERS_SearchCountry");
		ReturnInfo rinfo = gqp.query(sessionId, "CERS_SearchCountry", p, 1, 500);
		String returnCode = rinfo.getReturnCode();
		if (!"0".equals(returnCode))
		{
			throw new Exception("Failed to query CERS_SearchCountry: " + rinfo.getReturnMessage());
		}
		String result = rinfo.getResult();
		LOGGER.info("Generic query - SearchCountry result: " + result);

		if (null != result && !"".equals(result))
		{
			JSONArray jsonArray = new JSONArray(result);
			for (int i = 0; i < jsonArray.length(); i++)
			{
				JSONObject jsonObj = jsonArray.getJSONObject(i);
				String shortName = (String) jsonObj.get("BIZDOMAIN_VALUE");
				String name = (String) jsonObj.get("VALUE_DESC");
				if (shortName != null)
				{
					li.put(name.trim(), shortName);
				}
			}

			return li;
		}
		return null;

	}
	
	public static Map<String, String> getASIInfosByCapId(String s_id1, String s_id2, String s_id3)
	{
		try
		{
			GenericQueryProxy gqp = new GenericQueryProxy();

			ParameterModel[] p = new ParameterModel[4];
			p[0] = new ParameterModel("SERV_PROV_CODE", AVProperties.getAAAgency());
			p[1] = new ParameterModel("B1_PER_ID1", s_id1);
			p[2] = new ParameterModel("B1_PER_ID2", s_id2);
			p[3] = new ParameterModel("B1_PER_ID3", s_id3);
			Map<String, String> li = new HashMap<String, String>();

			String sessionId = AuthService.getSystem().getApplicationState();

			LOGGER.info("Generic query - CERS_GetASIInfoList");
			ReturnInfo rinfo = gqp.query(sessionId, "CERS_GetASIInfoList", p, 1, 1000);
			String returnCode = rinfo.getReturnCode();
			if (!"0".equals(returnCode))
			{
				LOGGER.error("Failed to query CERS_GetASIInfoList: " + rinfo.getReturnMessage());
			}
			String result = rinfo.getResult();
			LOGGER.info("Generic query - CERS_GetASIInfoList result: " + result);

			if (null != result && !"".equals(result))
			{
				JSONArray jsonArray = new JSONArray(result);
				for (int i = 0; i < jsonArray.length(); i++)
				{
					JSONObject jsonObj = jsonArray.getJSONObject(i);
					String asiValue = jsonObj.isNull("B1_CHECKLIST_COMMENT") ? "" : String.valueOf(jsonObj.get("B1_CHECKLIST_COMMENT"));
					StringBuffer key = new StringBuffer();
					key.append(jsonObj.get("B1_ACT_STATUS"));
					key.append("|");
					key.append(jsonObj.get("B1_CHECKBOX_TYPE"));
					key.append("|");
					key.append(jsonObj.get("B1_CHECKBOX_DESC"));

					li.put(key.toString(), asiValue);
				}

				return li;
			}
			return null;
		}
		catch (Exception ex)
		{
			LOGGER.error("Failed to query CERS_GetASIInfoList: " + ex.getMessage());
			return null;
		}
	}
	
	public static Map<String, String> getASITableInfosByCapId(String s_id1, String s_id2, String s_id3)
	{
		try
		{
			GenericQueryProxy gqp = new GenericQueryProxy();

			ParameterModel[] p = new ParameterModel[4];
			p[0] = new ParameterModel("SERV_PROV_CODE", AVProperties.getAAAgency());
			p[1] = new ParameterModel("B1_PER_ID1", s_id1);
			p[2] = new ParameterModel("B1_PER_ID2", s_id2);
			p[3] = new ParameterModel("B1_PER_ID3", s_id3);
			Map<String, String> li = new HashMap<String, String>();

			String sessionId = AuthService.getSystem().getApplicationState();

			LOGGER.info("Generic query - CERS_GetASITableInfoList");
			ReturnInfo rinfo = gqp.query(sessionId, "CERS_GetASITableInfoList", p, 1, 1000);
			String returnCode = rinfo.getReturnCode();
			if (!"0".equals(returnCode))
			{
				LOGGER.error("Failed to query CERS_GetASITableInfoList: " + rinfo.getReturnMessage());
			}
			String result = rinfo.getResult();
			LOGGER.info("Generic query - CERS_GetASITableInfoList result: " + result);

			if (null != result && !"".equals(result))
			{
				JSONArray jsonArray = new JSONArray(result);
				for (int i = 0; i < jsonArray.length(); i++)
				{
					JSONObject jsonObj = jsonArray.getJSONObject(i);
					String asiValue = jsonObj.isNull("ATTRIBUTE_VALUE") ? "" : String.valueOf(jsonObj.get("ATTRIBUTE_VALUE"));
					StringBuffer key = new StringBuffer();
					key.append(jsonObj.get("GROUP_NAME"));
					key.append("|");
					key.append(jsonObj.get("TABLE_NAME"));
					key.append("|");
					key.append(jsonObj.get("COLUMN_NAME"));
					key.append("|");
					key.append(jsonObj.get("ROW_INDEX"));
					li.put(key.toString(), asiValue);
					
					String groupName = String.valueOf(jsonObj.get("GROUP_NAME"));
					String tableName = String.valueOf(jsonObj.get("TABLE_NAME"));
					String rowIndex = String.valueOf(jsonObj.get("ROW_INDEX"));
					
					
					if(li.get(groupName + "|" + tableName + "|" + rowIndex) == null )
					{
						
						if (li.get(groupName + "|" + tableName+ "|" ) == null)
						{
							li.put(groupName + "|" + tableName+ "|" , "0");
							li.put(groupName + "|" + tableName +"|Index0", rowIndex);
						}
						else
						{
							int countNum = Integer.valueOf(li.get(groupName + "|" + tableName+ "|")).intValue();
							countNum++;
							li.put(groupName + "|" + tableName+ "|" , "" + countNum);
							li.put(groupName + "|" + tableName+ "|Index" + countNum, rowIndex);
						}
					}
					li.put(groupName + "|" + tableName + "|" + rowIndex, "");
				}
				

				return li;
			}
			return null;
		}
		catch (Exception ex)
		{
			LOGGER.error("Failed to query CERS_GetASITableInfoList: " + ex.getMessage());
			return null;
		}
	}

	public static List<String> getCapId(CAP capBasic)
	{
		Keys keys = capBasic.getKeys();
		if ( keys != null && keys.getKey() != null) {
			List<String> capIds = new ArrayList<String>();
			capIds.addAll(keys.getKey());
			return capIds;
		}
		else {
			return null;
		}
	}
	
	/**
	 * Gets the cap by cers id.
	 *
	 * @param cersid the cersid
	 *
	 * @return the cap by cers id
	 *
	 * @throws Exception the exception
	 */
	public static List<String> getCapByCersId(String cersid) throws Exception
	{
		List<String> capID = cersId2CapId.get(cersid);
		if ( capID != null ) {
			return capID;
		}
		GenericQueryProxy gqp = new GenericQueryProxy();
		LOGGER.info("start to query key from asi.");
		// String cersId = params.get("cersId");
		// String sqlName = params.get("sqlName");

		ParameterModel[] p = new ParameterModel[3];
		p[0] = new ParameterModel("uniquekey", cersid);
		p[1] = new ParameterModel("SERV_PROV_CODE", AVProperties.getAAAgency());
		p[2] = new ParameterModel("cersfield", "CERS ID Number (1a)");
		List<String> li = new ArrayList<String>();

		String sessionId = AuthService.getSystem().getApplicationState();

		LOGGER.info("Generic query - CERS_CheckRecordKeyFromCERSID: cersid[" + cersid + "]");

		ReturnInfo rinfo = gqp.query(sessionId, "CERS_CheckRecordKeyFromCERSID", p, 1, 10);
		String returnCode = rinfo.getReturnCode();
		if (!"0".equals(returnCode))
		{
			LOGGER.info("end to query key from asi.");
			throw new Exception("Failed to query CERS_CheckRecordKeyFromCERSID: " + rinfo.getReturnMessage());
		}
		String result = rinfo.getResult();
		LOGGER.info("Generic query - CERS_CheckRecordKeyFromCERSID result: " + result);

		if (null != result && !"".equals(result))
		{

			JSONArray jsonArray = new JSONArray(result);

			String b1_per_id1 = null;
			String b1_per_id2 = null;
			String b1_per_id3 = null;
			JSONObject jsonObj = jsonArray.getJSONObject(0);

			b1_per_id1 = (String) jsonObj.get("B1_PER_ID1");
			b1_per_id2 = (String) jsonObj.get("B1_PER_ID2");
			b1_per_id3 = (String) jsonObj.get("B1_PER_ID3");
			li.add(b1_per_id1);
			li.add(b1_per_id2);
			li.add(b1_per_id3);

			cersId2CapId.put(cersid, li);
			return li;
		}
		return null;

	}
	
	public static Status getDefaultStatusByCapType(String capType)
	{
		if (capType == null)
		{
			return null;
		}
		try
		{

			GenericQueryProxy gqp = new GenericQueryProxy();
			LOGGER.info("start to query for default status by cap type.");
			if (mapStatus != null && mapStatus.size() > 0)
			{
				return mapStatus.get(capType);
			}

			ParameterModel[] p = new ParameterModel[4];
			p[0] = new ParameterModel("SERV_PROV_CODE", AVProperties.getAAAgency());
			p[1] = new ParameterModel("R1_PER_GROUP", "LUEG-DEH");
			p[2] = new ParameterModel("R1_PER_TYPE", "HMD");
			p[3] = new ParameterModel("R1_PER_SUB_TYPE", "UPFP");

			String sessionId = AuthService.getSystem().getApplicationState();

			LOGGER.info("Generic query - CERS_GetDefaultStatusByCapType: capType[" + capType + "]");

			ReturnInfo rinfo = gqp.query(sessionId, "CERS_GetDefaultStatusByCapType", p, 1, 10);
			String returnCode = rinfo.getReturnCode();
			if (!"0".equals(returnCode))
			{
				LOGGER.info("end to query for default status by cap type.");
			}
			String result = rinfo.getResult();
			LOGGER.info("Generic query - CERS_GetDefaultStatusByCapType result: " + result);

			if (null != result && !"".equals(result))
			{
				JSONArray jsonArray = new JSONArray(result);
				for(int i = 0; i< jsonArray.length(); i++)
				{
					JSONObject jsonObj = jsonArray.getJSONObject(i);
					if (jsonObj.get("APP_STATUS_GROUP_CODE") != null && jsonObj.get("APP_DEFAULT_STATUS_CODE") != null)
					{
						Status status = new Status();
						Keys keys = new Keys();

						String statusGroupCode = (String) jsonObj.get("APP_STATUS_GROUP_CODE");
						String defaultStatusCode = (String) jsonObj.get("APP_DEFAULT_STATUS_CODE");
						String group = (String) jsonObj.get("R1_PER_GROUP");
						String type = (String) jsonObj.get("R1_PER_TYPE");
						String subType = (String) jsonObj.get("R1_PER_SUB_TYPE");
						String category = (String) jsonObj.get("R1_PER_CATEGORY");
						status.setValue(defaultStatusCode);
						keys.getKey().add(defaultStatusCode);
						keys.getKey().add(statusGroupCode);
						status.setKeys(keys);
						status.setDate(DateConvertUtil.dateTime(new Date()));
						mapStatus.put(group + "/" + type + "/" + subType + "/" + category, status);
					}
				}
			}
			if (mapStatus != null && mapStatus.size() > 0)
			{
				return mapStatus.get(capType);
			}
			return null;
		}
		catch (Exception ex)
		{
			LOGGER.error("Failed to query CERS_GetDefaultStatusByCapType: " + ex.getMessage());
			return null;
		}

	}

	public static String getParentValue(List<String> child)
	{
		GenericQueryProxy gqp = new GenericQueryProxy();

		// String cersId = params.get("cersId");
		// String sqlName = params.get("sqlName");

		ParameterModel[] p = new ParameterModel[11];
		p[0] = new ParameterModel("B1_PER_ID1", child.get(0));
		p[1] = new ParameterModel("B1_PER_ID2", child.get(1));
		p[2] = new ParameterModel("B1_PER_ID3", child.get(2));
		p[3] = new ParameterModel("B1_PER_GROUP", "LUEG-DEH");
		p[4] = new ParameterModel("B1_PER_TYPE", "HMD");
		p[5] = new ParameterModel("B1_PER_SUB_TYPE", "UPFP");
		p[6] = new ParameterModel("B1_PER_CATEGORY", "Facility");
		p[7] = new ParameterModel("B1_ACT_STATUS", "DEH_HUPF_T27");
		p[8] = new ParameterModel("B1_CHECKBOX_TYPE", "CERS COLLECTED INFO");
		p[9] = new ParameterModel("B1_CHECKBOX_DESC", "CERS ID Number (1a)");
		p[10] = new ParameterModel("SERV_PROV_CODE", AVProperties.getAAAgency());

		LOGGER.info("Generic query - CERS_CheckParecntCERSID: capID[" + child.get(0) + "-" + child.get(1) + "-" + child.get(2) + "]");
		String sessionId = AuthService.getSystem().getApplicationState();
		ReturnInfo rinfo;
		try
		{
			rinfo = gqp.query(sessionId, "CERS_CheckParecntCERSID", p, 1, 10);

			String returnCode = rinfo.getReturnCode();
			if (!"0".equals(returnCode))
			{
				return null;
			}
			String result = rinfo.getResult();
			LOGGER.info("Generic query - CERS_CheckParecntCERSID result: " + result);

			if (null != result && !"".equals(result))
			{

				JSONArray jsonArray = new JSONArray(result);

				JSONObject jsonObj = jsonArray.getJSONObject(0);
				if (!jsonObj.isNull("B1_CHECKLIST_COMMENT"))
				{
					LOGGER.info("Get CERSID by enforcementCapId, capId: [" + child.get(0) + "," + child.get(1) + ","
							+ child.get(2) + "],CERSID:" + jsonObj.getString("B1_CHECKLIST_COMMENT"));
					return jsonObj.getString("B1_CHECKLIST_COMMENT");
				}
				else
				{
					LOGGER.info("NO CERSID return.");
					return null;
				}
			}
			else
			{
				LOGGER.info("Result is null.");
			}
		}
		catch (Exception e)
		{
			return null;
		}
		return null;

	}

	/**
	 * get childrecord by CapId .
	 *
	 * @param key1 the key1
	 * @param key2 the key2
	 * @param key3 the key3
	 *
	 * @return the child id by cap id
	 *
	 * @throws Exception the exception
	 */
	public static List<List<String>> getChildRecord(String key1, String key2, String key3) throws Exception
	{

		GenericQueryProxy gqp = new GenericQueryProxy();
		List<List<String>> res = new ArrayList<List<String>>();
		ParameterModel[] p = new ParameterModel[5];
		p[0] = new ParameterModel("B1_MASTER_ID1", key1);
		p[1] = new ParameterModel("B1_MASTER_ID2", key2);
		p[2] = new ParameterModel("B1_MASTER_ID3", key3);
		p[3] = new ParameterModel("SERV_PROV_CODE", AVProperties.getAAAgency());
		p[4] = new ParameterModel("REC_STATUS", "A");
		String sessionId = AuthService.getSystem().getApplicationState();

		LOGGER.info("Generic query - CERS_SearchChildRecordID: capID[" + key1 + "-" + key2 + "-" + key3 + "]");
		ReturnInfo rinfo = gqp.query(sessionId, "CERS_SearchChildRecordID", p, 1, 1000);
		String returnCode = rinfo.getReturnCode();
		if (!"0".equals(returnCode))
		{
			throw new Exception("Failed to query CERS_SearchChildRecordID: " + rinfo.getReturnMessage());
		}
		String result = rinfo.getResult();
		LOGGER.info("Generic query - CERS_SearchChildRecordID result: " + result);

		if (null != result && !"".equals(result))
		{

			JSONArray jsonArray = new JSONArray(result);
			for (int i = 0; i < jsonArray.length(); i++)
			{
				List<String> resl = new ArrayList<String>();
				JSONObject jsonObj = jsonArray.getJSONObject(i);
				resl.add(jsonObj.getString("B1_PER_ID1"));
				resl.add(jsonObj.getString("B1_PER_ID2"));
				resl.add(jsonObj.getString("B1_PER_ID3"));
				
				resl.add(jsonObj.getString("B1_PER_GROUP"));
				resl.add(jsonObj.getString("B1_PER_TYPE"));
				resl.add(jsonObj.getString("B1_PER_SUB_TYPE"));
				String b1PerCategory = jsonObj.getString("B1_PER_CATEGORY");
				if("Waste".equalsIgnoreCase(b1PerCategory))
				{
					String wasteType = getCapWasteSourceTypeByCapId(jsonObj.getString("B1_PER_ID1"), jsonObj
							.getString("B1_PER_ID2"), jsonObj.getString("B1_PER_ID3"));
					resl.add(wasteType);
				}
				else
				{
					resl.add(b1PerCategory);
				}
				res.add(resl);
			}

		}
		return res;

	}
	/**
	 * get document Id by CapId .
	 *
	 * @param key1 the key1
	 * @param key2 the key2
	 * @param key3 the key3
	 *
	 * @return the child id by cap id
	 *
	 * @throws Exception the exception
	 */
	public static List<String> getDocumentIDs(String key1, String key2, String key3) throws Exception
	{
		GenericQueryProxy gqp = new GenericQueryProxy();
		List<String> res = new ArrayList<String>();
		ParameterModel[] p = new ParameterModel[4];
		p[0] = new ParameterModel("B1_PER_ID1", key1);
		p[1] = new ParameterModel("B1_PER_ID2", key2);
		p[2] = new ParameterModel("B1_PER_ID3", key3);
		p[3] = new ParameterModel("SERV_PROV_CODE", AVProperties.getAAAgency());
		String sessionId = AuthService.getSystem().getApplicationState();

		LOGGER.info("Generic query - CERS_GetDocumentIDs: capID[" + key1 + "-" + key2 + "-" + key3 + "]");
		ReturnInfo rinfo = gqp.query(sessionId, "CERS_GetDocumentIDs", p, 1, 1000);
		String returnCode = rinfo.getReturnCode();
		if (!"0".equals(returnCode))
		{
			throw new Exception("Failed to query CERS_GetDocumentIDs: " + rinfo.getReturnMessage());
		}
		String result = rinfo.getResult();
		LOGGER.info("Generic query - CERS_GetDocumentIDs result: " + result);

		if (null != result && !"".equals(result))
		{

			JSONArray jsonArray = new JSONArray(result);
			for (int i = 0; i < jsonArray.length(); i++)
			{
				JSONObject jsonObj = jsonArray.getJSONObject(i);
				res.add(jsonObj.getString("DOC_SEQ_NBR"));
			}

		}
		return res;

	}

	/**
	 *
	 * get the Waste source type which is created from Chemical or OnsiteHazardousWasteTreatmentNotification.
	 *
	 * @param s_id1
	 * @param s_id2
	 * @param s_id3
	 * @return
	 * @throws Exception
	 */
	public static String getCapWasteSourceTypeByCapId(String s_id1, String s_id2, String s_id3) throws Exception
	{
		GenericQueryProxy gqp = new GenericQueryProxy();
		String sourceType = "";
		ParameterModel[] p = new ParameterModel[5];
		p[0] = new ParameterModel("B1_PER_ID1", s_id1);
		p[1] = new ParameterModel("B1_PER_ID2", s_id2);
		p[2] = new ParameterModel("B1_PER_ID3", s_id3);
		p[3] = new ParameterModel("SERV_PROV_CODE", AVProperties.getAAAgency());
		p[4] = new ParameterModel("b1_checkbox_desc", "Hazardous Material Type (211)");
		String sessionId = AuthService.getSystem().getApplicationState();

		LOGGER.info("Generic query - CERS_CheckCERSIDFromRecordKey: capID[" + s_id1 + "-" + s_id2 + "-" + s_id3 + "]");
		ReturnInfo rinfo = gqp.query(sessionId, "CERS_CheckCERSIDFromRecordKey", p, 1, 1);
		String returnCode = rinfo.getReturnCode();
		if (!"0".equals(returnCode))
		{
			throw new Exception("Failed to query CERS_CheckCERSIDFromRecordKey: " + rinfo.getReturnMessage());
		}
		String result = rinfo.getResult();
		LOGGER.info("Generic query - CERS_CheckCERSIDFromRecordKey result: " + result);

		if (null != result && !"".equals(result))
		{
			JSONArray jsonArray = new JSONArray(result);
			JSONObject jsonObj = jsonArray.getJSONObject(0);
			if ("Waste".equalsIgnoreCase(jsonObj.getString("B1_CHECKLIST_COMMENT")))
			{
				sourceType = "Chemical";
			}
		}
		else
		{
			sourceType = "Waste";
		}

		return sourceType;
	}


	/**
	 * get cersId by CapId
	 *
	 * @param key1 the key1
	 * @param key2 the key2
	 * @param key3 the key3
	 *
	 * @return the cers id by cap id
	 *
	 * @throws Exception the exception
	 */
	public static String getCersIdByCapId(String key1, String key2, String key3) throws Exception
	{

		String capID = key1 + "-" + key2 + "-" + key3;
		String CERSId = capId2CERSId.get(capID);
		if ( CERSId != null ) {
			return CERSId;
		}

		GenericQueryProxy gqp = new GenericQueryProxy();

		ParameterModel[] p = new ParameterModel[7];
		p[0] = new ParameterModel("B1_PER_ID1", key1);
		p[1] = new ParameterModel("B1_PER_ID2", key2);
		p[2] = new ParameterModel("B1_PER_ID3", key3);

		p[3] = new ParameterModel("b1_per_sub_type", "UPFP");
		p[4] = new ParameterModel("b1_checkbox_type", "CERS COLLECTED INFO");
		p[5] = new ParameterModel("b1_checkbox_desc", "CERS ID Number (1a)");
		p[6] = new ParameterModel("SERV_PROV_CODE", AVProperties.getAAAgency());
		String cersId = null;
		String sessionId = AuthService.getSystem().getApplicationState();

		LOGGER.info("Generic query - CERS_CheckCERSIDFromRecordKey: capID[" + key1 + "-" + key2 + "-" + key3 + "]");
		ReturnInfo rinfo = gqp.query(sessionId, "CERS_CheckCERSIDFromRecordKey", p, 1, 10);
		String returnCode = rinfo.getReturnCode();
		if (!"0".equals(returnCode))
		{
			throw new Exception("Failed to query CERS_CheckCERSIDFromRecordKey: " + rinfo.getReturnMessage());
		}
		String result = rinfo.getResult();
		LOGGER.info("Generic query - CERS_CheckCERSIDFromRecordKey result: " + result);

		if (null != result && !"".equals(result))
		{

			JSONArray jsonArray = new JSONArray(result);

			JSONObject jsonObj = jsonArray.getJSONObject(0);
			if (!jsonObj.isNull("B1_CHECKLIST_COMMENT"))
			{
				cersId = jsonObj.getString("B1_CHECKLIST_COMMENT");
				LOGGER.info("Get CERSID by inspectionCapId, capId: [" + key1 + "," + key2 + "," + key3 + "], CERSID: "
						+ cersId);
			}
			else
			{
				LOGGER.info("No CERIS return.");
			}

			if ( cersId != null ) {
				capId2CERSId.put(capID, cersId);
			}
			return cersId;
		}
		else
		{
			LOGGER.info("Result is null.");
		}
		return null;

	}

	/**
	 * Gets the additional info by type.
	 *
	 * @param cersType the cers type
	 *
	 * @return the additional info by type
	 *
	 * @throws Exception the exception
	 */
	public static List<AdditionalInformation> getAdditionalInfoByType(String cersType) throws Exception
	{
		CAPTypeIds capTypeIds = getCapTypeIds(cersType);
		GovXML request = new GovXML();
		GetAdditionalInformationGroups req = new GetAdditionalInformationGroups();
		req.setContextType("CAP");
		req.setSystem(AuthService.getSystem());
		req.setCAPTypeIds(capTypeIds);
		request.setGetAdditionalInformationGroups(req);
		return HttpPostService.doPostGovmxl(request).getGetAdditionalInformationGroupsResponse()
				.getAdditionalInformation();

	}

	private static CAPTypeIds getCapTypeIds(String cersType)
	{
		CAPTypeId CAPTypeId = getCapTypeIdByString(cersType);
		CAPTypeIds capTypeIds = new CAPTypeIds();
		capTypeIds.getCAPTypeId().add(CAPTypeId);
		return capTypeIds;
	}


	/**
	 * Gets the cap type id by string.
	 *
	 * @param cersType the cers type
	 *
	 * @return the cap type id by string
	 */
	public static CAPTypeId getCapTypeIdByString(String cersType)
	{
		String capTypePropKey = cersType + ".capType";
		String[] capTypeStr = cb.get(capTypePropKey).split("/");
		CAPTypeId CAPTypeId = new CAPTypeId();
		Keys keys = new Keys();
		for (String key : capTypeStr)
		{
			keys.getKey().add(key);
		}
		CAPTypeId.setKeys(keys);
		return CAPTypeId;
	}

	/**
	 * Gets the cap by cap ids.
	 *
	 * @param capkeys the capkeys
	 *
	 * @return the cap by cap ids
	 *
	 * @throws Exception the exception
	 */
	public static CAP getCapByCapId(String capAltId) throws Exception
	{
		GetCAPs getCapsReq = createQueryCap(capAltId);
		return getCap(getCapsReq);
	}
	
	public static CAP getCapByCapId4Status(CAPId capId) throws Exception
	{
		GetCAPs getCapsReq = createQueryCap(capId);
		return getCap4Status(getCapsReq);
	}
	
	public static CAP getCapByCapIds(List<String> capkeys) throws Exception
	{
		GetCAPs getCapsReq = createQueryCap(capkeys);
		return getCap(getCapsReq);
	}
	
	private static CAP getCap(GetCAPs getCapsReq) throws Exception
	{
		GovXML govXML = new GovXML();
		ReturnElements returnElements = addReturnElementsForCAPWithAddtion();
		getCapsReq.setReturnElements(returnElements);
		govXML.setGetCAPs(getCapsReq);
		List<CAP> caps = HttpPostService.doPostGovmxl(govXML).getGetCAPsResponse().getCAPs().getCAP();
		if ( caps != null && caps.size() > 0 ) {
			return caps.get(0);
		}
		else {
			return null;
		}
	}
	
	private static CAP getCap4Status(GetCAPs getCapsReq) throws Exception
	{
		GovXML govXML = new GovXML();
		ReturnElements returnElements = new ReturnElements();
		returnElements.getReturnElement().add(AdapterConstants.CAPDETIALS);
		getCapsReq.setReturnElements(returnElements);
		govXML.setGetCAPs(getCapsReq);
		List<CAP> caps = HttpPostService.doPostGovmxl(govXML).getGetCAPsResponse().getCAPs().getCAP();
		if ( caps != null && caps.size() > 0 ) {
			return caps.get(0);
		}
		else {
			return null;
		}
	}

	/**
	 * Creates the query cap.
	 *
	 * @param capkeys the capAltId
	 *
	 * @return the gets the ca ps
	 */
	private static GetCAPs createQueryCap(String capAltId)
	{
		CAPId capId = new CAPId();
		capId.setValue(capAltId);
		return createQueryCap(capId);
	}
	
	
	/**
	 * Creates the query cap.
	 *
	 * @param capkeys the capkeys
	 *
	 * @return the gets the ca ps
	 */
	private static GetCAPs createQueryCap(List<String> capkeys)
	{
		CAPId capId = new CAPId();
		Keys keys = new Keys();
		keys.getKey().addAll(capkeys);
		capId.getKeys().add(keys);
		return createQueryCap(capId);
	}
	
	/**
	 * Creates the query cap.
	 *
	 * @param capkeys the capkeys
	 *
	 * @return the gets the ca ps
	 */
	private static GetCAPs createQueryCap(CAPId capId)
	{
		GetCAPs getCapsReq = new GetCAPs();
		CAPIds capIds = new CAPIds();
		capIds.setCapId(capId);
		getCapsReq.setCapIds(capIds);
		getCapsReq.setSystem(AuthService.getSystem());

		return getCapsReq;
	}


	/**
	 * Download.
	 *
	 * @param requestURL the request url
	 *
	 * @return the regulator facility submittals
	 *
	 * @throws Exception the exception
	 */
	public static RegulatorFacilitySubmittals download(String requestURL) throws Exception
	{
		RegulatorFacilitySubmittals regulatorFacilitySubmittals = null;
		HttpURLConnection urlcon = null;
		InputStream in = null;
		try
		{
			URL url = new URL(requestURL);
			urlcon = CommonUtil.getHttpURLConn(url);
			urlcon.setRequestMethod("GET");
			urlcon.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
			urlcon.setRequestProperty("Authorization", AdapterConstants.AUTH_INFO);
			urlcon.setDoOutput(true);
			urlcon.setDoInput(true);
			in = urlcon.getInputStream();
			regulatorFacilitySubmittals = CommonUtil.unMarshalCERS(in);

		}
		catch (Exception e)
		{
			LOGGER.debug("download and unMarshal have exception.", e);
			throw e;
		}
		finally
		{
			// Close the input stream and the network connection
			if (in != null)
				in.close();
			if (urlcon != null)
				urlcon.disconnect();
		}
		return regulatorFacilitySubmittals;

	}

	/**
	 *
	 * change the inputStream to String.
	 *
	 * @param is
	 * @return
	 * @throws IOException
	 */

	public static String convertStreamToString(InputStream is) throws IOException
	{

		if (is != null)
		{
			StringBuilder sb = new StringBuilder();
			String line;

			try
			{
				BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				while ((line = reader.readLine()) != null)
				{
					sb.append(line).append("\n");
				}
			}
			finally
			{
				is.close();
			}
			return sb.toString();
		}
		else
		{
			return "";
		}
	}

	/**
	 * get delete document's url .
	 *
	 * @param capids
	 * @return
	 */
	private static String getDeleteChildUrl(List<String> capids)
	{
		StringBuilder sb = new StringBuilder(4096);
		sb.append(AVProperties.getBizServerURL()).append("/apis/agency/records/");
		int i = 0;
		for (String capid : capids)
		{
			i++;
			if (i != capids.size())
			{
				sb.append(capid).append(",");
			}
			else
			{
				sb.append(capid);
			}
		}

		return sb.toString();

	}

	/**
	 *
	 * . get delete child cap's url.
	 *
	 * @param capids
	 * @return
	 */
	private static String getDeleteDocumentUrl(String capId, List <String> docIds)
	{
		StringBuilder sb = new StringBuilder(4096);
		sb.append(AVProperties.getBizServerURL()).append("/apis/agency/records/");
		sb.append(capId);
		sb.append("/documents/");
		int i = 0;
		for (String docId : docIds)
		{
			i++;
			if (i != docIds.size())
			{
				sb.append(docId).append(",");
			}
			else
			{
				sb.append(docId);
			}
		}
		String edmsset = AVProperties.getProperty("aa.edmsset");
		if ("true".equals(edmsset))
		{
			String username = AVProperties.getProperty("aa.edmsusername");
			String password = AVProperties.getProperty("aa.edmspassword");
			if (!(username == null || "".equals(username.trim()) || password == null || "".equals(password.trim())))
			{
				sb.append("?userId=").append(username);
				sb.append("&password=").append(password);
			}
		}

		if (sb.indexOf("?") == -1)
		{
			sb.append("?1=1");
		}
		return sb.toString();

	}

	/**
	 *
	 * . // * delete cap
	 *
	 * @param capids
	 * @param isDocument
	 * @return
	 * @throws Exception
	 */
	public static List<String> deleteCaps(List<String> capids) throws Exception
	{
		String sessionId = AuthService.getSystem().getApplicationState();
		HttpURLConnection urlcon = null;
		InputStream in = null;
		try
		{
			String urlStr = null;
			urlStr = getDeleteChildUrl(capids) + "?token=" + sessionId;

			LOGGER.info("Delete Caps API URL: " + urlStr);
			
			// FOR TEST
			if ( Boolean.getBoolean("testing.skipdeletion") ) {
				return new ArrayList<String>();
			}
			URL url = new URL(urlStr);
			urlcon = (HttpURLConnection) url.openConnection();
			urlcon.setRequestMethod("DELETE");
			urlcon.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
			urlcon.setRequestProperty("Authorization", AdapterConstants.AUTH_INFO);
			urlcon.setDoOutput(true);
			urlcon.setDoInput(true);
			in = urlcon.getInputStream();
			String jsonStr = convertStreamToString(in);
			JSONObject ja = new JSONObject(jsonStr);
			JSONObject rs = (JSONObject) ja.get("responseStatus");
			Integer status = (Integer) rs.get("status");
			if (200 == status)
			{
				List<String> list = new ArrayList<String>();
				JSONObject result = (JSONObject) ja.get("result");
				JSONArray jarr = (JSONArray) result.get("failedIDs");
				for (int i = 0; i < jarr.length(); i++)
				{
					list.add((String) jarr.get(i));
				}
				return list;

			}
			else
			{
				throw new Exception("deleteCaps.fail");
			}

		}
		catch (Exception e)
		{
			LOGGER.debug("download and parse result have exception.", e);
			throw e;
		}
		finally
		{
			// Close the input stream and the network connection
			if (in != null)
				in.close();
			if (urlcon != null)
				urlcon.disconnect();
		}
	}

	public static void deleteDocuments(String capids, List<String> docIds) throws Exception
	{
		String sessionId = AuthService.getSystem().getApplicationState();
		HttpURLConnection urlcon = null;
		InputStream in = null;
		try
		{
			String urlStr = null;
			urlStr = getDeleteDocumentUrl(capids, docIds) + "&token=" + sessionId;

			LOGGER.info("Delete documents API URL: " + urlStr);
			
			URL url = new URL(urlStr);
			urlcon = (HttpURLConnection) url.openConnection();
			urlcon.setRequestMethod("DELETE");
			urlcon.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
			urlcon.setRequestProperty("Authorization", AdapterConstants.AUTH_INFO);
			urlcon.setDoOutput(true);
			urlcon.setDoInput(true);
			in = urlcon.getInputStream();
			String jsonStr = convertStreamToString(in);
			JSONObject ja = new JSONObject(jsonStr);
			JSONObject rs = (JSONObject) ja.get("responseStatus");
			Integer status = (Integer) rs.get("status");
			if (200 == status)
			{
				return;
			}
			else
			{
				throw new Exception("deleteDocuments.fail");
			}
		}
		catch (Exception e)
		{
			LOGGER.debug("delete documents failed", e);
			throw e;
		}
		finally
		{
			// Close the input stream and the network connection
			if (in != null)
				in.close();
			if (urlcon != null)
				urlcon.disconnect();
		}

	}

	/**
	 * download document
	 *
	 * @throws Exception
	 */

	public static String downloadDocument(String requestURL) throws Exception
	{
		HttpURLConnection urlcon = null;
		InputStream in = null;
		try
		{
			URL url = new URL(requestURL);
			urlcon = CommonUtil.getHttpURLConn(url);
			urlcon.setRequestMethod("GET");
			urlcon.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
			urlcon.setRequestProperty("Authorization", AdapterConstants.AUTH_INFO);
			urlcon.setDoOutput(true);
			urlcon.setDoInput(true);
			in = urlcon.getInputStream();
			return encodeBASE64(in);

		}// have exception
		catch (Exception e)
		{
			// LOGGER.info(e+e.getMessage());
			LOGGER.info("download document fail caused by: " + e);
			throw e;
		}
		finally
		{
			// Close the input stream and the network connection
			if (in != null)
				in.close();
			if (urlcon != null)
				urlcon.disconnect();
		}

	}

	/**
	 *
	 * Encode inputStream to String object using base64.
	 *
	 * @param inputStream input stream
	 * @return
	 */
	public static String encodeBASE64(InputStream inputStream)
	{
		if (inputStream == null)
		{
			return "";
		}
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		String result = "";
		try
		{
			(new sun.misc.BASE64Encoder()).encode(inputStream, outputStream);
			result = outputStream.toString("8859_1");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Creates the query cap.
	 *
	 * @return the gets the ca ps
	 */
	public static GetCAPs createQueryCap(String start, String end)
	{
		GetCAPs getCapsReq = new GetCAPs();
		CAPTypeIds capTypeIds = new CAPTypeIds();
		CAPTypeId capTypeId = CapUtil.getDefaultCAPTypeId();
		capTypeIds.getCAPTypeId().add(capTypeId);
		getCapsReq.setCAPTypeIds(capTypeIds);
		CAPStatuses capStatuses = CapUtil.getDefaultCAPStatuses();
		getCapsReq.setCAPStatuses(capStatuses);
		StatusDateRange statusDateRange = new StatusDateRange();

		statusDateRange.setFrom(start);
		statusDateRange.setTo(end);
		getCapsReq.setStatusDateRange(statusDateRange);

		getCapsReq.setSystem(AuthService.getSystem());

		// Set return elements to filter the useless data.
		ReturnElements returnElements = addReturnElementsForCAP();
		getCapsReq.setReturnElements(returnElements);

		return getCapsReq;
	}

	private static ReturnElements addReturnElementsForCAP()
	{
		ReturnElements returnElements = new ReturnElements();
		returnElements.getReturnElement().add(AdapterConstants.ADDRESSES);
		returnElements.getReturnElement().add(AdapterConstants.CONTACTS);
		returnElements.getReturnElement().add(AdapterConstants.ADDITIONALINFORMATION);
		return returnElements;
	}

	private static ReturnElements addReturnElementsForCAPWithAddtion()
	{
		ReturnElements returnElements = new ReturnElements();
		returnElements.getReturnElement().add(AdapterConstants.CONTACTS);
		returnElements.getReturnElement().add(AdapterConstants.CAPDETIALS);
		returnElements.getReturnElement().add(AdapterConstants.ADDITIONALINFORMATION);
		return returnElements;
	}

	/**
	 * Gets the default cap statuses.
	 *
	 * @return the default cap statuses
	 */
	public static CAPStatuses getDefaultCAPStatuses()
	{
		if (capStatuses == null)
		{
			capStatuses = new CAPStatuses();
			CAPStatus capStatus = new CAPStatus();
			Keys keys = new Keys();
			keys.getKey().add("Resolved");
			capStatus.setKeys(keys);
			capStatuses.setCAPStatus(capStatus);
		}
		return capStatuses;
	}

	/**
	 * Gets the default cap type id.
	 *
	 * @return the default cap type id
	 */
	public static CAPTypeId getDefaultCAPTypeId()
	{
		if (capTypeId == null)
		{
			capTypeId = CapUtil.getCapTypeIdByString(AdapterConstants.ENFORCEMENTCASE);
		}
		return capTypeId;
	}
	
	public static boolean getStatusFlag(FacilitySubmittalType facilitySubmittalType, String type)
	{
		if (FACILITY_STATUS.equals(type)
				&& facilitySubmittalType.getFacilityInformation() != null
				&& facilitySubmittalType.getFacilityInformation().getSubmittalElementHeader() != null
				&& CapServiceCommon.SUBMITTAL_STATUS.equals(facilitySubmittalType.getFacilityInformation()
						.getSubmittalElementHeader().getSubmittalStatus()))
		{
			return true;
		}
		else if (CHEMICAL_STATUS.equals(type)
				&& facilitySubmittalType.getHazardousMaterialsInventory() != null
				&& facilitySubmittalType.getHazardousMaterialsInventory().getSubmittalElementHeader() != null
				&& CapServiceCommon.SUBMITTAL_STATUS.equals(facilitySubmittalType.getHazardousMaterialsInventory()
						.getSubmittalElementHeader().getSubmittalStatus()))
		{
			return true;
		}
		else if (WASTE_STATUS.equals(type)
				&& facilitySubmittalType.getOnsiteHazardousWasteTreatmentNotification() != null
				&& facilitySubmittalType.getOnsiteHazardousWasteTreatmentNotification().getSubmittalElementHeader() != null
				&& CapServiceCommon.SUBMITTAL_STATUS.equals(facilitySubmittalType
						.getOnsiteHazardousWasteTreatmentNotification().getSubmittalElementHeader()
						.getSubmittalStatus()))
		{
			return true;
		}
		else if (UST_STATUS.equals(type)
				&& facilitySubmittalType.getUndergroundStorageTanks() != null
				&& facilitySubmittalType.getUndergroundStorageTanks().getSubmittalElementHeader() != null
				&& CapServiceCommon.SUBMITTAL_STATUS.equals(facilitySubmittalType.getUndergroundStorageTanks()
						.getSubmittalElementHeader().getSubmittalStatus()))
		{
			return true;
		}
		return false;
	}

//	public static void logInfo(GovXML request, GovXML response)
//	{
//
//		try
//		{
//			if (AVProperties.getBoolProperty(AdapterConstants.AA_PRINT_XML_ON_ERROR))
//			{
//				if (request != null)
//				{
//					String requestxml = CommonUtil.marshalGovXML(request);
//					if(requestxml.length()>4096){
//
//					}else{
//					LOGGER.info("request xml:\n" + requestxml);
//					}
//				}
//				if (response != null)
//				{
//					String responsexml = CommonUtil.marshalGovXML(response);
//					LOGGER.info("reponse xml:\n" + responsexml);
//				}
//			}
//		}
//		catch (JAXBException jaxb)
//		{
//		}
//	}

}

/*
 * $Log: av-env.bat,v $
 */
