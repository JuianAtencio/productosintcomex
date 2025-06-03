package com.intcomex.productosintcomex.adapters.mappers;

import com.intcomex.productosintcomex.adapters.dto.ProductDTO;
import com.intcomex.productosintcomex.domain.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductMapperTest {

    /**
     * Valido que el mapeador convierte correctamente entre ProductDTO y Product y viceversa.
     */
    @Test
    void testToDomainAndToDTO() {
        ProductDTO dto = new ProductDTO();
        dto.setProductName("Test");
        //convertimos a dominio
        Product domain = ProductMapper.toDomain(dto);
        assertEquals("Test", domain.getProductName());
        //convertimos de n uevo a DTO y valido que el nombre sea el mismo
        ProductDTO dto2 = ProductMapper.toDTO(domain);
        assertEquals("Test", dto2.getProductName());
    }
}
