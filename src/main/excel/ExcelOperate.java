package main.excel;


import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class ExcelOperate {

    private static String gradleFileName = "/Users/guilinlin/Documents/DevelopFiles/AndroidStudioProjects/MyApplication33/app/build.gradle";

    public static void main(String[] args) {

        List<GradleData> gradleList = readExcel();

        StringBuilder sb = new StringBuilder();

        for (GradleData data : gradleList) {
            String src = "        %s {\n" +
                    "            signingConfig signingConfigs.release_%s\n" +
                    "            applicationId = \"%s\"\n" +
                    "            resValue(\"string\", \"app_name\", \"%s\")\n" +
                    "            buildConfigField \"String\", \"CHANEL\", '\"%s\"'\n" +
                    "            buildConfigField \"String\", \"CHANEL_KEY\", '\"%s\"'\n" +
                    "            buildConfigField \"Integer\", \"SERVER_TYPE\", '%s'\n" +
                    "            manifestPlaceholders = [\"APP_LOGO\"     : \"@mipmap/%s\",\n" +
                    "                                    UMENG_APPKEY   : \"%s\",\n" +
                    "                                    UMENG_CHANNEL  : \"%s\",\n" +
                    "                                    ALI_PUSH_APPKEY: \"%s\",\n" +
                    "                                    ALI_PUSH_SECRET: \"%s\"]\n" +
                    "        }";
            sb.append(String.format(src,
                    data.getChannelName(),
                    data.getSignType(),
                    data.getPackageName(),
                    data.getAppName(),
                    data.getChannel(),
                    data.getChannelKey(),
                    data.getServerType(),
                    data.getLogo(),
                    data.getUmengKey(),
                    data.getUmengChannelName(),
                    data.getAliPushKey(),
                    data.getAliPushSecret()))
                    .append("\n\n");

        }
        String result = sb.toString();
        modifyFileContent(result);


    }

    private static boolean modifyFileContent(String insert) {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(gradleFileName, "rw");
            String result = "";
            String line;
            while ((line = raf.readLine()) != null) {
                result += new String(line.getBytes("ISO-8859-1"), "utf-8") + "\n";
            }
            int start = result.indexOf("productFlavors {//多渠道打包\n");
            int end = result.indexOf("    }\n}\n\nrepositories {");
            String str1 = result.substring(0, start+25);
            String str2 = result.substring(end);
            String res = str1 + insert + "\n" + str2;

            byte data[] = res.getBytes();
            FileOutputStream out = new FileOutputStream(gradleFileName);
            out.write(data);
            out.close();
            System.out.println("写入成功");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }




    /**
     * 读取Excel
     *
     * @return 数据集合
     */
    private static List<GradleData> readExcel() {
        List<GradleData> list = new ArrayList<>();
        HSSFWorkbook workbook = null;

        try {
            // 读取Excel文件
            InputStream inputStream = new FileInputStream("/Users/guilinlin/Documents/DevelopFiles/AndroidStudioProjects/MyApplication33/渠道配置.xls");
            workbook = new HSSFWorkbook(inputStream);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 循环工作表
        for (int numSheet = 0; numSheet < workbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = workbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // 循环行
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow == null) {
                    continue;
                }

                // 将单元格中的内容存入集合
                GradleData GradleData = new GradleData();
                try {
                    GradleData.setChannel(hssfRow.getCell(0).getStringCellValue());
                    GradleData.setAppName(hssfRow.getCell(1).getStringCellValue());
                    GradleData.setPackageName(hssfRow.getCell(2).getStringCellValue());
                    GradleData.setChannelKey(hssfRow.getCell(3).getStringCellValue());
                    hssfRow.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
                    GradleData.setAliPushKey(hssfRow.getCell(4).getStringCellValue());
                    hssfRow.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
                    GradleData.setAliPushSecret(hssfRow.getCell(5).getStringCellValue());
                    GradleData.setUmengKey(hssfRow.getCell(6).getStringCellValue());
                    GradleData.setUmengChannelName(hssfRow.getCell(7).getStringCellValue());
                    GradleData.setServerType(hssfRow.getCell(8).getStringCellValue().replaceAll("号", ""));
                    GradleData.setLogo(hssfRow.getCell(9).getStringCellValue().replaceAll("号", ""));
                    GradleData.setSignType(hssfRow.getCell(10).getStringCellValue());
                    list.add(GradleData);
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        }
        return list;
    }
}