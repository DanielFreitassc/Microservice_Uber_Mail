package com.daniel.Microservice_Uber_Mail.application;

import org.springframework.beans.factory.annotation.Autowired;

import com.daniel.Microservice_Uber_Mail.core.EmailSenderUseCase;

@Service
public class EmailSenderService implements EmailSenderUseCase{
    private final EmailSenderGateway emailSenderGateway;

    @Autowired
    public EmailSenderService(EmailSenderGateway){
        this.emailSenderGateway = emailGateway;
    }
    @Override
    public void sendEmail(String to, String subject, String body) {
        this.emailSenderGateway.sendEmail(to, subject, body);

    
    }
    
}
