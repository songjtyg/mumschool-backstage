package com.sjt.cai.mumschool.wechat.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class WeChatSecurityKit {

	public static String sha1(String str) {
		try {
			StringBuffer sb = new StringBuffer();
			MessageDigest md = MessageDigest.getInstance("sha1");
			md.update(str.getBytes());
			byte[] msg = md.digest();
			for(byte b:msg) {
				sb.append(String.format("%02x",b));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String md5(String str) {//todo 检查
		try {
			StringBuffer sb = new StringBuffer();
			MessageDigest md = MessageDigest.getInstance("md5");
			md.update(str.getBytes());
			byte[] msg = md.digest();
			for(byte b:msg) {
				sb.append(String.format("%02x",b));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
}
