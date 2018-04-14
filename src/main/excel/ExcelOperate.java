package main.excel;


import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelOperate {

    public static void main(String[] args) {
        List<GradleData> gradleList = readExcel();

        StringBuilder sb = new StringBuilder();

        for (GradleData data : gradleList) {
            String src = " %s {\n" +
                    "                applicationId = \"%s\"\n" +
                    "                resValue(\"string\", \"app_name\", \"%s\")\n" +
                    "                buildConfigField \"String\", \"CHANEL\", '\"%s\"'\n" +
                    "                buildConfigField \"String\", \"CHANEL_KEY\", '\"%s\"'\n" +
                    "                buildConfigField \"Integer\", \"SERVER_TYPE\", '%s'\n" +
                    "                manifestPlaceholders = [\"APP_LOGO\"   : \"@mipmap/%s\",\n" +
                    "                        UMENG_APPKEY : \"%s\",\n" +
                    "                        UMENG_CHANNEL: \"%s\",\n" +
                    "                        ALI_PUSH_APPKEY : \"%s\",\n" +
                    "                        ALI_PUSH_SECRET: \"%s\"]\n" +
                    "            }";
            sb.append(String.format(src,
                    data.getChannelName(),
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

        System.out.println(sb.toString());


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
            InputStream inputStream = new FileInputStream("/Users/guilinlin/Documents/DevelopFiles/AndroidStudioProjects/MyApplication33/彩票渠道配置.xls");
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
                    GradleData.setAliPushKey(hssfRow.getCell(4).getStringCellValue());
                    GradleData.setAliPushSecret(hssfRow.getCell(5).getStringCellValue());
                    GradleData.setUmengKey(hssfRow.getCell(6).getStringCellValue());
                    GradleData.setUmengChannelName(hssfRow.getCell(7).getStringCellValue());
                    GradleData.setServerType(hssfRow.getCell(8).getStringCellValue().replaceAll("号", ""));
                    GradleData.setLogo(hssfRow.getCell(9).getStringCellValue().replaceAll("号", ""));
                    list.add(GradleData);
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        }
        return list;
    }
}