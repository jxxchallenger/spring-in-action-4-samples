package io.jxxchallenger.springinaction.spittr.web.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import io.jxxchallenger.springinaction.spittr.config.RootConfig;
import io.jxxchallenger.springinaction.spittr.web.config.WebConfig;

@SpringJUnitWebConfig(classes = {WebConfig.class, RootConfig.class})
@ActiveProfiles(profiles = {"dev"})
public class HomeControllerTest {

    MockMvc mockMvc;
    
    @BeforeEach
    public void setup(WebApplicationContext wac) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
    
    @Test
    public void testHomePage() {
        try {
            this.mockMvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.ALL))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.view().name("home"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
