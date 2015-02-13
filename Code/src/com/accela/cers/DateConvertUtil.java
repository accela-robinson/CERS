package com.accela.cers;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

import org.apache.log4j.Logger;

import com.accela.adapter.model.common.AdditionalInformationGroup;
import com.accela.adapter.model.common.AdditionalInformationSubGroup;
import com.accela.adapter.model.common.AdditionalItem;
import com.accela.adapter.model.common.Keys;
import com.accela.adapter.model.inspection.Guideitem;
import com.accela.adapter.model.inspection.Guidesheet;
import com.accela.adapter.model.inspection.Inspection;
import com.accela.adapter.model.inspection.Status;
import com.accela.adapter.service.impl.InspectionService;
import com.accela.adapter.util.CapUtil;
import com.accela.cers.inspection.model.YesNoFlagType;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: DateCovertUtil.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2012-2014
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: DateCovertUtil.java 72642 2009-01-01 20:01:57Z ACHIEVO\winchill.chen $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  2012-11-30		winchill.chen		Initial.
 * 
 * </pre>
 */
public class DateConvertUtil
{
	private static Logger logger = Logger.getLogger(DateConvertUtil.class);
	public static Date str2Date(String str)
	{
		DateFormat format = null;
		if(Pattern.matches("([0-9]{1,2})/([0-9]{1,2})/([0-9]{4})", str))
		{
			format = new SimpleDateFormat("MM/dd/yyyy");
		}
		else
		{
			format = new SimpleDateFormat("yyyy-MM-dd");
		}
		Date date = null;
		try
		{
			date = format.parse(str); // Thu Jan 18 00:00:00 CST 2007
		}
		catch (ParseException e)
		{
			logger.info(str+":String convert to Date exception"+"\n");
		}
		return date;
	}

	public static XMLGregorianCalendar date2Gregorian(String str)
	{
		XMLGregorianCalendar temp = null;
		DatatypeFactory dataTypeFactory;
		GregorianCalendar gc = new GregorianCalendar();
		if(str != null&&!"".equals(str)){
			try
			{   Date date = str2Date(str);
				dataTypeFactory = DatatypeFactory.newInstance();
				gc.setTimeInMillis(date.getTime());
				temp = dataTypeFactory.newXMLGregorianCalendar(gc);
			}
			catch (Exception e)
			{
				logger.info(str+":String convert to GregorianCalendar exception"+"\n");
			}
		}
		return temp;
	}

	public static XMLGregorianCalendar dateTime(Date date)
	{
		XMLGregorianCalendar temp = null;
		if(date != null && !"".equals(date)){
			GregorianCalendar gc = new GregorianCalendar();
			DatatypeFactory dataTypeFactory;
			try
			{
				dataTypeFactory = DatatypeFactory.newInstance();
				gc.setTimeInMillis(date.getTime());
				temp = dataTypeFactory.newXMLGregorianCalendar(gc);
			}
			catch (DatatypeConfigurationException e)
			{
				throw new RuntimeException(e);
			}
		}
		
		return temp;
	}

	public static JAXBElement<String> stringToJAXBElementStr(String str,String name)
	{
		JAXBElement<String> temp = null;
		if(str !=null && !"".equals(str)){
		try
		{
				temp = new JAXBElement<String>(new QName("",name), String.class, str);
			}
		catch (Exception e)
		{
			System.out.print(name+":String convert to JAXBElement<String> reuslt is wrong!"+"\n");
		}
		return temp;
		}else{
			return new JAXBElement<String>(new QName("",name), String.class, "");
		}

	}

	public static JAXBElement<BigInteger> stringToJAXBElementBigBigInteger(String str,String name)
	{
		JAXBElement<BigInteger> jaxb = null;
		if(str !=null && !"".equals(str)){
		try
		{
				
            	BigInteger temp = new BigInteger(str);
            	jaxb = new JAXBElement<BigInteger>(new QName("",name), BigInteger.class, temp);
		}
		catch (Exception e)
		{   
			//jaxb = new JAXBElement<BigInteger>(new QName(""), BigInteger.class, null);
			System.out.print(name+":String convert to JAXBElement<BigInteger> reuslt is wrong!"+"\n");
		}
		return jaxb;
		}else{
			return new JAXBElement<BigInteger>(new QName("",name), BigInteger.class, null);
		}

	}

	public static JAXBElement<XMLGregorianCalendar> strintToJAXBElemtXMLGregorianCalendar(String str,String name)
	{
		if(str != null){
		JAXBElement<XMLGregorianCalendar> temp = null;
		try
		{
			XMLGregorianCalendar gc = DateConvertUtil.date2Gregorian(str);
			temp = new JAXBElement<XMLGregorianCalendar>(new QName("",name), XMLGregorianCalendar.class, gc);
		}
		catch (Exception e)
		{
			//temp = new JAXBElement<XMLGregorianCalendar>(new QName(""), XMLGregorianCalendar.class, null);
			System.out.print(name+":convert to JAXBElement<XMLGregorianCalendar> reuslt is wrong!"+"\n");
		}
		    return temp;
		}else{
			return new JAXBElement<XMLGregorianCalendar>(new QName("",name), XMLGregorianCalendar.class, null);
		}
	}
	public static JAXBElement<XMLGregorianCalendar> ToJAXBElemtXMLGregorianCalendar(XMLGregorianCalendar str,String name)
	{
		if(str != null && !"".equals(str)){
		JAXBElement<XMLGregorianCalendar> temp = null;
		try
		{
		   temp = new JAXBElement<XMLGregorianCalendar>(new QName("",name), XMLGregorianCalendar.class, str);
		}
		catch (Exception e)
		{
			//temp = new JAXBElement<XMLGregorianCalendar>(new QName(""), XMLGregorianCalendar.class, null);
			System.out.print(name+":convert to JAXBElement<XMLGregorianCalendar> reuslt is wrong!"+"\n");
		}
		return temp;
		}else{
			return new JAXBElement<XMLGregorianCalendar>(new QName("",name), XMLGregorianCalendar.class, null);
		}
	}
	
	public static JAXBElement<com.accela.cers.inspection.model.YesNoFlagType> strConvertToYesNoFlagType(String str,String name){
		if(str != null && !"".equals(str)){
		JAXBElement<com.accela.cers.inspection.model.YesNoFlagType> temp = null;
		try
		{
			YesNoFlagType redTagIssued = YesNoFlagType.fromValue(str);
			temp = new JAXBElement<YesNoFlagType>(new QName("",name),YesNoFlagType.class, redTagIssued);
		}
		catch (Exception e)
		{
			//temp = new JAXBElement<YesNoFlagType>(new QName(""),YesNoFlagType.class, null);
			logger.info(name+":String convert to JAXBElement<YesNoFlagType> exception"+"\n");
		}
		return temp;
		}else{
			return new JAXBElement<YesNoFlagType>(new QName("",name),YesNoFlagType.class, null);
		}
	}
	
	//get cersId
		public static String getCersID(Inspection inspection){
			String cersId = null;
			if(inspection != null && inspection.getCAPId()!= null && inspection.getCAPId().getKeys()!=null &&inspection.getCAPId().getKeys().size()>0){
				List<String> inspectionCapIdKeyList = inspection.getCAPId().getKeys().get(0).getKey();
				String key1= (String) inspectionCapIdKeyList.get(0);
				String key2= (String) inspectionCapIdKeyList.get(1);
				String key3= (String) inspectionCapIdKeyList.get(2);
				try
				{
					cersId = CapUtil.getCersIdByCapId(key1, key2, key3);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
			return cersId;
		}
		//inspection key
		public static String getInpsectionKey(Inspection inspection){
			StringBuffer inspetionKey = new StringBuffer();
			if(inspection.getKeys()!=null && inspection.getKeys().getKey().size()>0){
				for(int i=0;i<inspection.getKeys().getKey().size();i++){
					inspetionKey.append(inspection.getKeys().getKey().get(i)).append("-");
				}
			}
			return inspetionKey.toString().substring(0, inspetionKey.length()-1);
			
		}
		//get G6_ACT_NUM
		public static String getInpsectionKey4th(Inspection inspection){
			String g6_act_num ="";
			if(inspection.getKeys()!=null && inspection.getKeys().getKey().size()>=4){
				g6_act_num = inspection.getKeys().getKey().get(3);
			}
			return g6_act_num;
			
		}
		//get Inspector givenName & familyName
		public static String getInspector(Inspection inspection){
			StringBuffer comment = new StringBuffer();
			if(inspection != null && inspection.getInspector()!=null && inspection.getInspector().getPerson()!=null){
				if(inspection.getInspector().getPerson().getFamilyName()!=null){
					comment.append(inspection.getInspector().getPerson().getFamilyName()).append(" ");
				}
				if(inspection.getInspector().getPerson().getGivenName()!=null){
					comment.append(inspection.getInspector().getPerson().getGivenName()).append(" ");
				}

			}
			//Eric Liu fix, if there is not givenname and familyname return. then use keys/key
			if (comment.toString().trim().length()==0)
			{
				comment.append(inspection.getInspector().getKeys().getKey().get(0)).append(" ");
			}
			return comment.toString();
			
		}
		
		//inspection type
		public static String getInspectionType(Inspection inspection){
			String inspectionType = null;
			if(inspection.getType()!=null && inspection.getType().getKeys()!=null &&inspection.getType().getKeys().getKey().size()>0){
				inspectionType = inspection.getType().getKeys().getKey().get(1);
			}
			return inspectionType;
		}
		//inspection typeValue
			public static String getInspectionTypeValue(Inspection inspection){
				String inspectionTypeValue = null;
				if(inspection.getType()!=null && inspection.getType().getKeys()!=null &&inspection.getType().getKeys().getKey().size()>0){
					String inspectionType = inspection.getType().getKeys().getKey().get(1);
					if("Routine".equals(inspectionType)){
						inspectionTypeValue ="a";
					}else{
						inspectionTypeValue ="b";
					}
				}
				return inspectionTypeValue;
			}
		//guidesheet key
		public static String getGuidesheetKey(Guidesheet guidesheet){
			String guidsheetKey =null;
			if(guidesheet.getKeys()!=null && guidesheet.getKeys().getKey().size()>0){
				guidsheetKey = guidesheet.getKeys().getKey().get(1);
			}
			return guidsheetKey;
		}
		//guideitem key
		public static String getGuideitemKey(Guidesheet guidesheet){
			String guideitemKey = null;
			//guideitem
			if(guidesheet.getGuideitems()!=null && guidesheet.getGuideitems().getGuideitem().size()>0){
				for(Guideitem guideItem:guidesheet.getGuideitems().getGuideitem()){
					if(guideItem.getKeys()!=null && guideItem.getKeys().getKey().size()>0){
					 guideitemKey = guideItem.getKeys().getKey().get(0);
					}
					
				}
			}
			
			return guideitemKey;
		}
		//guideitem status
		public static String getGuideItemStatus(Status status){
			String guideItemStatus = null;
			if(status!=null && status.getKeys()!= null && status.getKeys().getKey().size()>0){
				guideItemStatus = status.getKeys().getKey().get(0);
			}
			return guideItemStatus;
		}
		//get group key
		public static String getGroupKey(AdditionalInformationGroup group){
			String groupKey = null;
			if(group.getKeys()!=null && group.getKeys().getKey().size()>0){
				  groupKey = group.getKeys().getKey().get(0);
			}
			return groupKey;
		}
		//get group key
		public static String getSubGroupKey(AdditionalInformationSubGroup subgroup){
			String subgroupKey = null;
			if(subgroup.getKeys()!= null&&subgroup.getKeys().getKey().size()>0){
				subgroupKey = subgroup.getKeys().getKey().get(0);
			}
			return subgroupKey;
				
		}
		//get group key
		public static String getLabel(AdditionalItem additionalItem){
		     String label = null;
		     if(additionalItem.getKeys()!= null&&additionalItem.getKeys().getKey().size()>0){
		    	 label = additionalItem.getKeys().getKey().get(0);
				}
			return label;
		}
		//get value
		public static String getValue(AdditionalItem additionalItem){
			String value = null;
			if(additionalItem != null){
			  value = additionalItem.getValue();
			}
			return value;
		}

		public static String StringConvertTdate(String str){
			String dateString = null;
			if(str!=null && !"".equals(str)){
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-DD");
				dateString = formatter.format(str);
			}
			return dateString;
		}

	/**
	 * 
	 * Get key from keys.
	 *
	 * @param keys the keys.
	 * @return
	 */
	public static String getKeyFromKeys(Keys keys)
	{
		String key = null;
		if (keys != null && keys.getKey() != null && keys.getKey().size() > 0)
		{
			key = keys.getKey().get(0);
		}
		return key;

	}
	
	public static boolean isNumeric(String text)
	{
		if(text == null || text.trim().length() == 0 )
		{
			return false;
		}
		
		Pattern p = Pattern.compile("[0-9]*");
		return p.matcher(text.trim()).matches();
	}

}
/*
 * $Log: av-env.bat,v $
 */
