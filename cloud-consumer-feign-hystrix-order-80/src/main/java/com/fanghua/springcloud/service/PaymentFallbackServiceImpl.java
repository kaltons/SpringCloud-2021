package com.fanghua.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * 统一适配Fallback方法
 *
 * @author fcwei
 * @date 2021/10/1 - 23:07
 */
@Component
public class PaymentFallbackServiceImpl implements PaymentHystrixService{

    @Override
    public String paymentInfoOk(Integer id) {
        return "PaymentFallbackService fall back-paymentInfoOk ,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfoTimeOut(Integer id) {
        return "PaymentFallbackService fall back-paymentInfoTimeOut ,o(╥﹏╥)o";
    }
}
