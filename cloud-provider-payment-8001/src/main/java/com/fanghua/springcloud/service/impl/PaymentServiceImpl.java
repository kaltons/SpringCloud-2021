package com.fanghua.springcloud.service.impl;

import com.fanghua.springcloud.dao.PaymentDao;
import com.fanghua.springcloud.entities.Payment;
import com.fanghua.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 支付服务实现
 *
 * @author fcwei
 * @date 2021/9/14 - 17:10
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }

}
