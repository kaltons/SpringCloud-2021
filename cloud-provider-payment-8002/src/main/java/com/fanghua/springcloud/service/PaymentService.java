package com.fanghua.springcloud.service;

import com.fanghua.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * 支付服务接口
 *
 * @author fcwei
 * @date 2021/9/14 - 17:10
 */
public interface PaymentService {

    /**
     * 添加
     * @param payment
     * @return
     */
    int create(Payment payment);

    /**
     * 查
     * @param id
     * @return
     */
    Payment getPaymentById(@Param("id") Long id);

}
