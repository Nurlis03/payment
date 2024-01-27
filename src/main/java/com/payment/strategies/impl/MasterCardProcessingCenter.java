package com.payment.strategies.impl;

import com.payment.entity.Card;
import com.payment.strategies.PaymentProcessingStrategy;

import java.math.BigDecimal;

public class MasterCardProcessingCenter implements PaymentProcessingStrategy {

    @Override
    public void issueCard(Card card) {
        // TODO: algorithm issue card for Master card
    }

    @Override
    public void deposit(Card card, BigDecimal amount) {
        // TODO: algorithm deposit balance for Master card
    }

    @Override
    public void withdraw(Card card, BigDecimal amount) {
        // TODO: algorithm withdraw balance for Master card
    }
}
