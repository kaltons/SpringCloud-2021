package com.fanghua.springcloud.dao;

import com.fanghua.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 持久层接口
 *
 * @author fcwei
 * @date 2021/9/14 - 17:33
 */
@Mapper
public interface PaymentDao {

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
