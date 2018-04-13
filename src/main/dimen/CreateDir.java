package main.java.dimen;

import java.io.File;
import java.io.IOException;

class CreateDir {

    static void createDir(String directory, int... dimens) {
        for (int dimen : dimens) {
            String fileName = directory + "/values-w" + dimen + "dp";
            createDirectory(fileName);
        }
    }

    /**
     * 创建文件夹
     *
     */
    private static boolean createDirectory(String filePath) {
        if (null == filePath || "".equals(filePath)) {
            return false;
        }
        File file = new File(filePath);
        return !file.exists() && file.mkdir();
    }

    /**
     * 根据路径创建文件
     *
     */
    public static boolean createFile(String filePath) {
        boolean result ;
        if (null == filePath || "".equals(filePath)) {
            return false;
        }
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
            result = true;
        } catch (IOException e) {
            result = false;
            e.printStackTrace();
        }
        return result;
    }

}