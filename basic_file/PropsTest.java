package com.red.properties;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropsTest {
	private static final String PROPS_PATH = "props.properties";

	/**
	 * 遍历properties中的所有KEY和VALUE
	 */
	public static void getKV() {
		Properties props = new Properties();
		InputStream in = null;
		try {
			// in = ClassLoader.getSystemResourceAsStream(PROPS_PATH);
			in = new BufferedInputStream(new FileInputStream(PROPS_PATH));
			props.load(in);
			Enumeration enu = props.propertyNames();
			props.list(System.out);
			while (enu.hasMoreElements()) {
				System.out.println("(KEY)" + enu.nextElement() + "=(VALUE)"
						+ props.getProperty((String) enu.nextElement()));
			}
			// Iterator<String> it=props.stringPropertyNames().iterator();
			// while (it.hasNext()) {
			// System.out.println("(KEY)"+it.next()+"=(VALUE)"+props.getProperty(it.next()));
			// }
			//			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 根据KEY值获取properties中的VALUE
	 * 
	 * @param key
	 * @return
	 */
	public static String getValue(String key) {
		Properties props = new Properties();
		InputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream(PROPS_PATH));
			props.load(in);
			return props.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 在properties中添加一条KEY-VALUE记录
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public static boolean write(String key, String value) {
		Properties props = new Properties();
		InputStream in = null;
		OutputStream ou = null;
		try {
			// in = ClassLoader.getSystemResourceAsStream("/props.properties");
			in = new BufferedInputStream(new FileInputStream(PROPS_PATH));
			props.load(in);
			ou = new BufferedOutputStream(new FileOutputStream(PROPS_PATH));
			props.setProperty(key, value);
			props.store(ou, "INSERT KEY-VALUE :" + key + "=" + value + "***");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				ou.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * properies保存为xml
	 */
	public static boolean getXmlFile() {
		Properties props = new Properties();
		InputStream in = null;
		OutputStream ou = null;
		try {
			in = new BufferedInputStream(new FileInputStream(PROPS_PATH));
			props.load(in);
			ou = new BufferedOutputStream(new FileOutputStream(new File(
					"D:/test.xml")));
			props.storeToXML(ou, "测试");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 从xml中获取值
	 */
	public static String getKeyByXml(String key) {
		Properties props = new Properties();
		String XML_PATH = "D:/test.xml";
		InputStream in = null;
		try {
			in = new BufferedInputStream(
					new FileInputStream(new File(XML_PATH)));
			props.loadFromXML(in);
			String value = props.getProperty(key);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 将map中的值写入到properties
	 */
	public static boolean mapToProps(Map<String, String> map) {
		Properties props = new Properties();
		InputStream in = null;
		OutputStream os = null;
		try {
			in = new BufferedInputStream(new FileInputStream(PROPS_PATH));
			props.load(in);
			os = new BufferedOutputStream(new FileOutputStream(PROPS_PATH));
			for (Map.Entry<String, String> entry : map.entrySet()) {
				props.setProperty(entry.getKey(), entry.getValue());
			}
			props.store(os, "Insert all map");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			// TODO: handle exception
		}
	}

	/**
	 * main方法测试
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// HashMap<String, String> map = new HashMap<String, String>();
		// map.put("map1", "map测试1");
		// map.put("map2", "map测试2");
		// map.put("map3", "map测试3");
		// mapToProps(map);
		// write("tested", "wangxingyu测试");
		// getXmlFile();
		// getKV();
//		String value = getValue("map1");
//		System.out.println(value);
		System.out.println(getKeyByXml("test"));
	}

}
