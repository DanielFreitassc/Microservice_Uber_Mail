package com.daniel.Microservice_Uber_Mail.core;

public interface EmailSenderUseCase {
    void sendEmail(String  to, String subject, String body);
}
