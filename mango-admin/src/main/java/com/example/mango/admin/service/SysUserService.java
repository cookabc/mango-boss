package com.example.mango.admin.service;

import com.example.mango.admin.model.SysUser;
import com.example.mango.core.page.PageRequest;
import com.example.mango.core.page.PageResult;
import com.example.mango.core.service.CrudService;

import java.io.File;
import java.util.List;

public interface SysUserService extends CrudService<SysUser> {

    /**
     * 查找所有用户
     */
    List<SysUser> findAll();

    /**
     * 分页查询
     */
    PageResult findPage(PageRequest pageRequest);

    /**
     * 生成用户信息 Excel 文件
     *
     * @param pageRequest 要导出的分页查询参数
     * @return file
     */
    File createUserExcelFile(PageRequest pageRequest);
}
