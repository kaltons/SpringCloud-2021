package com.fanghua.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Config客户端配置控制器
 * RefreshScope 注解起动态刷新作用
 * @author fcwei
 * @date 2021/10/5 - 16:28
 */
@RefreshScope
@RestController
public class ConfigClientController
{
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo()
    {
        return configInfo;
    }
}
