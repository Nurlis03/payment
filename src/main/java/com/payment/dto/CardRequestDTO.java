package com.payment.dto;

import com.payment.entity.Client;
import com.payment.entity.PaymentSystem;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

@Data
public class CardRequestDTO {
    @NotBlank(message = "cardNumber must should not to be empty")
    @Pattern(regexp = "\\d+", message = "Card number must contain only digits")
    @Length(min = 16, max = 16)
    private String cardNumber;

    private Client clientId;

    private PaymentSystem paymentSystemId;

    @Digits(integer = 20, fraction = 38)
    private BigDecimal balance;
}
