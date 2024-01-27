package com.payment.entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "payment_system")
@Entity
@Data
public class PaymentSystem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;
}
