package io.jxxchallenger.springinaction.spittr.config;

import java.nio.charset.StandardCharsets;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
@Import(value = {DataConfig.class})
public class RootConfig {

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding(StandardCharsets.UTF_8.displayName());
        return messageSource;
    }
    
//    @Bean
//    public MessageSource messageSource() {
//        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//        messageSource.setBasename("file:///xxx/messages");
//        messageSource.setDefaultEncoding(StandardCharsets.UTF_8.displayName());
//        messageSource.setCacheSeconds(10);
//        return messageSource;
//    }
}
