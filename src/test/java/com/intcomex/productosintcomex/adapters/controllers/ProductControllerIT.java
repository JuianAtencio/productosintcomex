package com.intcomex.productosintcomex.adapters.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intcomex.productosintcomex.adapters.dto.ProductDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Valido que el endpoint de creación de productos funciona correctamente.
     * @throws Exception
     */
    @Test
    void testCreateProduct() throws Exception {
        ProductDTO dto = new ProductDTO();
        dto.setProductName("Producto IT");
        dto.setCategoryId(1);
        dto.setSupplierId(1);
        dto.setUnitPrice(100.0);

        mockMvc.perform(post("/Product/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk());
    }
}