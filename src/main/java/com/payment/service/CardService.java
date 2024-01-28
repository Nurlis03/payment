package com.payment.service;

import com.payment.dto.CardRequestDTO;
import com.payment.entity.Card;
import com.payment.exception.CardNotFoundException;
import com.payment.exception.DuplicatePaymentSystemAndClientException;
import com.payment.exception.InsufficientFundsException;
import com.payment.repository.CardRepository;
import com.payment.strategies.PaymentProcessingStrategy;
import com.payment.strategies.context.PaymentProcessingContext;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class CardService {
    private final CardRepository cardRepository;
    public List<Card> getCards() {
        return cardRepository.findAll();
    }
    public ResponseEntity<String> issueCard(CardRequestDTO cardRequestDto) {
        try {
            Card card = Card.builder()
                    .cardNumber(cardRequestDto.getCardNumber())
                    .client(cardRequestDto.getClientId())
                    .paymentSystem(cardRequestDto.getPaymentSystemId())
                    .balance(cardRequestDto.getBalance()).build();
            cardRepository.save(card);

            return new ResponseEntity<>("Card saved successfully", HttpStatus.OK);
        } catch (DuplicatePaymentSystemAndClientException e) {
            throw new DuplicatePaymentSystemAndClientException("Error issuing card. The card number and client must be unique.");
        }
    }

    public Card getCardById(Long cardId) {
        return cardRepository.findById(cardId)
                .orElseThrow(() -> new CardNotFoundException("Card not found with ID: " + cardId));
    }

    public ResponseEntity<String> deposit(Long cardId, BigDecimal amount) {
        try {
            Card card = getCardById(cardId);
            BigDecimal currentBalance = card.getBalance();
            card.setBalance(currentBalance.add(amount));
            cardRepository.save(card);
            return new ResponseEntity<>("The balance has been replenished successfully", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> withdraw(Long cardId, BigDecimal amount) {

        Card card = getCardById(cardId);
        BigDecimal currentBalance = card.getBalance();

        if (currentBalance.compareTo(amount) >= 0) {
            card.setBalance(currentBalance.subtract(amount));
            cardRepository.save(card);
            return new ResponseEntity<>("Successful balance withdrawal", HttpStatus.OK);
        } else {
            throw new InsufficientFundsException("Insufficient funds");
        }
    }
}
