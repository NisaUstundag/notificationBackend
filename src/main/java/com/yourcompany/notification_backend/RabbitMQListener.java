package com.yourcompany.notification_backend;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQListener {

    @Autowired
    private EmailService emailService;

    @RabbitListener(queues = "personelQueue")
    public void listen(String message) {
        // Mesajı parse etme işlemi (JSON parse, vs.)
        String to = "nisabasak678@gmail.com"; // Alıcının email adresi
        String subject = "Personnel Changes"; // E-posta konusu
        String body = "Personel değişiklikleri ile ilgili bilgilendirme maildir aynı zamanda demo bir maildir bilginize"+ message; // Mesajın gövdesi

        emailService.mailSender(to, subject, body);
    }
}
