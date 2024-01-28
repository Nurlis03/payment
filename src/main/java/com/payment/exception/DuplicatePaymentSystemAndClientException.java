package com.payment.exception;

import java.sql.SQLException;

public class DuplicatePaymentSystemAndClientException extends RuntimeException {
    public DuplicatePaymentSystemAndClientException(String message) {
        super(message);
    }
}
