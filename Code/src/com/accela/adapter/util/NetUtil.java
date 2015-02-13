package com.accela.adapter.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *  <pre>
 *   
 *    Accela IVR
 *    $Id: NetUtil.java 145056 2009-08-27 23:55:57Z jing.liu $
 *   
 *    Accela, Inc.
 *    Copyright (C): 2009-2014
 *   
 *    Description:
 *   	This class is a network utility class.
 *   
 *    Revision History:
 *    2008/01/15  Koti Reddy          Initial versions
 * </pre>
 * 
 */
public class NetUtil {

	private static final Log LOGGER = LogFactory.getLog(NetUtil.class);

	/**
	 * Make connection to a network URL and return the response content as a
	 * string. E.g. it may be called for HTTP/GET connections.
	 * 
	 * @param urlStr
	 *            the target URL.
	 * @param encoding
	 *            the expected response content encoding, e.g. "UTF-8", and use
	 *            the default encoding if it is null.
	 * @return the response content string.
	 */
	public static String getResponseStr(String urlStr, String encoding)
			throws MalformedURLException, IOException {
		// Connect the server, send request, and get input stream from server
		URL url = new URL(urlStr);
		InputStream in = url.openStream();
		InputStreamReader isr = (encoding == null) ? new InputStreamReader(in)
				: new InputStreamReader(in, encoding);
		BufferedReader r = new BufferedReader(isr);

		// Receive the response from the server
		StringBuilder sb = new StringBuilder(1024);
        readThruBuffer(r, sb);

		// Close the input stream
		r.close();

		return sb.toString();
	}
	
	/**
	 * Make connection to a network URL and return the response content as a
	 * string. The default encoding is used when converting the response stream
	 * to string. E.g. it may be called for HTTP/GET connections.
	 * 
	 * @param urlStr
	 *            the target URL.
	 * @return the response content string.
	 */
	public static String getResponseStr(String urlStr)
			throws MalformedURLException, IOException {
		return getResponseStr(urlStr, null);
	}

	/**
	 * Make HTTP/POST connection to a network URL and return the response
	 * content as a string.
	 * 
	 * @param urlStr
	 *            the target URL.
	 * @param postStr
	 *            the posted request data string.
	 * @param encoding
	 *            the expected response content encoding, e.g. "UTF-8", and use
	 *            the default encoding if it is null.
	 * @return the response content string.
	 */
	public static String getHttpPostResponseStr(String urlStr, String postStr,
			String encoding) throws Exception, IOException {
		// Connect the server
		URL url = new URL(urlStr);
		StringBuilder sb = null;
		HttpURLConnection conn = null;
		PrintWriter out = null;
		BufferedReader in = null;
		
		try{
			
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded; charset=utf-8");			
			conn.setDoOutput(true);
			//LOGGER.debug("------Connect the server---------" );
			// Get the output stream to the server
			if (encoding == null) {
				out = new PrintWriter(
						new OutputStreamWriter(conn.getOutputStream()), true);
			} else {
				out = new PrintWriter(new OutputStreamWriter(
						conn.getOutputStream(), encoding), true);
			}
			// Post the request to the server and close the output stream
			out.println(postStr);
			out.close();
			//LOGGER.debug("------Post the request to the server and close the output stream---------" );
			
			// Get the input stream from the server
			if (encoding == null) {
				in = new BufferedReader(
						new InputStreamReader(conn.getInputStream()));
			} else {
				in = new BufferedReader(new InputStreamReader(
						conn.getInputStream(), encoding));
			}
			//LOGGER.debug("------Get the input stream from the server---------" );
			// Receive the response from the server
	        sb = new StringBuilder(1024);
	        readThruBuffer(in, sb);
	        LOGGER.debug("------Receive the response from the server---------" );

		}catch(IOException e){
			throw e;
		}catch(Exception e){
			throw e;
		}finally{
			// Close the input stream and the network connection
			if(in!=null)in.close();
			if(out!=null)out.close();
			if(conn!=null)conn.disconnect();
		}

		return sb.toString();
	}
	
	
	

	public static void readThruBuffer(BufferedReader r, StringBuilder sb) throws IOException {
		// Receive the response from the server
		char[] buffer = new char[1024];
		int c;
		while ( (c = r.read(buffer)) > 0 ) {
			sb.append(buffer, 0, c);
		}
	}
	
	
	
}
