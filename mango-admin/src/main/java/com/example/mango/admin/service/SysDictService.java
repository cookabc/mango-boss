package com.example.mango.admin.service;

import com.example.mango.admin.model.SysDict;
import com.example.mango.core.service.CrudService;

import java.util.List;

/**
 * 字典管理
 *
 * @author xugang
 */
public interface SysDictService extends CrudService<SysDict> {

    /**
     * 根据标签名称查询
     *
     * @param label 标签名称
     * @return 字典列表
     */
    List<SysDict> findByLabel(String label);
}
