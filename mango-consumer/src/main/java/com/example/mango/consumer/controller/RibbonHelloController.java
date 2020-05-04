package com.example.mango.consumer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author xugang
 */
@RestController
public class RibbonHelloController {

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/ribbon/call")
    public String call() {
        // 调用服务, service-producer为注册的服务名称，LoadBalancerInterceptor会拦截调用并根据服务名找到对应的服务
        return restTemplate.getForObject("http://mango-producer/hello", String.class);
    }
}
