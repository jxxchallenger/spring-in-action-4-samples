package io.jxxchallenger.springinaction.spittr.web.controller;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class SpitterControllerTest extends AbstractSpittrTest {

    @Test
    public void shouldShowRegistration() throws Exception {
        this.getMockMvc().perform(MockMvcRequestBuilders.get("/spitter/register"))
            .andExpect(MockMvcResultMatchers.view().name("registerForm"));
    }
}
