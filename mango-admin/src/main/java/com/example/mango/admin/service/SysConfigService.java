package com.example.mango.admin.service;

import com.example.mango.admin.model.SysConfig;
import com.example.mango.core.service.CrudService;

import java.util.List;

/**
 * @author xugang
 */
public interface SysConfigService extends CrudService<SysConfig> {

    /**
     * 根据名称查询
     *
     * @param label 标签名称
     * @return 配置列表
     */
    List<SysConfig> findByLabel(String label);

}
