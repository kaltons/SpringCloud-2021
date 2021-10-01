package com.fanghua.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Hystrix-Feign业务接口
 *
 * @author fcwei
 * @date 2021/9/30 - 18:08
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentFallbackServiceImpl.class)
public interface PaymentHystrixService {

    /**
     * Openfeign组件调用Hystrix8001支付服务
     * @param id id
     * @return 结果
     */
    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentInfoOk(@PathVariable("id") Integer id);

    /**
     * Openfeign组件调用Hystrix8001超时服务
     * @param id id
     * @return 结果
     */
    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentInfoTimeOut(@PathVariable("id") Integer id);
}
