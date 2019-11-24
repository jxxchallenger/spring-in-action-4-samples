package io.jxxchallenger.springinaction.soundsystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(value = {CDPlayerConfig.class})
//@SpringJUnitConfig(locations = {"classpath:config/soundsystem.xml"})
public class CDPlayerTest {

    @Autowired
    private CompactDisc compactDisc;
    
    @Autowired
    private MediaPlayer mediaPlayer;
    
    @Test
    @Order(0)
    public void cdShouldNotBeNull() {
        Assertions.assertNotNull(compactDisc);
    }
    
    @Test
    @Order(1)
    public void play() {
        mediaPlayer.play();
    }
}
