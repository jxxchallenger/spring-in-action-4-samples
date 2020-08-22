package io.jxxchallenger.springinaction.spittr.service;

import javax.mail.MessagingException;

import org.springframework.core.io.InputStreamSource;

import io.jxxchallenger.springinaction.spittr.model.Spittle;

public interface SpitterEmailService {

    /**
     * 
     * @param to 接收者地址
     * @param spittle
     */
    void sendSimpleSpittleEmail(String to, Spittle spittle);
    
    void sendSpittleEmailWithAttachment(String to, Spittle spittle, InputStreamSource inputStreamSource) throws MessagingException;
    
    void sendSpittleEmailUseTemplate(String to, Spittle spittle, InputStreamSource inputStreamSource) throws MessagingException;
}
