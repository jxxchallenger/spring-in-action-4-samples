package io.jxxchallenger.springinaction.spittr.web.controller;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class SpittleControllerTest extends AbstractSpittrTest {

    @Test
    public void shouldShowRecentSpittles() throws Exception {
        this.getMockMvc().perform(MockMvcRequestBuilders.get("/spittles").param("max", "10").param("count", "5"))
                .andExpect(MockMvcResultMatchers.view().name("spittles"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("spittleList"));
    }
    
    @Test
    public void testSpittle() throws Exception {
        this.getMockMvc().perform(MockMvcRequestBuilders.get("/spittles/1"))
            .andExpect(MockMvcResultMatchers.view().name("spittle"))
            .andExpect(MockMvcResultMatchers.model().attributeExists("spittle"));
    }
}
