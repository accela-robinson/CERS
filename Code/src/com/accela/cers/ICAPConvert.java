package com.accela.cers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBElement;

import com.accela.aa.common.ConfigBase;
import com.accela.adapter.model.cap.InitiateCAP;
import com.accela.adapter.model.common.AdditionalInformation;
import com.accela.adapter.model.common.AdditionalInformationGroup;
import com.accela.adapter.model.common.AdditionalInformationSubGroup;
import com.accela.adapter.model.common.AdditionalItem;
import com.accela.adapter.model.common.AdditionalItems;
import com.accela.adapter.model.function.UpdateCAP;
import com.accela.cers.cap.model.ABCFlagType;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: ICAPConvert.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2012-2013
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: ICAPConvert.java 72642 2009-01-01 20:01:57Z ACHIEVO\james.jiang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Nov 29, 2012		james.jiang		Initial.
 * 
 * </pre>
 */
public abstract class ICAPConvert
{
	protected ConfigBase cb = new ConfigBase("dictionary");
	
	protected String aisCodeAndType = "";
	
	protected Map<String, String> asiValueMap = new HashMap<String, String>();
	
	protected Map<String, String> asiTValueMap = new HashMap<String, String>();
	

	public Map<String, String> getAsiValueMap()
	{
		return asiValueMap;
	}

	public void setAsiValueMap(Map<String, String> asiValueMap)
	{
		this.asiValueMap = asiValueMap;
	}

	public Map<String, String> getAsiTValueMap()
	{
		return asiTValueMap;
	}

	public void setAsiTValueMap(Map<String, String> asiTValueMap)
	{
		this.asiTValueMap = asiTValueMap;
	}

	// private static final Log LOGGER = LogFactory.getLog(ICAPConvert.class);
	public void setValue(AdditionalItem ai, JAXBElement<?> ob)
	{
		if (ai != null)
		{
			if (ob != null)
			{
				if (ob.getValue() != null)
				{
					if (ob.getValue() instanceof ABCFlagType)
					{
						ai.setValue(((ABCFlagType) (ob.getValue())).value());
					}
					else
					{
						ai.setValue(ob.getValue().toString());
					}
				}
			}
		}
		else
		{
			// System.out.println();
		}
	}

	protected String toString(Object ob)
	{
		if (ob == null) {
			return null;
		}
		else if ( ob instanceof JAXBElement ) {
			Object value = ((JAXBElement)ob).getValue();
			return (value==null)? null : value.toString();
		}
		else {
			return ob.toString();
		}
	}

	public void setValue(AdditionalItem ai, Object ob)
	{
		if (ai != null)
		{
			if (ob != null)
			{
				ai.setValue(ob.toString());
			}
		}
		else
		{
			// System.out.println();
		}
	}

	public AdditionalItem getAddItem(String name, AdditionalItems addItems)
	{
		Collection<AdditionalItem> caf = addItems.getAdditionalItem();
		for (Iterator<AdditionalItem> addItemIter = caf.iterator(); addItemIter.hasNext();)
		{
			AdditionalItem addItem = addItemIter.next();
			if (addItem.getKeys().getKey().get(0).equals(name))
			{
				return addItem;
			}
		}

		if ("CERS Unique Key".equals(name))
		{
			for (Iterator<AdditionalItem> addItemIter = caf.iterator(); addItemIter.hasNext();)
			{

				AdditionalItem addItem = addItemIter.next();
				if ("String".equals(addItem.getDataType().getType()) || "Text".equals(addItem.getDataType().getType())
						|| "TextArea".equals(addItem.getDataType().getType()))
				{
					AdditionalItem ai = addItem.clone();
					ai.getKeys().getKey().set(0, "CERS Unique Key");

					ai.setIdentifierDisplay("CERS Unique Key");
					ai.setName("CERS Unique Key");
					caf.add(ai);
					return ai;
				}
			}
		}
		// LOGGER.info("asi or asit name is not exist in template."+name);
		return null;

	}

	public Object[] getAddInfoSubGroup(Collection<AdditionalInformationGroup> addInfoGroup, String groupName,
			String subGroupName)
	{
		for (Iterator<AdditionalInformationGroup> iterGroup = addInfoGroup.iterator(); iterGroup.hasNext();)
		{
			AdditionalInformationGroup addGroup = iterGroup.next();
			if (addGroup.getKeys().getKey().get(0).equals(groupName))
			{
				Collection<AdditionalInformationSubGroup> subGroups = addGroup.getAdditionalInformationSubGroup();
				for (Iterator<AdditionalInformationSubGroup> iterSubGroup = subGroups.iterator(); iterSubGroup
						.hasNext();)
				{
					AdditionalInformationSubGroup subGroup = iterSubGroup.next();
					if (subGroup.getKeys().getKey().get(0).equals(subGroupName))
					{
						return new Object[] {addGroup, subGroup};
					}
				}
			}
		}

		return null;

	}
	
	public Collection<AdditionalInformationSubGroup> getAddInfoSubGroup4Existed(Collection<AdditionalInformationGroup> addInfoGroup, String groupName,
			String subGroupName)
	{
		for (Iterator<AdditionalInformationGroup> iterGroup = addInfoGroup.iterator(); iterGroup.hasNext();)
		{
			AdditionalInformationGroup addGroup = iterGroup.next();
			if (addGroup.getIdentifierDisplay().equals(groupName + "/" + subGroupName))
			{
				Collection<AdditionalInformationSubGroup> subGroups = addGroup.getAdditionalInformationSubGroup();
				return subGroups;
			}
		}
		return null;
	}

	public abstract InitiateCAP convertToInitCAP(List<AdditionalInformation> additionInfos, Object currObject,String dataSetDate,
			Object... objects);

	public abstract UpdateCAP convertToUpdateCAP(List<AdditionalInformation> additionInfos, Object currObject,String dataSetDate,
			Object... objects);

	public void setDropdownValue(String value, String name, AdditionalItems asitAdditems) 
	{
		String unit = "";
		Map<String, Map<String, String>> abcList = DropdownCollection.getABCDesc(); 
		Map<String, String> abcValue = abcList.get(name);
		unit = abcValue.get(value);
		if(unit==null || unit=="")
		{
			unit =value;
		}

		setValue(getAddItem(cb.get(name), asitAdditems), unit);
	}
	
	public void setDropdownValue(Map<String, String> map, String name, AdditionalItems asitAdditems) 
	{
		String unit = "";
		Map<String, Map<String, String>> abcList = DropdownCollection.getABCDesc(); 
		Map<String, String> abcValue = abcList.get(name);
		String value = map.get(aisCodeAndType + cb.get(name));
		unit = abcValue.get(value);
		if(unit==null || unit=="")
		{
			unit =value;
		}
		setValue(getAddItem(cb.get(name), asitAdditems), unit);
	}
	
	public String getDropdownValue(String value, String name) 
	{
		String unit = "";
		Map<String, Map<String, String>> abcList = DropdownCollection.getABCDesc(); 
		Map<String, String> abcValue = abcList.get(name);
		unit = abcValue.get(value);
		if(unit==null || unit=="")
		{
			unit =value;
		}

		return unit;
	}

	public String getValue(JAXBElement<?> jax)
	{
		if (jax != null && jax.getValue() != null)
		{
			if (jax.getValue() instanceof ABCFlagType)
			{
				return ((ABCFlagType) (jax.getValue())).value();
			}
			else
			{
				return jax.getValue().toString();
			}
		}
		return null;
	}
	
	public boolean isEmptyValue(String value)
	{
		if (value != null && value.length() > 0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	public boolean isEmptyValue(JAXBElement<?> jax)
	{
		String value = getValue(jax);
		if (value != null && value.length() > 0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public static String parseDateByPattern(String dateStringPara, String pattern)
	{
		String dateStr = new String();
		SimpleDateFormat sdf = null;
		Date sourceDate = null;
		try
		{
			sourceDate = parseDate(dateStringPara);
		}
		catch (ParseException e)
		{
			return dateStringPara;
		}
		if (sourceDate != null)
		{
			if ("MM/dd/yyyy".equals(pattern))
			{
				sdf = new SimpleDateFormat("MM/dd/yyyy");
				dateStr = sdf.format(sourceDate);
			}
			if ("dd/MM/yyyy".equals(pattern))
			{
				sdf = new SimpleDateFormat("dd/MM/yyyy");
				dateStr = sdf.format(sourceDate);
			}
			if ("yyyy-MM-dd".equals(pattern))
			{
				sdf = new SimpleDateFormat("yyyy-MM-dd");
				dateStr = sdf.format(sourceDate);
			}
		}
		return dateStr;
	}
	
	public static java.util.Date parseDate(String dateStringPara) throws ParseException
	{
		String formatStr="yyyy-MM-dd";
		String dateFormat = null;
		if (dateStringPara == null || dateStringPara.length() < 1)
		{
			return null;
		}
		String dateString = dateStringPara.trim().toUpperCase();//
        if(dateString.indexOf("T")>0)  //when ADS call back the Appserver, the Date String in XML includs the char "T"
        {
        	if("T".equalsIgnoreCase(dateString.substring(dateString.length()-1, dateString.length())))
        	{
        		dateString = dateString.replaceAll("T", "");
        	}
        	else
        	{
        		dateString = dateString.replaceAll("T", " ");
        	}            
        }

        if (dateString.indexOf("AM") > 0 || dateString.indexOf("PM") > 0 || dateString.indexOf(" ") > 0)
		{
			if (dateString.indexOf("-") > 0)
			{
				if (dateString.length() <= 13)
				{
					dateFormat = "yyyy-MM-dd aa";
				}
				else if (dateString.length() <= 19)
				{
					dateFormat = "yyyy-MM-dd hh:mm aa";
					//System.out.println(dateFormat + dateString);
				}
				else
				{
					dateFormat = "yyyy-MM-dd hh:mm:ss aa";
				}
			}
			else
			{
				if (dateString.length() <= 13)
				{
					dateFormat = formatStr+" aa";
				}
				else if (dateString.length() <= 19)
				{
					dateFormat = formatStr+" hh:mm aa";
					//System.out.println(dateFormat + dateString);
				}
				else
				{
					dateFormat = formatStr+" hh:mm:ss aa";
				}
			}
		}
		else
		{
			if (dateString.indexOf("-") > 0)
			{
				if (dateString.length() <= 10)
				{
					dateFormat = "yyyy-MM-dd";
				}
				else if (dateString.length() <= 16)
				{
					dateFormat = "yyyy-MM-dd HH:mm";
					//System.out.println(dateFormat + dateString);
				}
				else
				{
					dateFormat = "yyyy-MM-dd HH:mm:ss";
				}
			}
			else
			{
				if (dateString.length() <= 10)
				{
					dateFormat = formatStr;
				}
				else if (dateString.length() <= 16)
				{
					dateFormat = formatStr+" HH:mm";
					//System.out.println(dateFormat + dateString);
				}
				else
				{
					dateFormat = formatStr+" HH:mm:ss";
				}
			}
		}
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.parse(dateString);
	}
	
}

/*
 * $Log: av-env.bat,v $
 */
