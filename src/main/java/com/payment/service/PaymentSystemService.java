package com.payment.service;

import com.payment.entity.PaymentSystem;
import com.payment.repository.PaymentSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentSystemService {
    @Autowired
    private PaymentSystemRepository paymentSystemRepository;

    public PaymentSystem createPaymentSystem(PaymentSystem paymentSystem) {
        if (paymentSystem.getName() == null) {
            throw new IllegalArgumentException("PaymentSystem name cannot be null");
        }
        return paymentSystemRepository.save(paymentSystem);
    }
}
