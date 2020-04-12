package com.example.mango.admin.service;

import com.example.mango.admin.model.SysMenu;
import com.example.mango.core.service.CrudService;

import java.util.List;

public interface SysMenuService extends CrudService<SysMenu> {

    /**
     * 查询菜单树,用户ID和用户名为空则查询全部
     *
     * @param userName 用户名字
     * @param menuType 获取菜单类型，0：获取所有菜单，包含按钮，1：获取所有菜单，不包含按钮
     * @return 菜单树
     */
    List<SysMenu> findTree(String userName, int menuType);

    /**
     * 根据用户名查找菜单列表
     *
     * @param userName 用户名字
     * @return 菜单树
     */
    List<SysMenu> findByUser(String userName);
}
