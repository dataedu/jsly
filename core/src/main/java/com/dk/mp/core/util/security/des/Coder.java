/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dk.mp.core.util.security.des;

import java.security.MessageDigest;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;


/**
 * des算法实现.
 * @since jdk1.5
 * @version 2013-3-5
 
 */
public abstract class Coder {
	private static final String KEY_SHA = "SHA";
	private static final String KEY_MD5 = "MD5";
	/**
	 * MAC算法可选以下多种算法.
	 * HmacMD5
	 * HmacSHA1
	 * HmacSHA256
	 * HmacSHA384
	 * HmacSHA512
	 */
	private static final String KEY_MAC = "HmacMD5";

	/**
	 * BASE64解密.
	 * @param key 密钥
	 * @return  byte[]
	 * @throws Exception Exception
	 */
	protected static byte[] decryptBASE64(String key) throws Exception {
		return (new BASE64Decoder()).decodeBuffer(key);
	}

	/**
	 * BASE64加密.
	 * @param key 密钥
	 * @return String
	 * @throws Exception Exception
	 */
	protected static String encryptBASE64(byte[] key) throws Exception {
		return (new BASE64Encoder()).encodeBuffer(key);
	}

	/**
	 * MD5加密.
	 * @param data byte[]
	 * @return byte[]
	 * @throws Exception Exception
	 */
	private static byte[] encryptMD5(byte[] data) throws Exception {

		MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);
		md5.update(data);

		return md5.digest();

	}

	/**
	 * SHA加密.
	 * @param data byte[]
	 * @return byte[]
	 * @throws Exception Exception
	 */
	private static byte[] encryptSHA(byte[] data) throws Exception {
		MessageDigest sha = MessageDigest.getInstance(KEY_SHA);
		sha.update(data);
		return sha.digest();
	}

	/**
	    * 初始化HMAC密钥.
	     * @return String
	    * @throws Exception Exception
	    */
	private static String initMacKey() throws Exception {
		KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_MAC);

		SecretKey secretKey = keyGenerator.generateKey();
		return encryptBASE64(secretKey.getEncoded());
	}

	/**
	 * HMAC加密.
	 * @param data byte[]
	 * @param key String
	 * @return byte[]
	 * @throws Exception Exception
	 */
	private static byte[] encryptHMAC(byte[] data, String key) throws Exception {

		SecretKey secretKey = new SecretKeySpec(decryptBASE64(key), KEY_MAC);
		Mac mac = Mac.getInstance(secretKey.getAlgorithm());
		mac.init(secretKey);

		return mac.doFinal(data);

	}

}