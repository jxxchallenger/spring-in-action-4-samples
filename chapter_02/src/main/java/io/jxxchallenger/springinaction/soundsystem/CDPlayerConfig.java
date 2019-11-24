package io.jxxchallenger.springinaction.soundsystem;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
//@ComponentScan(basePackageClasses = {CompactDisc.class}) //Type Safe
public class CDPlayerConfig {

    //JavaConfig显式地装配bean
//    @Bean
//    public CompactDisc sgtPeppers() {
//        return new SgtPeppers();
//    }
//    
//    @Bean
//    public MediaPlayer cdPlayer(CompactDisc compactDisc) {
//        return new CDPlayer(compactDisc);
//    }
}
