package com.example.mango.admin.service.impl;

import com.example.mango.admin.mapper.SysDictMapper;
import com.example.mango.admin.model.SysDict;
import com.example.mango.admin.service.SysDictService;
import com.example.mango.core.page.PageRequest;
import com.example.mango.core.page.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysDictServiceImpl implements SysDictService {

    @Resource
    SysDictMapper sysDictMapper;

    @Override
    public List<SysDict> findByLabel(String label) {
        return sysDictMapper.findByLabel(label);
    }

    @Override
    public int save(SysDict record) {
        return 0;
    }

    @Override
    public int delete(SysDict record) {
        return 0;
    }

    @Override
    public int delete(List<SysDict> entities) {
        return 0;
    }

    @Override
    public SysDict findById(Long id) {
        return null;
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return null;
    }
}
