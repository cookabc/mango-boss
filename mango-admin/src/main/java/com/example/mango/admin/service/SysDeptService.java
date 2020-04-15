package com.example.mango.admin.service;

import com.example.mango.admin.model.SysDept;
import com.example.mango.core.service.CrudService;

import java.util.List;

/**
 * @author xugang
 */
public interface SysDeptService extends CrudService<SysDept> {

    /**
     * 查询机构树
     *
     * @return 部门列表
     */
    List<SysDept> findTree();

}
