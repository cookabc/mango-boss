package com.example.mango.admin.service.impl;

import com.example.mango.admin.mapper.SysConfigMapper;
import com.example.mango.admin.model.SysConfig;
import com.example.mango.admin.service.SysConfigService;
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
public class SysConfigServiceImpl implements SysConfigService {

    @Resource
    private SysConfigMapper sysConfigMapper;

    @Override
    public int save(SysConfig record) {
        if (record.getId() == null || record.getId() == 0) {
            return sysConfigMapper.insertSelective(record);
        }
        return sysConfigMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(SysConfig record) {
        return sysConfigMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysConfig> records) {
        for (SysConfig record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public SysConfig findById(Long id) {
        return sysConfigMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Object label = pageRequest.getParam("label");
        if (label != null) {
            return MybatisPageHelper.findPage(pageRequest, sysConfigMapper, "findPageByLabel", label);
        }
        return MybatisPageHelper.findPage(pageRequest, sysConfigMapper);
    }

    @Override
    public List<SysConfig> findByLabel(String label) {
        return sysConfigMapper.findByLabel(label);
    }
}
