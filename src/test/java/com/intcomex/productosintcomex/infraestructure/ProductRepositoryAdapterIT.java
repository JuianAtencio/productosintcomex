package com.intcomex.productosintcomex.infraestructure;

import com.intcomex.productosintcomex.domain.Product;
import com.intcomex.productosintcomex.infrastructure.ProductRepositoryAdapter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryAdapterIT {

    @Autowired
    private ProductRepositoryAdapter adapter;

    /** 
     * Valido que el método save y findById funcionan correctamente.
     * Se crea un producto, se guarda y luego se busca por ID.
     */
    @Test
    void testSaveAndFind() {
        Product product = new Product();
        product.setProductName("Repo IT");
        product.setCategoryId(1);
        product.setSupplierId(1);
        product.setUnitPrice(50.0);

        Product saved = adapter.save(product);
        assertNotNull(saved.getProductId());

        assertTrue(adapter.findById(saved.getProductId()).isPresent());
    }
}
