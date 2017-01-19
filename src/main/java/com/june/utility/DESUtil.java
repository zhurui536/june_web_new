/*   
 * Copyright (c) 2010-2020 JUNE. All Rights Reserved.   
 *   
 * This software is the confidential and proprietary information of   
 * JUNE. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with JUNE.   
 *   
 */
package com.june.utility;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import org.apache.commons.codec.binary.Base64;

/**
 * 
 * DES算法工具类 <br>
 * 
 * @author 王俊伟 wjw.happy.love@163.com
 * @date 2016年8月31日 下午5:54:20
 */
public class DESUtil {
	static byte[] KEY_BYTE = Const.KEY_BYTE;
	static Key key;

	/**
	 * 根据参数生成KEY
	 * 
	 * @param strKey
	 * @date 2016年12月20日 下午9:15:23
	 * @writer junehappylove
	 */
	private static void getKey(byte[] strKey) {
		try {
			KeyGenerator _generator = KeyGenerator.getInstance("DES");
			_generator.init(new SecureRandom(strKey));
			key = _generator.generateKey();
			_generator = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 加密String明文输入,String密文输出
	 * 
	 * @param strMing
	 *            明文
	 * @return 密文
	 */
	public static String getEncString(String strMing) {
		DESUtil.getKey(KEY_BYTE);// 生成密匙
		byte[] byteMi = null;
		byte[] byteMing = null;
		String strMi = "";
		try {
			byteMing = strMing.getBytes("UTF-8");
			byteMi = getEncCode(byteMing);
			strMi = Base64.encodeBase64String(byteMi);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			byteMing = null;
			byteMi = null;
		}
		return strMi;
	}

	/**
	 * 解密 以String密文输入,String明文输出
	 * 
	 * @param strMi
	 *            密文
	 * @return 明文
	 */
	public static String getDesString(String strMi) {
		DESUtil.getKey(KEY_BYTE);// 生成密匙
		byte[] byteMing = null;
		byte[] byteMi = null;
		String strMing = "";
		try {
			byteMi = Base64.decodeBase64(strMi);
			byteMing = getDesCode(byteMi);
			strMing = new String(byteMing, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			byteMing = null;
			byteMi = null;
		}
		return strMing;
	}

	/**
	 * 加密以byte[]明文输入,byte[]密文输出
	 * 
	 * @param byteS
	 *            明文字节集
	 * @return 密文字节集
	 */
	private static byte[] getEncCode(byte[] byteS) {
		byte[] byteFina = null;
		Cipher cipher;
		try {
			cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byteFina = cipher.doFinal(byteS);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cipher = null;
		}
		return byteFina;
	}

	/**
	 * 解密以byte[]密文输入,以byte[]明文输出
	 * 
	 * @param byteD
	 *            密文字节集
	 * @return 明文字节集
	 */
	private static byte[] getDesCode(byte[] byteD) {
		Cipher cipher;
		byte[] byteFina = null;
		try {
			cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byteFina = cipher.doFinal(byteD);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cipher = null;
		}
		return byteFina;
	}

	public static void main(String[] args) {
		// 请尊重原作者的标识
		String key = "jdbc:mysql://localhost:3306/june_web_new?useUnicode=yes&amp;characterEncoding=UTF-8";
		String strEnc = DESUtil.getEncString(key);// 加密字符串,返回String的密文
		System.out.println(strEnc);
		String decode = "edPGEaedFAU6W3vfL5QCuEJiYfxsN51RiIUPLbuY7MYJBbOGYi/d29aBNMe9jmeu7HgnWQVvctMieS1XKAhQoIpS5oNaFUcnPKO7Od38hXHsnLQB58j/AA==";
		String strDes = DESUtil.getDesString(decode);// 把String 类型的密文解密
		System.out.println(strDes);
	}
}
