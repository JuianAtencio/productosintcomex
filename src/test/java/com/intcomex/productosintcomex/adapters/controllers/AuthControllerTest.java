package com.intcomex.productosintcomex.adapters.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.intcomex.productosintcomex.security.JwtUtil;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mockStatic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AuthController.class)
@AutoConfigureMockMvc(addFilters = false) 
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JwtUtil jwtUtil;

    /**
     * Valido que el endpoint de autenticación retorne un token JWT al enviar las credenciales correctas.
     * @throws Exception
     */
    @Test
    void login_ReturnsToken() throws Exception {
        try (MockedStatic<JwtUtil> jwtUtilMockedStatic = mockStatic(JwtUtil.class)) {
            jwtUtilMockedStatic.when(() -> JwtUtil.generateToken(anyString()))
                .thenReturn("fake-jwt-token");

            mockMvc.perform(post("/auth/login")
                    .param("username", "prueba")
                    .param("password", "prueba"))
                    .andExpect(status().isOk())
                    .andExpect(content().string("fake-jwt-token"));
        }
    }
}
