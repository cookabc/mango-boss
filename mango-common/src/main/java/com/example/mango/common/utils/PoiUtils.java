package com.example.mango.common.utils;

import org.apache.poi.ss.usermodel.Workbook;

import java.io.*;

public class PoiUtils {

    /**
     * 生成Excel文件
     *
     * @param workbook 文件类型
     * @param fileName 文件名
     * @return 文件
     */
    public static File createExcelFile(Workbook workbook, String fileName) {
        OutputStream stream = null;
        File file = null;
        try {
            file = File.createTempFile(fileName, ".xlsx");
            stream = new FileOutputStream(file.getAbsoluteFile());
            workbook.write(stream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(workbook);
            IOUtils.closeQuietly(stream);
        }
        return file;
    }

}
