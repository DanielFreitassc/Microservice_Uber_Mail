package com.daniel.Microservice_Uber_Mail.adapters;

public interface EmailSenderGateway {
    void sendEmail(String to, String subject, String body);   
}
