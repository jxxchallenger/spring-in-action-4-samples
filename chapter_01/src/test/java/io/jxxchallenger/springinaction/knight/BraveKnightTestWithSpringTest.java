package io.jxxchallenger.springinaction.knight;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import io.jxxchallenger.springinaction.knight.config.KnightConfig;

//@SpringJUnitConfig(locations = {"classpath:META-INF/spring/knights.xml"}) //XML
@SpringJUnitConfig(classes = {KnightConfig.class}) //Java Config
public class BraveKnightTestWithSpringTest {

    @Autowired
    private Knight knight;  
    
    @Test
    public void test() {
        this.knight.embarkOnQuest();
    }
}
