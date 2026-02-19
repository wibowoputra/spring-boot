package com.example.hello;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculatorIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldAddNumbersEndToEnd() throws Exception {
        mockMvc.perform(get("/api/calculator/add")
                .param("a", "10")
                .param("b", "20"))
                .andExpect(status().isOk())
                .andExpect(content().string("30"));
    }
}
