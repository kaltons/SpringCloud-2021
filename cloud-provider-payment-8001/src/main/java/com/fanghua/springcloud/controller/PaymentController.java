package com.fanghua.springcloud.controller;

import com.fanghua.springcloud.entities.CommonResult;
import com.fanghua.springcloud.entities.Payment;
import com.fanghua.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
     * 服务发现
     */
    @Resource
    private DiscoveryClient discoveryClient;

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

    @GetMapping("/payment/discovery")
    public Object discovery(){
        // 获取服务列表的信息
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("Element：" + element);
        }

        // 获取CLOUD-PAYMENT-SERVICE服务的所有具体实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            // getServiceId服务器id getHost主机名称 getPort端口号  getUri地址
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }

        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout()
    {
        // 业务逻辑处理正确，但是需要耗费3秒钟
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

}
