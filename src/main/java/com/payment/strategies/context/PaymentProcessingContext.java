package com.payment.strategies.context;

import com.payment.entity.Card;
import com.payment.strategies.PaymentProcessingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PaymentProcessingContext {
    private final Map<String, PaymentProcessingStrategy> strategyMap;

    @Autowired
    public PaymentProcessingContext(Map<String, PaymentProcessingStrategy> strategyMap) {
        this.strategyMap = strategyMap;
    }

    public PaymentProcessingStrategy getStrategy(Card card) {
        return strategyMap.get(card.getPaymentSystem().getName());
    }
}

