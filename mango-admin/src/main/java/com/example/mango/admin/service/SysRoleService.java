package com.example.mango.admin.service;

import com.example.mango.admin.model.SysMenu;
import com.example.mango.admin.model.SysRole;
import com.example.mango.admin.model.SysRoleMenu;
import com.example.mango.core.service.CrudService;

import java.util.List;

public interface SysRoleService extends CrudService<SysRole> {

    /**
     * 查询全部
     *
     * @return 角色列表
     */
    List<SysRole> findAll();

    /**
     * 查询角色菜单集合
     *
     * @param roleId 角色id
     * @return 角色列表
     */
    List<SysMenu> findRoleMenus(Long roleId);

    /**
     * 保存角色菜单
     *
     * @param records 角色列表
     * @return 成功与否
     */
    int saveRoleMenus(List<SysRoleMenu> records);

    /**
     * 根据名称查询
     *
     * @param name 角色名字
     * @return 角色列表
     */
    List<SysRole> findByName(String name);
}
