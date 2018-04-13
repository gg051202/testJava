package main.java.dimen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UpdateDimen {


    public static void make(String DIRECTORY,float BASE,int[] DIMENS) {

        CreateDir.createDir(DIRECTORY, DIMENS);

        List<ValuesData> list = new ArrayList<>();

        File dirFile = new File(DIRECTORY);
        if (getFileList(list, dirFile)) return;

        BufferedReader reader = null;
        try {
            //读取默认的尺寸
            reader = new BufferedReader(new FileReader(new File(DIRECTORY + "/values-w411dp/dimens.xml")));
            String tempString;
            Pattern pattern1 = Pattern.compile("<dimen.*name=.*>(-*[0-9]+)[a-z]+</dimen>");
            while ((tempString = reader.readLine()) != null) {
                Matcher matcher = pattern1.matcher(tempString);
                if (matcher.find()) {
                    String value = matcher.group(1);
                    String start = tempString.substring(0, matcher.start(1));
                    String end = tempString.substring(matcher.end(1));
                    float num = Float.parseFloat(value);
                    for (ValuesData valuesData : list) {
                        valuesData.result.append(start).append(Math.round(num * valuesData.value / BASE)).append(end).append("\n");
                    }
                } else {
                    for (ValuesData valuesData : list) {
                        valuesData.result.append(tempString).append("\n");
                    }
                }
            }
            reader.close();
            for (ValuesData valuesData : list) {
                writeFile(DIRECTORY,valuesData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    /**
     * 获取文件夹下所有的values文件夹
     */
    private static boolean getFileList(List<ValuesData> list, File dirFile) {
        if (dirFile.listFiles() == null) {
            System.out.println("路劲不正确,请检查文件路径");
            return true;
        }
        Pattern pattern2 = Pattern.compile("values-[^0-9]*([0-9]+)dp");
        for (File f : dirFile.listFiles()) {
            String name = f.getName();
            if (name.startsWith("values-") && name.endsWith("dp")) {
                Matcher matcher = pattern2.matcher(name);
                if (matcher.find()) {
                    list.add(new ValuesData(name, matcher.group(1)));
                }
            }
        }
        return false;
    }

    public static void writeFile(String DIRECTORY, ValuesData valuesData) {
        PrintWriter out = null;
        String fileName = DIRECTORY + "/" + valuesData.dirName + "/dimens.xml";
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
            out.println(valuesData.result.toString());
            System.out.println(valuesData.dirName + " 修改成功");
        } catch (IOException e) {
            System.err.println(fileName + "修改失败");
            e.printStackTrace();
        }

        out.close();
    }


}