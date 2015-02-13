package com.accela.cers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import sun.misc.BASE64Encoder;

public class HashService {

	public String hash(String value) throws Exception {
	    byte[] bytes = value.getBytes("UTF-8");
    	MessageDigest md = MessageDigest.getInstance("SHA-1");
	    byte[] encoded = md.digest(bytes);
	    // base 64
	    BASE64Encoder base64encoder = new BASE64Encoder();
	    return base64encoder.encode(encoded);
	}
	

	public static void main(String[] args) {
		System.out.println("Input value:");
		try {
			BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
			String line=buffer.readLine();
			buffer.close();
			String encodedValue = new HashService().hash(line);
			System.out.println("Encoded value:\n" + encodedValue);
		}catch(Exception e) {
			e.printStackTrace();
			System.err.println("Failed to encode. Please retry or contact your administrator.");
		}
	}
}
