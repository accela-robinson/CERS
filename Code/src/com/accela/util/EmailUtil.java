package com.accela.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import sun.misc.BASE64Encoder;

/**
 * <pre>
 * 
 *  Accela Automation
 *  $Id: EmailUtil.java 147985 2009-09-16 07:03:28Z ACHIEVO\jack.su $
 * 
 *  Accela, Inc.
 *  Copyright (C): 2007-2012
 * 
 *  Description:
 *  Utility class for sending email messages using the Java Mail API.
 * 
 *  Notes:
 * 
 *  Revision History:
 *  2007-09-08	Kris Trujillo	Initial Version
 *  
 * </pre>
 */

public class EmailUtil
{
	public static boolean debug = false;
	
	private static final Log logger = LogFactory.getLog(EmailUtil.class);
	
	

	public static void sendEmail(String from, String to, String cc, String subject, String content, File[] files)
		throws AddressException, MessagingException, UnsupportedEncodingException
	{
		if(to != null)		
			to = to.replace(';',',');
		
		if(cc !=null )
			cc = cc.replace(';',',');

		Properties props = new Properties();
		props.put("mail.smtp.host", AVProperties.getProperty("av.mail.smtp.host"));
		props.put("mail.protocol.port", Integer.parseInt(AVProperties.getProperty("av.mail.smtp.port")));
				
		Session session = null;
		if (AVProperties.getProperty("av.mail.smtp.auth").equalsIgnoreCase("true"))
		{
			props.put("mail.smtp.auth","true");

			Authenticator mailAuth = new Authenticator(){
				protected PasswordAuthentication getPasswordAuthentication() {
			      return new PasswordAuthentication(AVProperties.getProperty("av.mail.user"), AVProperties.getProperty("av.mail.password"));
			    }
			};
			session = Session.getInstance(props, mailAuth);
		}
		else
		{
			session = Session.getInstance(props);
		}
			
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(from));

		if(to != null && !to.equals(""))
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
		
		if(cc != null && !cc.equals(""))
			msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc));
//		subject = new String(new BASE64Encoder().encode((subject).getBytes("UTF-8")));  
//		if (subject == null || subject.trim().equals(""))
//		{
//			msg.setSubject("");
//		}
//		else
//		{
//			msg.setSubject("=?UTF-8?B?" + subject + "?=");
//		}
		msg.setSubject(subject);
		msg.setSentDate(new Date());
		
		MimeBodyPart mbp1 = new MimeBodyPart();
		mbp1.setContent(content, "text/html;charset=utf-8");

		Multipart mp = new MimeMultipart();
		mp.addBodyPart(mbp1);

		if (files != null)
		{
			for (int i = 0; i < files.length; i++)
			{
				if (files[i] == null)
				{
					continue;
				}
				if (!files[i].exists() || !files[i].canRead())
				{
					continue;
				}

				MimeBodyPart mbp2 = new MimeBodyPart();
				FileDataSource fds = new FileDataSource(files[i]);
				mbp2.setDataHandler(new DataHandler(fds));
				mbp2.setFileName(files[i].getName());
				mp.addBodyPart(mbp2);
			}
		}
		
		msg.setContent(mp);
		Transport.send(msg);		
	}
	
	/**
	 * 
	 * check whether the email address void.
	 *
	 * @param mail email address.
	 * @return
	 */
	public static boolean checkEmail(String mail)
	{
		String regex = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(mail);
		return matcher.find();
	}  
	
	public static void main(String[] args){
		try {
			EmailUtil.sendEmail("james.jiang@achievo.com", "james.jiang@achievo.com", "", "test it", "11111", null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
