package org.itstep.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MailSenderService {

    @Value("${spring.mail.username}")
    private String from;

    private final JavaMailSender mailSender;

    public MailSenderService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void send(String emailTo, String subject, String message) {
        SimpleMailMessage msg = createMessage(emailTo, subject, message);
        mailSender.send(msg);
    }

    public void sendAll(String[] emails, String subject, String message) {
        Arrays.stream(emails).forEach(email -> send(email, subject, message));
    }


    private SimpleMailMessage createMessage(String emailTo, String subject, String message) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(from);
        msg.setTo(emailTo);
        msg.setSubject(subject);
        msg.setText(message);

        return msg;
    }
}
