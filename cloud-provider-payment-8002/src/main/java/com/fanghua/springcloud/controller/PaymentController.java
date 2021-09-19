package com.fanghua.springcloud.controller;

import com.fanghua.springcloud.entities.CommonResult;
import com.fanghua.springcloud.entities.Payment;
import com.fanghua.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 支付控制器
 *
 * @author fcwei
 * @date 2021/9/16 - 11:28
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    /**
     * 获取端口号
     */
    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult creat(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入的数据为：" + payment);
        log.info("插入结果：" + result);

        if(result > 0){
            // 插入成功
            return new CommonResult(200, "插入数据库成功，serverPost：" + serverPort, result);
        }else{
            return new CommonResult(444, "插入数据库失败");
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果：" + payment);

        if(payment != null){
            // 查询成功
            return new CommonResult(200, "查询成功，serverPost：" + serverPort, payment);
        }else{
            return new CommonResult(444, "没有对应记录，查询ID：" + id);
        }
    }

}
