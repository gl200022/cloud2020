package com.glweb.cloud.mapper;

import com.glweb.cloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentMapper {
    public int insert(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
