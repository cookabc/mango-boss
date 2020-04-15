package com.example.mango.admin.controller;

import com.example.mango.admin.model.SysDept;
import com.example.mango.admin.service.SysDeptService;
import com.example.mango.core.http.HttpResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xugang
 */
@RestController
@RequestMapping(value = "dept")
public class SysDeptController {

    @Resource
    private SysDeptService sysDeptService;

    @PostMapping(value = "/save")
    public HttpResult save(@RequestBody SysDept record) {
        return HttpResult.ok(sysDeptService.save(record));
    }

    @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody List<SysDept> records) {
        return HttpResult.ok(sysDeptService.delete(records));
    }

    @GetMapping(value = "/findTree")
    public HttpResult findTree() {
        return HttpResult.ok(sysDeptService.findTree());
    }
}
