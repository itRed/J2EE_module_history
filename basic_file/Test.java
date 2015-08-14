import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Test {
    private final static String FILE_PATH = "/var/local/temp/config.properties";
    private final static int AREACOUNTS = 1000;
    private final static String SUFNAME = "red.";

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
            prop.store(fos, "Update '" + db + "' in.");
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
            props.store(fos, "Delet db:'" + db + "' OK.");
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
     * 根据操作系统类型返回路径
     * @return path
     */
    public static String getPath() {
        return iswindows() ? getRootDirectory() + FILE_PATH : FILE_PATH;
    }

    private static boolean iswindows() {
        return System.getProperty("os.name").contains("Win") ? true : false;
    }

    /**
     * 根据上报刷新任务ID，获取嵌入式库名
     */
    public synchronized static String getRefreshSqliteDb(int taskid) {
        int index = taskid / AREACOUNTS;
        if (taskid % AREACOUNTS != 0) {
            index += 1;
        }
        String dbname = SUFNAME + index;
        return dbname;
    }

    /**
     * 根据文件或文件夹路径创建文件/文件夹
     * @param path
     * @return
     */
    public static boolean createFile(String path) {
        boolean flag = false;
        try {
            File file = new File(path);
            if (file.getName().contains(".")) {
                if (!file.getParentFile().exists()) {
                    flag = file.getParentFile().mkdirs();
                    if (flag) {
                        flag = file.createNewFile();
                    }
                } else {
                    flag = file.createNewFile();
                }
            } else {
                if (!file.getParentFile().exists()) {
                    flag = file.getParentFile().mkdirs();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 获取系统根目录
     * @return
     */
    public static String getRootDirectory() {
        String path = System.getProperty("user.dir");
        String rootdir = path.substring(0, path.indexOf(File.separator));
        return rootdir;
    }

    public static void main(String[] args) {
        System.out.println(getPath());
        System.out.println(createFile(getPath()));
    }
}
