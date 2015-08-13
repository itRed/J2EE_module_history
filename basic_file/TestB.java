package com.excloud.test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class TestB {
    private final static String WIN_PATH = "D://config//config.properties";
    private final static String LINUX_PATH = "/var/local/temp/config.properties";

    public static void main(String[] args) {
        // writedb("kkkk");
        // writedb("kkk3");
        // writedb("kkk4");
        // writedb("kkk5");
        // writedb("kkk6");
        // writedb("kkk9");
        deletdb("kkk6");
    }

    /**
     * 写入SQLiteDB数据到properties
     * @param db SQLiteDB
     * @return
     */
    public static boolean writedb(String db) {
        String path = getPath();
        Properties prop = new Properties();
        InputStream fis = null;
        OutputStream fos = null;
        try {
            fis = new FileInputStream(path);
            prop.load(fis);
            fos = new FileOutputStream(path);
            prop.setProperty(db, "null");
            prop.store(fos, "Update '" + db + "' in");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                fis.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 从properties文件中删除SQLiteDB
     * @param db
     * @return
     */
    public static boolean deletdb(String db) {
        String path = getPath();
        Properties props = new Properties();
        InputStream in = null;
        OutputStream fos = null;
        try {
            in = new BufferedInputStream(new FileInputStream(path));
            props.load(in);
            props.remove(db);
            fos = new FileOutputStream(path);
            props.store(fos, "Delet db:'" + db + "' OK");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                in.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 获取操作系统类型
     * @return path
     */
    public static String getPath() {
        String os = System.getProperty("os.name");
        if (os.contains("Win")) {
            return WIN_PATH;
        } else {
            return LINUX_PATH;
        }
    }
}
