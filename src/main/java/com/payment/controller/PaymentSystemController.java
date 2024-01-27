package com.payment.controller;

import com.payment.entity.PaymentSystem;
import com.payment.service.PaymentSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment-systems")
public class PaymentSystemController {
    private final PaymentSystemService paymentSystemService;

    @Autowired
    public PaymentSystemController(PaymentSystemService paymentSystemService) {
        this.paymentSystemService = paymentSystemService;
    }

    @PostMapping
    public ResponseEntity<PaymentSystem> createPaymentSystem(@RequestBody PaymentSystem paymentSystem) {
        PaymentSystem createdPaymentSystem = paymentSystemService.createPaymentSystem(paymentSystem);
        return new ResponseEntity<>(createdPaymentSystem, HttpStatus.CREATED);
    }
}
