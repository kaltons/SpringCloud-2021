package com.fanghua.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 配置类注入容器
 *
 * @author fcwei
 * @date 2021/9/27 - 15:57
 */
@Configuration
public class ApplicationContextConfig {

    /**
     * 往容器中添加一个RestTemplate
     * 赋予RestTemplate负载均衡的能力
     * RestTemplate 提供了多种便捷访问远程http访问的方法
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}