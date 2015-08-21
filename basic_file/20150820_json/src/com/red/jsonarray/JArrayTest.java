/**
 * 
 */
package com.red.jsonarray;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author Red
 */
public class JArrayTest {
    private static final int ARRAYSIZE = 3;

    /**
     * jsonarray实例化，获取一个json串
     * @return 2015-8-21 下午02:10:19
     */
    public static String getJsonArray() {
        JSONArray arrayjson = new JSONArray();
        JSONObject obj = null;
        try {
            for (int i = 0; i < ARRAYSIZE; i++) {
                obj = new JSONObject();
                obj.put("userName", "Red" + i);
                obj.put("userBlog", "http://www.cnblogs.com/itred" + i);
                obj.put("userGitHub", "http://github.com/itred" + i);
                obj.put("userEmail", "it_red@sina.com" + i);
                arrayjson.put(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayjson != null ? arrayjson.toString() : "";
    }

    /**
     * @param args 2015-8-21 下午02:05:40
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(getJsonArray());
    }

}
