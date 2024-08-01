package com.yourcompany.notification_backend;

import com.yourcompany.notification_backend.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonnelChangeListener {

    @Autowired
    private EmailService emailService;

    @RabbitListener(queues = "personnel_changes")
    public void listen(String message) {
        // Mesajı parse edin ve email gönderin
        emailService.sendEmail("nisabasak678@gmail.com", "Personnel Change", message);
    }
}