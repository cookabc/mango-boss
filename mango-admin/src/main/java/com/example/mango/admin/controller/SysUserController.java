package com.example.mango.admin.controller;

import com.example.mango.admin.model.SysUser;
import com.example.mango.admin.service.SysUserService;
import com.example.mango.common.utils.FileUtils;
import com.example.mango.core.http.HttpResult;
import com.example.mango.core.page.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

@RestController
@RequestMapping("user")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    @GetMapping(value = "/findAll")
    public List<SysUser> findAll() {
        return sysUserService.findAll();
    }

    @PostMapping(value = "/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysUserService.findPage(pageRequest));
    }

    @PostMapping(value = "/exportExcelUser")
    public void exportExcelUser(@RequestBody PageRequest pageRequest, HttpServletResponse response) {
        File file = sysUserService.createUserExcelFile(pageRequest);
        FileUtils.downloadFile(response, file, file.getName());
    }
}
