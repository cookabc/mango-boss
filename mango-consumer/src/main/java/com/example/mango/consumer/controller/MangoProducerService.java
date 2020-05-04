package com.example.mango.consumer.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xugang
 */
@FeignClient(name = "mango-producer")
public interface MangoProducerService {

    /**
     * @return 返回接口字符
     */
    @RequestMapping("/hello")
    String hello();

}
