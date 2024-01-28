package com.payment.controller;

import com.payment.dto.PaymentSystemRequestDTO;
import com.payment.entity.PaymentSystem;
import com.payment.service.PaymentSystemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/payment-systems")
public class PaymentSystemController {
    private final PaymentSystemService paymentSystemService;

    @GetMapping
    public List<PaymentSystem> getAllPaymentSystems() {
        return paymentSystemService.getAllPaymentSystems();
    }
    @PostMapping
    public ResponseEntity<PaymentSystem> createPaymentSystem(
            @RequestBody PaymentSystemRequestDTO paymentSystemDTO) {
        PaymentSystem createdPaymentSystem = paymentSystemService.createPaymentSystem(paymentSystemDTO);
        return new ResponseEntity<>(createdPaymentSystem, HttpStatus.CREATED);
    }
}
