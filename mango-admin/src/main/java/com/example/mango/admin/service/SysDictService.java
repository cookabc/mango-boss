package com.example.mango.admin.service;

import com.example.mango.admin.model.SysDict;
import com.example.mango.core.service.CrudService;

import java.util.List;

/**
 * 字典管理
 */
public interface SysDictService extends CrudService<SysDict> {

    /**
     * 根据标签名称查询
     */
    List<SysDict> findByLabel(String label);
}
