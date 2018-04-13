package main.java.createWx;

import java.io.File;
import java.io.IOException;

class Util {

    static void createDir(String directory) {
        if (!directory.endsWith("/")) {
            directory += "/";
        }
        //防止多输入了斜杠
        directory = directory.replace("//", "/");
        //获取到最后一个文件夹的名字,既是是要创建的文件名字
        String[] strs = directory.split("/");
        String name = strs[strs.length - 1];

        if (createDirectory(directory)) {
            if (createFile(directory + name + ".js") &&
                    createFile(directory + name + ".json") &&
                    createFile(directory + name + ".wxml") &&
                    createFile(directory + name + ".wxss")) {
                System.out.println("创建成功:" + directory);
            }
        }

    }

    /**
     * 创建文件夹
     */
    private static boolean createDirectory(String filePath) {
        if (null == filePath || "".equals(filePath)) {
            return false;
        }
        File file = new File(filePath);
        if (file.exists()) {
            System.err.println("文件夹已存在,创建文件夹失败:" + filePath);
            return false;

        }
        return file.mkdirs();
    }

    /**
     * 根据路径创建文件
     */
    public static boolean createFile(String filePath) {
        if (null == filePath || "".equals(filePath)) {
            System.err.println("路径名称错误,创建失败:" + filePath);
            return false;
        }
        File file = new File(filePath);
        if (file.exists()) {
            System.err.println("文件已存在,创建失败:" + filePath);
            return false;
        }
        try {
            file.createNewFile();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("位置错误,创建失败:" + filePath);
            return false;
        }
    }

}