package com.accela.adapter.constants;

import com.accela.util.AVProperties;


// TODO: Auto-generated Javadoc
/**
 * <pre>
 *
 * Accela Automation
 * File: AdapterConstants.java
 *
 * Accela, Inc.
 * Copyright (C): 2012-2014
 *
 * Description:
 * TODO
 *
 * Notes:
 * $Id: AdapterConstants.java 72642 2009-01-01 20:01:57Z ACHIEVO\evan.cai $
 *
 * Revision History
 * &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 * Nov 28, 2012		evan.cai		Initial.
 *
 * </pre>
 */
public class AdapterConstants
{

	/** The default encoding of network data communication. */
	public static final String ENCODING = "UTF-8";

	/** The Constant GOVXML_KEY. */
	public static final String GOVXML_KEY = "xmlin";

	/** The Constant ORIGIN_KEY. */
	public static final String ORIGIN_KEY = "origin";

	/** The EnfocementTypeInfo Constants begin*. */
	/****/
	public static final String CME_DATA_STATUS_TYPE_APPROVE = "2";
	
	public static final String CME_DATA_STATUS_TYPE_DELETE = "3";
	
	public static final String CERS_CME_TRANSACTION = "CERS CME Transaction";
	
	public static final String CERS_CME_TRANSACTION_DELETE = "b Delete";
	
	public static final String INSPECTION_STATUS_DELETE="Delete for CERS CME";
	
	public static final String INSPECTION_STATUS_NO_VIOLATIONS="No Violations";
	

	/** *. */
	public static final String GROUP_KEY ="DEH_HENF_T27";

	/** *. */
	public static final String FACILITY_ID ="Facility ID # (1)";

	/** *. */
	public static final String BUSINESS_NAME ="b1_SPECIAL_TEXT";

	/** *. */
	public static final String CERS_ID ="CERS ID Number (1a)";

	/** *. */
	public static final String RED_TAG_DETAILS ="RED TAG DETAILS";
	
	public static final String VIOLATIONS ="VIOLATIONS";

	/** *. */
	public static final String ENFORCEMENT_DETAILS ="ENFORCEMENT DETAILS";

	/** *. */
	public static final String ENFORCEMENT_CASE_DETAILS ="ENFORCEMENT CASE DETAILS";

	/** *. */
	public static final String FINANCIAL_SUMMARY ="FINANCIAL SUMMARY";
	
	public static final String FORMAL_ENFORCEMENT_SUMMARY = "FORMAL ENFORCEMENT SUMMARY";

	/** *. */
	public static final String RED_TAG_ISSUED ="Red Tag Issued (913b)";

	/** *. */
	public static final String RED_TAG_NUMBER = "Red Tag Number (913c)";

	/** *. */
	public static final String VIOLATIONS_CAUSING_RED_TAG ="Violations Causing Red Tag (913d)";

	/** *. */
	public static final String RED_TAGAFF_IXED_ON = "Date Red Tag Affixed (913e)";

	/** *. */
	public static final String RED_TAG_REMOVED_ON ="Date Red Tag Removed (913f)";

	/** *. */
	public static final String TYPE ="Enforcement Action (914)";

	/** *. */
	public static final String OCCURRED_ON ="Date of Initial Enforcement Action (915)";

	/** *. */
	public static final String FORMAL_TYPE ="Formal Enforcement Action (916)";

	/** *. */
	public static final String CASE_SETTLED_DROPPED_ON ="Date Referred Case Settled/Dropped (917a)";

	/** *. */
	public static final String DOCKET_NUMBER ="Court Case/AEO # (918)";

	/** *. */
	//public static final String FINE_ASSESSED_AMOUNT ="Total Penalties to HMD (919)";
	//Update the mapping 
	public static final String FINE_ASSESSED_AMOUNT ="Cash Fines/Penalties Imposed (919)";
	

	/** *. */
	//public static final String SEP_AMOUNT ="SEPs Offsets to Penalties (920)";
	
	public static final String SEP_AMOUNT ="Value of SEP Penalties Imposed (920)";
	
	

	/** *. */
	public static final String COMMENT ="";

	/** The Constant AA_SERVER. */
	public static final String AA_SERVER = "aa.server";

	/** The Constant AA_AGENCY. */
	public static final String AA_AGENCY = "aa.agency";

	/** The Constant AA_USER. */
	public static final String AA_USER = "aa.userID";

	/** The Constant AA_PASSWORD. */
	public static final String AA_PASSWORD = "aa.password";

	/** The Constant CERS_REGULATORCODE. */
	public static final String CERS_REGULATORCODE = "cers.regulatorcode";
	public static final String CERS_STATUS = "cers.status";

	/** The Constant CERS_PASSWORD. */
	public static final String CERS_PASSWORD = "cers.password";

	/** The Constant CERS_USERNAME. */
	public static final String CERS_USERNAME = "cers.username";

	/** The Constant CERS_SERVER_PROXY_PORT. */
	public static final String CERS_SERVER_PROXY_PORT = "cers.server.proxyPort";

	/** The Constant CERS_SERVER_PROXY_HOST. */
	public static final String CERS_SERVER_PROXY_HOST = "cers.server.proxyHost";

	/** The Constant CERS_SERVER_PROXY_SET. */
	public static final String CERS_SERVER_PROXY_SET = "cers.server.proxySet";

	/** The Constant AUTH_INFO. */
	public static final String AUTH_INFO = "user " + AVProperties.getProperty(CERS_USERNAME) + ":"
	+ AVProperties.getProperty(CERS_PASSWORD);

	/** The Constant CERS_SERVER. */
	public static final String CERS_SERVER = "cers.server";

	/** *. */
	public static final int REGULATOR_CODE = Integer.parseInt(AVProperties.getProperty(CERS_REGULATORCODE));

	/** The Constant COMPLETED. */
	public static final String COMPLETE="Complete";

	/** The Constant FACILITY_SUBMIT_TALTYPE. */
	public static final String FACILITY_SUBMIT_TALTYPE="Facility";

	/** The Constant CAPIDS. */
	public static final String CAPIDS = "CAPIDs";

	/** The Constant ADDRESSES. */
	public static final String ADDRESSES = "Addresses";
	public static final String CAPDETIALS = "CapDetails";
	/** The Constant CONTACTS. */
	public static final String CONTACTS = "Contacts";
	public static final String ParcelIds= "Parcels";
	/** The Constant ADDITIONALINFORMATION. */
	public static final String ADDITIONALINFORMATION = "AdditionalInformation";

	/** The Constant ENFORCEMENTCASE. */
	public static final String ENFORCEMENTCASE="EnforcementCase";

	public static final String AA_PRINT_XML_ON_ERROR = "aa.printXMLOnError";

	/**The EnfocementTypeInfo Constants end**/
	
	public static final boolean SYNC_ADDRESS = Boolean.parseBoolean(AVProperties.getProperty("sync.address"));
	public static final boolean SYNC_PARCEL = Boolean.parseBoolean(AVProperties.getProperty("sync.parcel"));
	public static final boolean SYNC_OWNER = Boolean.parseBoolean(AVProperties.getProperty("sync.owner"));
	
	public static final String ENFORCEMENT_VIOLATION_TYPE_ID = "Violation #";
	public static final String ENFORCEMENT_VIOLATION_DATE = "Violation Date";
	public static final String ENFORCEMENT_VIOLATION_CLASS = "Violation Class";
	public static final String ENFORCEMENT_VIOLATION_COMPLIANCE = "Return to Compliance";
	public static final String ENFORCEMENT_VIOLATION_TRANSACTION_DELETE = "a Delete";

}

/*
*$Log: av-env.bat,v $
*/
