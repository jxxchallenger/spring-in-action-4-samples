package io.jxxchallenger.springinaction.mail;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.mail.MessagingException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import io.jxxchallenger.springinaction.spittr.mail.config.MailConfig;
import io.jxxchallenger.springinaction.spittr.model.Spittle;
import io.jxxchallenger.springinaction.spittr.service.SpitterEmailService;

@SpringJUnitConfig(classes = {MailConfig.class})
public class EmailTest {

    @Autowired
    private JavaMailSender mailSender;
    
    @Autowired
    private SpitterEmailService spitterEmailService;
    
    @Test
    @Disabled
    public void testConnection() {
        SimpleMailMessage simpleMessage = new SimpleMailMessage();
        simpleMessage.setFrom("763615181@qq.com");
        simpleMessage.setTo("785693764@qq.com");
        simpleMessage.setSubject("Java Mail With Spring");
        simpleMessage.setText("Java Mail");
        mailSender.send(simpleMessage);
    }
    
    @Test
    @Disabled
    public void testSimpleMailSend() {
        Spittle spittle = new Spittle(100, UUID.randomUUID().toString(), LocalDateTime.now(), 100, 100);
        this.spitterEmailService.sendSimpleSpittleEmail("785693764@qq.com", spittle);
    }
    
    @Test
    @Disabled
    public void testMailSendWithAttachment() {
        Spittle spittle = new Spittle(100, UUID.randomUUID().toString(), LocalDateTime.now(), 100, 100);
        try {
            this.spitterEmailService.sendSpittleEmailWithAttachment("785693764@qq.com", spittle, new ClassPathResource("logback.xml"));
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Test
    public void testMailSendUseTemplate() {
        Spittle spittle = new Spittle(100, UUID.randomUUID().toString(), LocalDateTime.now(), 100, 100);
        
        try {
            this.spitterEmailService.sendSpittleEmailUseTemplate("785693764@qq.com", spittle, new ClassPathResource("logback.xml"));
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
