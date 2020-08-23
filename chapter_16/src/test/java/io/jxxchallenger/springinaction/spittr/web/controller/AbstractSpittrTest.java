package io.jxxchallenger.springinaction.spittr.web.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import io.jxxchallenger.springinaction.spittr.config.RootConfig;
import io.jxxchallenger.springinaction.spittr.web.config.WebConfig;

@SpringJUnitWebConfig(classes = {RootConfig.class, WebConfig.class})
@TestMethodOrder(value = OrderAnnotation.class)
@ActiveProfiles(value = {"dev"})
public abstract class AbstractSpittrTest {

    private MockMvc mockMvc;

    protected MockMvc getMockMvc() {
        return this.mockMvc;
    }
    
    @BeforeEach
    public void setup(WebApplicationContext wac) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
}
