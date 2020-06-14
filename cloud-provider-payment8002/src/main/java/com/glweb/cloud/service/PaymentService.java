package com.glweb.cloud.service;

import com.glweb.cloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    public int insert(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
