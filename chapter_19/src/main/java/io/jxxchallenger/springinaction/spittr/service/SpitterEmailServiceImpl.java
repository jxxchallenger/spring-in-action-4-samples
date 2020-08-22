package io.jxxchallenger.springinaction.spittr.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.ISpringTemplateEngine;

import io.jxxchallenger.springinaction.spittr.model.Spittle;

@Service
public class SpitterEmailServiceImpl implements SpitterEmailService {

    @Autowired
    private JavaMailSender javaMailSender;
    
    @Autowired
    private ISpringTemplateEngine templateEngine;

    @Override
    public void sendSimpleSpittleEmail(String to, Spittle spittle) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("763615181@qq.com");
        mailMessage.setTo(to);
        mailMessage.setSubject("New spittle from " + spittle.getMessage());
        mailMessage.setCc("jxxchallenger@foxmail.com");
        mailMessage.setText(spittle.getMessage());
        javaMailSender.send(mailMessage);
        
    }

    @Override
    public void sendSpittleEmailWithAttachment(String to, Spittle spittle, InputStreamSource inputStreamSource) throws MessagingException {
        MimeMessage message = this.javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom("763615181@qq.com");
        helper.setTo(to);
        helper.setSubject(spittle.getMessage());
        helper.setText(spittle.getMessage());
        helper.addAttachment("abc.xml", inputStreamSource);
        
        this.javaMailSender.send(message);
        
    }

    @Override
    public void sendSpittleEmailUseTemplate(String to, Spittle spittle, InputStreamSource inputStreamSource) throws MessagingException {
        MimeMessage message = this.javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom("763615181@qq.com");
        helper.setTo(to);
        helper.setSubject(spittle.getMessage());
        
        Context context = new Context();
        context.setVariable("spitterName", "jxxchallenger");
        context.setVariable("spittleText", spittle.getMessage());
        String emailText = this.templateEngine.process("spittleMailTemplate", context);
        
        helper.setText(emailText, true);
        helper.addAttachment("abc.xml", inputStreamSource);
        
        this.javaMailSender.send(message);
        
    }

}
