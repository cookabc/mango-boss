package com.example.mango.admin.service;

import com.example.mango.admin.model.SysUser;
import com.example.mango.admin.model.SysUserRole;
import com.example.mango.core.page.PageRequest;
import com.example.mango.core.service.CrudService;

import java.io.File;
import java.util.List;
import java.util.Set;

/**
 * @author xugang
 */
public interface SysUserService extends CrudService<SysUser> {

    /**
     * 通过名字找到用户信息
     *
     * @param username 用户名
     * @return 用户信息
     */
    SysUser findByName(String username);

    /**
     * 查找用户的菜单权限标识集合
     *
     * @param userName 用户名
     * @return 权限列表
     */
    Set<String> findPermissions(String userName);

    /**
     * 查找用户的角色集合
     *
     * @param userId 用户id
     * @return 用户角色列表
     */
    List<SysUserRole> findUserRoles(Long userId);

    /**
     * 生成用户信息 Excel 文件
     *
     * @param pageRequest 要导出的分页查询参数
     * @return file
     */
    File createUserExcelFile(PageRequest pageRequest);
}
