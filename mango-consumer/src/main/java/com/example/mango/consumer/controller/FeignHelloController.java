package com.example.mango.consumer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xugang
 */
@RestController
public class FeignHelloController {

    @Resource
    private MangoProducerService mangoProducerService;

    @RequestMapping("/feign/call")
    public String call() {
        // 像调用本地服务一样
        return mangoProducerService.hello();
    }

}
