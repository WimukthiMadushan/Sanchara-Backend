package com.emailservice.emailservice.Controllers;

import com.emailservice.emailservice.Service.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/email")
public class EmailController {

    private final SendEmail sendEmail;

    @Autowired
    public EmailController(SendEmail sendEmail) {
        this.sendEmail = sendEmail;
    }


    @GetMapping("/send")
    public String sendEmail() {
        sendEmail.sendEmail("sancharaevents@gmail.com", "Test Email", "This is a test email");
        return "Email sent successfully";
    }
}
