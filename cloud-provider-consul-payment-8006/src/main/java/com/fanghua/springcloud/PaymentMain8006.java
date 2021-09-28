package com.fanghua.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 支付微服务主程序
 * EnableDiscoveryClient 用于向使用consul或者zookeeper作为注册中心时注册服务
 *
 * @author fcwei
 * @date 2021/9/27 - 14:54
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentMain8006 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8006.class, args);
    }
}
