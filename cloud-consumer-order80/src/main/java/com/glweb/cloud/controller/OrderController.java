package com.glweb.cloud.controller;

import com.glweb.cloud.entities.CommonResult;
import com.glweb.cloud.entities.Payment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {
    @Resource
    private RestTemplate restTemplate;

    //单机访问路径
    //private static final String PAYMENT_URL = "http://localhost:8001";

    //集群访问路径，通过服务名访问,对于eureka中Application
    private static final String PAYMENT_URL = "http://PAYMENT-SERVICE";

    @GetMapping("/consumer/payment/insert")
    public CommonResult insert(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/insert", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }
}
