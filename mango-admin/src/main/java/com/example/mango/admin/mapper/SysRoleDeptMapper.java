package com.example.mango.admin.mapper;

import com.example.mango.admin.model.SysRoleDept;

/**
 * @author xugang
 */
public interface SysRoleDeptMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_dept
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_dept
     *
     * @mbggenerated
     */
    int insert(SysRoleDept record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_dept
     *
     * @mbggenerated
     */
    int insertSelective(SysRoleDept record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_dept
     *
     * @mbggenerated
     */
    SysRoleDept selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_dept
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysRoleDept record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_dept
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SysRoleDept record);
}