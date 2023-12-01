package com.daniel.Microservice_Uber_Mail.infra.ses;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import javax.print.attribute.standard.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.Microservice_Uber_Mail.adapters.EmailSenderGateway;

@Service
public class SesEmailSender implements EmailSenderGateway{

    private final AmazonSimpleEmailService amazonSimpleEmailService;
    
    @Autowired
    public SesEmailSender(AmazonSimpleEmailService amazonSimpleEmailService){
        this.amazonSimpleEmailService = amazonSimpleEmailService;
    }
    @Override
    public void sendEmail(String to, String subject, String body) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sendEmail'");

        sendEmailRequest request = new SendEmailRequest()
            .withSource("danielfreitassc@gmail.com")
            .withDestination(new Destination().whithToAddresses(to))
            .withMessage(new Message()
                .withSubject(new Content(subject))
                .withBody(new Body().withText(new Content(body)))
            );
        try {
           this.amazonSimpleEmailService.sendEmail(request); 
        } catch (AmazonServiceException exception) {
             throw new EmailServiceExcepetion("Failure while email", exception);
        }   
    }
    
}
