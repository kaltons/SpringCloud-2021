package com.fanghua.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Config客户端配置控制器
 *
 * @author fcwei
 * @date 2021/10/5 - 23:04
 */
@RefreshScope
@RestController
public class ConfigClientController
{
    @Value("${server.port}")
    private String serverPort;

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String configInfo()
    {
        return "serverPort: " + serverPort + "\t\n\n configInfo: " + configInfo;
    }
}
