package com.example.mango.admin.mapper;

import com.example.mango.admin.model.SysDict;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xugang
 */
public interface SysDictMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dict
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dict
     *
     * @mbggenerated
     */
    int insert(SysDict record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dict
     *
     * @mbggenerated
     */
    int insertSelective(SysDict record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dict
     *
     * @mbggenerated
     */
    SysDict selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dict
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysDict record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dict
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SysDict record);

    /**
     * 分页查询
     */
    List<SysDict> findPage();

    /**
     * 根据标签名称查询
     *
     * @param label 标签名称
     */
    List<SysDict> findByLabel(@Param(value = "label") String label);

    /**
     * 根据标签名称分页查询
     *
     * @param label 标签名称
     */
    List<SysDict> findPageByLabel(@Param(value = "label") String label);
}