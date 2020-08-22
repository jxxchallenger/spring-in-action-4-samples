package io.jxxchallenger.springinaction.spittr.mail.config;

import java.nio.charset.StandardCharsets;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.thymeleaf.spring5.ISpringTemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

import io.jxxchallenger.springinaction.spittr.service.SpitterEmailService;

@Configuration
@PropertySource(encoding = "UTF-8", value = {"classpath:mail.properties"})
@ComponentScan(basePackageClasses = {SpitterEmailService.class})
public class MailConfig {

    @Bean
    public JavaMailSender mailSender(@Value(value = "${mail.host}") String host, @Value(value = "${mail.port}") int port, @Value(value = "${mail.username}") String username, @Value(value = "${mail.password}") String password) {
        Properties javaMailProperties = new Properties();
        javaMailProperties.setProperty("mail.smtp.ssl.enable", "true");
        javaMailProperties.setProperty("mail.smtp.auth", "true");
        javaMailProperties.setProperty("mail.smtp.timeout", "2000");
        javaMailProperties.setProperty("mail.smtp.defaultEncoding", "UTF-8");
        
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setDefaultEncoding(StandardCharsets.UTF_8.displayName());
        mailSender.setHost(host);
        mailSender.setPort(port);
        mailSender.setUsername(username);
        mailSender.setPassword(password);
        mailSender.setJavaMailProperties(javaMailProperties);
        
        return mailSender;
    }
    
    @Bean
    public ITemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setCacheable(false);
        templateResolver.setCharacterEncoding(StandardCharsets.UTF_8.displayName());
        templateResolver.setPrefix("/mail/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        
        return templateResolver;
    }
    
    @Bean
    public ISpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        templateEngine.setEnableSpringELCompiler(true);
        //templateEngine.addDialect(new SpringSecurityDialect());
        return templateEngine;
    }
}
