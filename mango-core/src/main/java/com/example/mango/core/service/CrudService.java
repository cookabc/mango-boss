package com.example.mango.core.service;

import com.example.mango.core.page.PageRequest;
import com.example.mango.core.page.PageResult;

import java.util.List;

public interface CrudService<T> {

    /**
     * 保存操作
     *
     * @param record
     */
    int save(T record);

    /**
     * 删除操作
     *
     * @param record
     */
    int delete(T record);

    /**
     * 批量删除操作
     *
     * @param entities
     */
    int delete(List<T> entities);

    /**
     * 根据ID查询
     *
     * @param id
     */
    T findById(Long id);

    /**
     * 分页查询
     *
     * @param pageRequest
     * @return PageResult
     */
    PageResult findPage(PageRequest pageRequest);
}
