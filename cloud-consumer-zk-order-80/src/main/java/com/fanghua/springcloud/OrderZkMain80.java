package com.fanghua.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 消费者订单主程序
 * EnableDiscoveryClient 用于向使用consul或者zookeeper作为注册中心时注册服务
 *
 * @author fcwei
 * @date 2021/9/27 - 14:54
 */
@EnableDiscoveryClient
@SpringBootApplication
public class OrderZkMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderZkMain80.class, args);
    }
}
