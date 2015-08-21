package com.red.json;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

/**
 * JSON的基本操作,使用的json相关jar包是：org.json.jar
 * @author Red
 */
public class JsonTest {

    /**
     * 对象转为json
     * @return String
     */
    public static String ObjToStr() {
        JSONObject obj = null;
        try {
            obj = new JSONObject();
            obj.put("userName", "Red");
            obj.put("userBlog", "http://www.cnblogs.com/itred");
            obj.put("userGitHub", "http://github.com/itred");
            obj.put("userEmail", "it_red@sina.com");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj.toString();
    }

    /**
     * 判断字符串是否为JSON
     * @param str
     * @return
     */
    public static boolean isJson(String str) {
        JSONObject obj = null;
        try {
            obj = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return obj != null ? true : false;
    }

    /**
     * XML字符串转为json
     * @param str
     * @return
     */
    public static String xmlToJson(String str) {
        try {
            return XML.toJSONObject(str).toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 将map转为json
     * @param map
     * @return
     */
    public static String mapToJson(Map<String, String> map) {
        JSONObject obj = null;
        obj = new JSONObject(map);
        return obj.toString();
    }

    /**
     * 将json转为XML
     * @param str
     * @return
     */
    public static String jsonToXml(String str) {
        if (isJson(str)) {
            try {
                JSONObject obj = new JSONObject(str);
                String xml = XML.toString(obj);
                return xml;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("str is not json");
        }
        return "";
    }

    /**
     * 遍历JSON
     * @param json
     * @param keys
     * @return
     */
    @SuppressWarnings("unchecked")
    public static void getKeys(String json) {
        JSONObject obj = null;
        try {
            obj = new JSONObject(json);
            Iterator<String> it = obj.keys();
            while (it.hasNext()) {
                String key = it.next().toString();
                String value = obj.getString(key);
                System.out.println(key + ":" + value);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取某个key-value值
     * @param json
     * @param key
     * @return
     */
    public static String getKey(String json, String key) {
        String value = null;
        try {
            JSONObject obj = new JSONObject(json);
            value = obj.getString(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return value != null ? value : "";
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // String jsonstr = ObjToStr();
        // String xmlstr = jsonToXml(jsonstr);
        // String str = xmlToJson(xmlstr);
        // getKeys(jsonstr);
        // System.out.println(getKey(jsonstr, "userGitHub"));
        Map<String, String> map = new HashMap<String, String>();
        map.put("userName", "Red");
        map.put("userBlog", "http://www.cnblogs.com/itred");
        map.put("userGitHub", "http://github.com/itred");
        map.put("userEmail", "it_red@sina.com");
        System.out.println(mapToJson(map));
    }

}
