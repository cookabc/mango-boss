package com.example.mango.admin.controller;

import com.example.mango.admin.model.SysDict;
import com.example.mango.admin.service.SysDictService;
import com.example.mango.core.http.HttpResult;
import com.example.mango.core.page.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("dict")
public class SysDictController {

    @Resource
    private SysDictService sysDictService;

    @PostMapping(value = "/save")
    public HttpResult save(@RequestBody SysDict record) {
        return HttpResult.ok(sysDictService.save(record));
    }

    @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody List<SysDict> records) {
        return HttpResult.ok(sysDictService.delete(records));
    }

    @GetMapping(value = "/findByLabel")
    public HttpResult findAll(@RequestParam String label) {
        return HttpResult.ok(sysDictService.findByLabel(label));
    }

    @PostMapping(value = "/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysDictService.findPage(pageRequest));
    }
}
