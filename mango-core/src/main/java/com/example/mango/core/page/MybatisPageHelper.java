package com.example.mango.core.page;

import com.example.mango.common.utils.ReflectionUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 分页查询助手
 */
public class MybatisPageHelper {

    public static final String findPage = "findPage";

    /**
     * 分页查询，约定查询方法名 findPage
     *
     * @param pageRequest 分页请求
     * @param mapper      Dao对象，Mybatis的Mapper
     */
    public static PageResult findPage(PageRequest pageRequest, Object mapper) {
        return findPage(pageRequest, mapper, findPage);
    }

    /**
     * 分页查询，约定查询方法名 findPage
     *
     * @param pageRequest     分页请求
     * @param mapper          Dao对象，Mybatis的Mapper
     * @param queryMethodName 要分页的查询方法名
     * @param args            方法参数
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static PageResult findPage(PageRequest pageRequest, Object mapper, String queryMethodName, Object... args) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        Object result = ReflectionUtils.invoke(mapper, queryMethodName, args);
        assert result != null;
        return getPageResult(new PageInfo((List<?>) result));
    }

    /**
     * 将分页信息封装到统一的接口
     *
     * @param pageInfo 分页信息
     */
    private static PageResult getPageResult(PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }
}
