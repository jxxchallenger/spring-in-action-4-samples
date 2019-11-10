package io.jxxchallenger.springinaction.knight.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import io.jxxchallenger.springinaction.knight.BraveKnight;
import io.jxxchallenger.springinaction.knight.Knight;
import io.jxxchallenger.springinaction.knight.Quest;
import io.jxxchallenger.springinaction.knight.SlayDragonQuest;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"io.jxxchallenger.springinaction.knight"})
public class KnightConfig {

    @Bean
    public Knight knight(Quest quest) {
        return new BraveKnight(quest);
    }
    
    @Bean
    public Quest quest() {
        return new SlayDragonQuest(System.out);
    }
}
