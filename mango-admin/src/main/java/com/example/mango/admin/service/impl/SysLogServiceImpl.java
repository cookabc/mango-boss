package com.example.mango.admin.service.impl;

import com.example.mango.admin.mapper.SysLogMapper;
import com.example.mango.admin.model.SysLog;
import com.example.mango.admin.service.SysLogService;
import com.example.mango.core.page.MybatisPageHelper;
import com.example.mango.core.page.PageRequest;
import com.example.mango.core.page.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xugang
 */
@Service
public class SysLogServiceImpl implements SysLogService {

    @Resource
    private SysLogMapper sysLogMapper;

    @Override
    public int save(SysLog record) {
        if (record.getId() == null || record.getId() == 0) {
            return sysLogMapper.insertSelective(record);
        }
        return sysLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(SysLog record) {
        return sysLogMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysLog> records) {
        for (SysLog record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public SysLog findById(Long id) {
        return sysLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Object label = pageRequest.getParam("userName");
        if (label != null) {
            return MybatisPageHelper.findPage(pageRequest, sysLogMapper, "findPageByUserName", label);
        }
        return MybatisPageHelper.findPage(pageRequest, sysLogMapper);
    }
}
