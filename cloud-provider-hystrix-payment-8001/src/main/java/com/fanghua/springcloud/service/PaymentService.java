package com.fanghua.springcloud.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Hystrix支付业务类
 *
 * @author fcwei
 * @date 2021/9/30 - 15:22
 */
@Service
public class PaymentService {

    Logger logger = LoggerFactory.getLogger(PaymentService.class);

    public String paymentInfoOk(Integer id) {
        return "线程池:  "+Thread.currentThread().getName()+"  paymentInfo_OK,id:  "+id+"\t"+"O(∩_∩)O哈哈~";
    }


    public String paymentInfoTimeOut(Integer id) {

        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            logger.warn( "Interrupted!", e);
            e.printStackTrace();
        }
        return "线程池:  " + Thread.currentThread().getName() + " id:  " + id + "\t" + "O(∩_∩)O哈哈~" + "  耗时(秒): 3";
    }
}
