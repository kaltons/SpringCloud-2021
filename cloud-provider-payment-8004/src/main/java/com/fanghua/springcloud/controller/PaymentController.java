package com.fanghua.springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * 支付控制器
 *
 * @author fcwei
 * @date 2021/9/16 - 11:28
 */
@RestController
@Slf4j
public class PaymentController
{

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/zk")
    public String paymentZk()
    {
        return "SpringCloud with zookeeper: "+serverPort+"\t"+ UUID.randomUUID();
    }
}

