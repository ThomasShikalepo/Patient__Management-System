package com.pm.patientservice.exception;

public class EmailAndPhoneNumberAlreadyExistsException extends RuntimeException {
    public EmailAndPhoneNumberAlreadyExistsException(String message) {
        super(message);
    }
}
