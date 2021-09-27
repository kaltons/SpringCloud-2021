package com.fanghua.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 订单消费业务控制器
 *
 * @author fcwei
 * @date 2021/9/27 - 16:00
 */
@Slf4j
@RestController
public class OrderZkController {
    public static final String INVOKE_URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/zk")
    public String paymentInfo()
    {
        return restTemplate.getForObject(INVOKE_URL+"/payment/zk",String.class);
    }
}
