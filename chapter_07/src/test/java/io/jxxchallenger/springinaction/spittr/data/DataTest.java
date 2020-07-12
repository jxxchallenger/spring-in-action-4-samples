package io.jxxchallenger.springinaction.spittr.data;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import io.jxxchallenger.springinaction.spittr.config.DataConfig;
import io.jxxchallenger.springinaction.spittr.model.Spittle;

@SpringJUnitConfig(classes = {DataConfig.class})
@ActiveProfiles(profiles = {"dev"})
public class DataTest {

    @Autowired
    private SpittleRepository spittleRepository;
    
    @BeforeEach
    public void setup() {
        Spittle spittle = new Spittle("hello world", LocalDateTime.now());
        this.spittleRepository.save(spittle);
    }
    
    @Test
    public void test() {
        List<Spittle> spittles = this.spittleRepository.findSpittles(1000000, 20);
        Assertions.assertNotNull(spittles);
        spittles.forEach(item -> {
            System.out.println("item :" + item.getMessage());
        });
    }
}
