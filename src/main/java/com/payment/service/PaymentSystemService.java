package com.payment.service;

import com.payment.dto.PaymentSystemRequestDTO;
import com.payment.entity.PaymentSystem;
import com.payment.repository.PaymentSystemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaymentSystemService {
    private PaymentSystemRepository paymentSystemRepository;

    public List<PaymentSystem> getAllPaymentSystems() {
        return paymentSystemRepository.findAll();
    }

    public PaymentSystem createPaymentSystem(PaymentSystemRequestDTO paymentSystemDTO) {
        PaymentSystem paymentSystem = PaymentSystem.builder()
                                     .name(paymentSystemDTO.getName())
                                     .build();
        return paymentSystemRepository.save(paymentSystem);
    }
}
