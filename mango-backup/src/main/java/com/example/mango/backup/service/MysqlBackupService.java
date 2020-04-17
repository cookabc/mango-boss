package com.example.mango.backup.service;

import java.io.IOException;

/**
 * MySql命令行备份恢复服务
 *
 * @author xugang
 */
public interface MysqlBackupService {

    /**
     * 备份数据库
     *
     * @param host             host地址，可以是本机也可以是远程
     * @param userName         数据库的用户名
     * @param password         数据库的密码
     * @param backupFolderPath 备份的路径
     * @param fileName         备份的文件名
     * @param database         需要备份的数据库的名称
     * @return 是否备份成功
     * @throws IOException 抛出异常
     */
    boolean backup(String host, String userName, String password, String backupFolderPath,
                   String fileName, String database) throws IOException;

    /**
     * 恢复数据库
     *
     * @param host            IP地址
     * @param userName        用户名
     * @param password        密码
     * @param database        数据库名称
     * @param restoreFilePath 数据库备份的脚本路径
     * @return 是否恢复成功
     * @throws IOException 抛出异常
     */
    boolean restore(String host, String userName, String password, String restoreFilePath,
                    String database) throws IOException;

}
