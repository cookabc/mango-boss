package com.example.mango.common.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import javax.servlet.http.HttpServletResponse;

public class FileUtils {

    /**
     * 下载文件
     *
     * @param response    响应
     * @param file        文件
     * @param newFileName 文件名
     */
    public static void downloadFile(HttpServletResponse response, File file, String newFileName) {
        try {
            response.setHeader("Content-Disposition",
                    "attachment; filename=" + new String(newFileName.getBytes(StandardCharsets.ISO_8859_1),
                            StandardCharsets.UTF_8));
            BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
            InputStream is = new FileInputStream(file.getAbsolutePath());
            BufferedInputStream bis = new BufferedInputStream(is);
            int length = 0;
            byte[] temp = new byte[1024 * 10];
            while ((length = bis.read(temp)) != -1) {
                bos.write(temp, 0, length);
            }
            bos.flush();
            bis.close();
            bos.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
