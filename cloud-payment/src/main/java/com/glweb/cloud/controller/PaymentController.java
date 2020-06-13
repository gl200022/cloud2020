package com.glweb.cloud.controller;

import com.glweb.cloud.entities.CommonResult;
import com.glweb.cloud.entities.Payment;
import com.glweb.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment/insert")
    public CommonResult insert(Payment payment) {
        int result = paymentService.insert(payment);
        log.info("*******插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功", result);
        }else{
            return new CommonResult(404, "插入数据库失败", null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*******查询结果：" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功", payment);
        }else{
            return new CommonResult(404, "查询失败", null);
        }
    }
}
