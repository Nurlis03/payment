package com.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.payment.entity.PaymentSystem;
public interface PaymentSystemRepository extends JpaRepository<PaymentSystem, Long> {

}