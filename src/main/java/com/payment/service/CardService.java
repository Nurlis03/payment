package com.payment.service;

import com.payment.entity.Card;
import com.payment.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    public void issueCard(Card card) {
        cardRepository.save(card);
    }

    public Card getCardByNumber(String cardNumber) {
        return cardRepository.findByCardNumber(cardNumber);
    }

    public void deposit(Card card, BigDecimal amount) {
        BigDecimal currentBalance = card.getBalance();
        card.setBalance(currentBalance.add(amount));
        cardRepository.save(card);
    }

    public void withdraw(Card card, BigDecimal amount) {
        // 1. Retrieve the current balance of the card
        BigDecimal currentBalance = card.getBalance();

        // 2. Check if the current balance is sufficient for the withdrawal
        if (currentBalance.compareTo(amount) >= 0) {
            // 3. If there are sufficient funds, update the balance by subtracting the withdrawal amount
            card.setBalance(currentBalance.subtract(amount));

            // 4. Save the updated card entity to the database using the card repository
            cardRepository.save(card);
        } else {
            // 5. If there are insufficient funds, throw an exception
            throw new IllegalArgumentException("Insufficient funds");
        }
    }
}
