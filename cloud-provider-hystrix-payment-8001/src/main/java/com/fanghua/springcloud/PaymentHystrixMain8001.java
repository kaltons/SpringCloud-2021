package com.fanghua.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hystrix支付主启动程序
 * EnableCircuitBreaker 激活Hystrix注解
 * @author fcwei
 * @date 2021/9/30 - 15:19
 */
@EnableEurekaClient
@SpringBootApplication
@EnableCircuitBreaker
public class PaymentHystrixMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8001.class, args);
    }
}
