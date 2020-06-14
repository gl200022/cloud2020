package com.glweb.cloud.controller;

import com.glweb.cloud.entities.CommonResult;
import com.glweb.cloud.entities.Payment;
import com.glweb.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/insert")
    public CommonResult insert(@RequestBody Payment payment) {
        int result = paymentService.insert(payment);
        log.info("*******插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功,serverPort:"+serverPort, result);
        }else{
            return new CommonResult(404, "插入数据库失败serverPort:"+serverPort, null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*******查询结果：" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功,serverPort"+serverPort, payment);
        }else{
            return new CommonResult(404, "查询失败serverPort:"+serverPort, null);
        }
    }
}
