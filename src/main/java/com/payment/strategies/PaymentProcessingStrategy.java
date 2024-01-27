package com.payment.strategies;

import com.payment.entity.Card;

import java.math.BigDecimal;

public interface PaymentProcessingStrategy {
    void issueCard(Card card);
    void deposit(Card card, BigDecimal amount);
    void withdraw(Card card, BigDecimal amount);
}