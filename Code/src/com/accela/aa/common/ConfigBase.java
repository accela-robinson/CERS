package com.accela.aa.common;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.WeakHashMap;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: ConfigBase.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2012
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: ConfigBase.java 72642 2009-01-01 20:01:57Z ACHIEVO\zony.rao $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Nov 6, 2012		zony.rao		Initial.
 * 
 * </pre>
 */
public class ConfigBase
{
	private static Map<String, String> base = null;

	private static Map<String, Map<String, String>> weakmap = new WeakHashMap<String, Map<String, String>>();
	static
	{
		base = new HashMap<String, String>();
	}

	private static Map<String, String> RBTMap(ResourceBundle rb)
	{
		Map<String, String> depot = new HashMap<String, String>();
		for (Enumeration<?> i = rb.getKeys(); i.hasMoreElements();)
		{
			String key = (String) i.nextElement();
			if (!depot.containsKey(key))
			{
				String value = rb.getString(key);
				depot.put(key, value);
			}

		}
		return depot;
	}

	private Map<String, String> self = null;

	private String name = null;

	public ConfigBase(String name)
	{
		this.setName(name);
		if (name != null)
		{
			if ((self = weakmap.get(name)) == null)
			{
				self = RBTMap(ResourceBundle.getBundle(name));
				if (self != null)
				{
					weakmap.put(name, self);
				}
			}

		}
	}

	public String get(String name)
	{

		if (self == null)
		{
			return base.get(name);
		}
		else
		{
			return self.get(name);
		}

	}

	public String set(String name, String value)
	{

		if (self == null)
		{
			return base.put(name, value);
		}
		else
		{
			return self.put(name, value);
		}

	}

	public Iterator<String> iterator()
	{
		Map<String, String> map = null;
		if (self == null)
		{
			map = base;
		}
		else
		{
			map = self;
		}
		Set<String> keysSet = map.keySet();
		Iterator<String> iterator = keysSet.iterator();
		return iterator;
	}

	public String getName()
	{
		return name;
	}

	private void setName(String name)
	{
		this.name = name;
	}
}

/*
 * $Log: av-env.bat,v $
 */