package com.intcomex.productosintcomex.adapters.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AuthController.class)
@AutoConfigureMockMvc(addFilters = false) 
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void login_ReturnsToken() throws Exception {
        mockMvc.perform(post("/auth/login")
                .param("username", "prueba")
                .param("password", "prueba"))
                .andExpect(status().isOk())
                .andExpect(content().string(notNullValue()));
    }
}
