package com.emailservice.emailservice.Service;

import com.emailservice.emailservice.Event.AddEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService {
    @Autowired
    private JavaMailSender javaMailSender;

    @KafkaListener(topics = "Add-Event")
    public void listen(AddEvent addEvent){
        log.info("Got Message from order-placed topic {}", addEvent);
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("sancharaevents@gmail.com");
            messageHelper.setTo(addEvent.getEmail().toString());
            messageHelper.setSubject(String.format("Your Event Added successfully", addEvent.getEventName() ));
            messageHelper.setText(String.format("""
                    Dear %s,

                    Your order with OrderNumber %s is placed successfully.
                    Thank you for shopping with us!

                    Best regards,
                    Sanchara Shop Team
                    """, addEvent.getEmail()));
        };
        try {
            javaMailSender.send(messagePreparator);
            log.info("Add Event email sent!!");
        } catch (MailException e) {
            log.error("Exception occurred when sending mail", e);
            throw new RuntimeException("Exception occurred when sending mail to sancharaevents@gmail.com", e);
        }
    }
}
