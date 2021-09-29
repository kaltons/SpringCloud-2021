package com.fanghua.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 配置类注入容器
 * <p>
 *   1、在这里配置我们自定义的LoadBalancer策略 如果有大佬想自己扩展算法 需要实现ReactorServiceInstanceLoadBalancer接口
 *   2、可以使用@LoadBalancerClient或@LoadBalancerClients
 *   3、注意这里的name属性 需要和eureka页面中的服务提供者名字一直 此时页面中是大写
 *    3.1、@LoadBalancerClient(name = "CLOUD-PAYMENT-SERVICE",configuration = CustomLoadBalancerConfiguration.class)
 *    3.2、@LoadBalancerClients(defaultConfiguration = {name = "CLOUD-PAYMENT-SERVICE", configuration = CustomLoadBalancerConfiguration.class})
 * </p>
 * @author fcwei
 * @date 2021/9/17 - 15:03
 */
@Configuration
@LoadBalancerClient(name = "CLOUD-PAYMENT-SERVICE",configuration = CustomLoadBalancerConfiguration.class)
public class ApplicationContextConfig {

    /**
     * 往容器中添加一个RestTemplate
     * 赋予RestTemplate负载均衡的能力
     * RestTemplate 提供了多种便捷访问远程http访问的方法
     * @return bean
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
