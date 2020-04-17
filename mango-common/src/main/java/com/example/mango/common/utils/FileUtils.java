package com.example.mango.common.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * @author xugang
 */
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
            int length;
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

    /**
     * 读取txt文件的内容
     *
     * @param file 想要读取的文件路径
     * @return 返回文件内容
     */
    public static String readFile(String file) {
        return readFile(new File(file));
    }

    /**
     * 读取txt文件的内容
     *
     * @param file 想要读取的文件对象
     * @return 返回文件内容
     */
    public static String readFile(File file) {
        StringBuilder result = new StringBuilder();
        try {
            //构造一个BufferedReader类来读取文件
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s;
            while ((s = br.readLine()) != null) {
                //使用readLine方法，一次读一行
                result.append(System.lineSeparator()).append(s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    /**
     * 递归删除文件
     *
     * @param file 待删除文件
     * @return 是否删除成功
     */
    public static boolean deleteFile(File file) {
        // 判断是否是一个目录, 不是的话跳过, 直接删除; 如果是一个目录, 先将其内容清空.
        if (file.isDirectory()) {
            // 获取子文件/目录
            File[] subFiles = file.listFiles();
            // 遍历该目录
            for (File subFile : Objects.requireNonNull(subFiles)) {
                // 递归调用删除该文件: 如果这是一个空目录或文件, 一次递归就可删除.
                // 如果这是一个非空目录, 多次递归清空其内容后再删除
                return deleteFile(subFile);
            }
        }
        // 删除空目录或文件
        return file.delete();
    }

    /**
     * 获取项目根路径
     *
     * @return 根路径
     */
    public static String getProjectPath() {
        String classPath = getClassPath();
        return new File(classPath).getParentFile().getParentFile().getAbsolutePath();
    }

    /**
     * 获取类路径
     *
     * @return 类路径
     */
    public static String getClassPath() {
        return Objects.requireNonNull(FileUtils.class.getClassLoader().getResource("")).getPath();
    }

}
