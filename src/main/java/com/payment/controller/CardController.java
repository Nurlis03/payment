package com.payment.controller;

import com.payment.entity.Card;
import com.payment.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/cards")
public class CardController {
    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }
    @PostMapping("/issue")
    public ResponseEntity<String> issueCard(@RequestBody Card card) {
        try {
            cardService.issueCard(card);
            return ResponseEntity.ok("Card issued successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to issue card");
        }
    }

    @PostMapping("/deposit/{cardNumber}")
    public ResponseEntity<String> deposit(@PathVariable String cardNumber, @RequestParam BigDecimal amount) {
        try {
            Card card = cardService.getCardByNumber(cardNumber);
            if (card == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Card not found");
            }
            cardService.deposit(card, amount);
            return ResponseEntity.ok("Deposit successful");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to process deposit");
        }
    }

    @PostMapping("/withdraw/{cardNumber}")
    public ResponseEntity<String> withdraw(@PathVariable String cardNumber, @RequestParam BigDecimal amount) {
        try {
            Card card = cardService.getCardByNumber(cardNumber);
            if (card == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Card not found");
            }
            cardService.withdraw(card, amount);
            return ResponseEntity.ok("Withdrawal successful");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to process withdrawal");
        }
    }
}
