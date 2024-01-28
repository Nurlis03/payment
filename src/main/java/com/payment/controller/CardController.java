package com.payment.controller;

import com.payment.dto.CardRequestDTO;
import com.payment.entity.Card;
import com.payment.service.CardService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/cards")
public class CardController {

    private final CardService cardService;

    @GetMapping
    public List<Card> getCards() {
        return cardService.getCards();
    }
    @PostMapping("/issue")
    public ResponseEntity<String> issueCard(@RequestBody @Valid CardRequestDTO cardRequestDto) {
        return cardService.issueCard(cardRequestDto);
    }

    @PutMapping("/deposit/{cardId}")
    public ResponseEntity<String> deposit( @PathVariable Long cardId, @RequestParam BigDecimal amount) {
        return cardService.deposit(cardId, amount);
    }

    @PutMapping("/withdraw/{cardId}")
    public ResponseEntity<String> withdraw(@PathVariable Long cardId, @RequestParam BigDecimal amount) {
        return cardService.withdraw(cardId, amount);
    }
}
