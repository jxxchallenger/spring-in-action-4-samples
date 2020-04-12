package io.jxxchallenger.springinaction.spittr.web.controller;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class SpitterControllerTest extends AbstractSpittrTest {

    @Test
    @Order(value = 0)
    public void shouldShowRegistration() throws Exception {
        this.getMockMvc().perform(MockMvcRequestBuilders.get("/spitter/register"))
            .andExpect(MockMvcResultMatchers.view().name("registerForm"));
    }
    
    @Test
    @Order(value = 1)
    public void shouldProcessRegistration() throws Exception {
        this.getMockMvc().perform(MockMvcRequestBuilders
                .patch("/spitter/register")
                .param("firstName", "Jack")
                .param("lastName", "Bauer")
                .param("username", "jbauer")
                .param("password", "123456")
                .param("email", "jxxchallenger@foxmail.com"))
        .andExpect(MockMvcResultMatchers.redirectedUrl("/spitter/jbauer"));
    }
}
