package com.example.mango.core.service;

import com.example.mango.core.page.PageRequest;
import com.example.mango.core.page.PageResult;

import java.util.List;

/**
 * @author xugang
 */
public interface CrudService<T> {

    /**
     * 保存操作
     *
     * @param record 操作对象
     * @return 操作结果
     */
    int save(T record);

    /**
     * 删除操作
     *
     * @param record 操作对象
     * @return 操作结果
     */
    int delete(T record);

    /**
     * 批量删除操作
     *
     * @param entities 操作对象
     * @return 操作结果
     */
    int delete(List<T> entities);

    /**
     * 根据ID查询
     *
     * @param id 查询id
     * @return 操作结果
     */
    T findById(Long id);

    /**
     * 分页查询
     *
     * @param pageRequest 分页请求
     * @return PageResult 请求结果
     */
    PageResult findPage(PageRequest pageRequest);
}
