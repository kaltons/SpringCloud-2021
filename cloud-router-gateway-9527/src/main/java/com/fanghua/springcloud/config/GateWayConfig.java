package com.fanghua.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 网关配置类
 *
 * @author fcwei
 * @date 2021/10/2 - 16:23
 */
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder)
    {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("path_route_fanghua",
                r -> r.path("/guonei")
                        .uri("https://news.baidu.com/guonei")).build();

        return routes.build();
    }
}
