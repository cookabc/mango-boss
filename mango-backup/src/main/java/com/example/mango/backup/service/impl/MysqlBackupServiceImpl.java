package com.example.mango.backup.service.impl;

import com.example.mango.backup.service.MysqlBackupService;
import com.example.mango.backup.util.MySqlBackupRestoreUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author xugang
 */
@Service
public class MysqlBackupServiceImpl implements MysqlBackupService {
    @Override
    public boolean backup(String host, String userName, String password, String backupFolderPath,
                          String fileName, String database) throws IOException {
        return MySqlBackupRestoreUtils.backup(host, userName, password, backupFolderPath, fileName, database);
    }

    @Override
    public boolean restore(String host, String userName, String password, String restoreFilePath,
                           String database) throws IOException {
        return MySqlBackupRestoreUtils.restore(host, userName, password, restoreFilePath, database);
    }
}
