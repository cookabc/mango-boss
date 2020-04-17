package com.example.mango.backup.util;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * @author xugang
 */
public class MySqlBackupRestoreUtils {

    private static final String FILE_PATH_DELIMITER = "/";
    private static final String WIN_OS_PREFIX = "win";

    public static boolean backup(String host, String userName, String password, String backupFolderPath,
                                 String fileName, String database) {
        File backupFolderFile = new File(backupFolderPath);
        if (!backupFolderFile.exists()) {
            // 如果目录不存在则创建
            boolean mkdirs = backupFolderFile.mkdirs();
            if (!mkdirs) {
                return false;
            }
        }
        if (!backupFolderPath.endsWith(File.separator) && !backupFolderPath.endsWith(FILE_PATH_DELIMITER)) {
            backupFolderPath = backupFolderPath + File.separator;
        }
        // 拼接命令行的命令
        String backupFilePath = backupFolderPath + fileName;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mysqldump --opt ").append(" --add-drop-database ").append(" --add-drop-table ");
        stringBuilder.append(" -h").append(host).append(" -u").append(userName).append(" -p").append(password);
        stringBuilder.append(" --result-file=").append(backupFilePath).append(" --default-character-set=utf8 ").append(database);
        // 调用外部执行 exe 文件的 Java API
        Process process;
        try {
            process = Runtime.getRuntime().exec(getCommand(stringBuilder.toString()));
            if (process.waitFor() == 0) {
                // 0 表示线程正常终止
                System.out.println("数据已经备份到 " + backupFilePath + " 文件中");
                return true;
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean restore(String host, String userName, String password, String restoreFilePath,
                                  String database) {
        File restoreFile = new File(restoreFilePath);
        if (restoreFile.isDirectory()) {
            for (File file : Objects.requireNonNull(restoreFile.listFiles())) {
                if (file.exists() && file.getPath().endsWith(".sql")) {
                    restoreFilePath = file.getAbsolutePath();
                    break;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mysql -h").append(host).append(" -u").append(userName).append(" -p").append(password);
        stringBuilder.append(" ").append(database).append(" < ").append(restoreFilePath);
        try {
            Process process = Runtime.getRuntime().exec(getCommand(stringBuilder.toString()));
            if (process.waitFor() == 0) {
                System.out.println("数据已从 " + restoreFilePath + " 导入到数据库中");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static String[] getCommand(String command) {
        String os = System.getProperty("os.name");
        String shell = "/bin/bash";
        String c = "-c";
        if (os.toLowerCase().startsWith(WIN_OS_PREFIX)) {
            shell = "cmd";
            c = "/c";
        }
        return new String[]{shell, c, command};
    }
}
