package com.red.mail.util;

/**
 * 常用方法类
 * 
 * @version 1.0
 */
public class Util {

	/**
	 * 判断是不是windows系统
	 * 
	 * @return true|false
	 */
	public static boolean iswindows() {
		String os = System.getProperty("os.name").toLowerCase();
		if (os.contains("windows")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断字符串是不是数字
	 * 
	 * @param str
	 * @return true|false
	 */
	public static boolean isNumeric(String str) {
		for (int i = str.length(); --i >= 0;) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 判断是不是远程地址
	 * 
	 * @param path
	 * @return true|false
	 */
	public static boolean isRemote(String path) {
		boolean b = path.startsWith("http");
		return b;
	}

}
