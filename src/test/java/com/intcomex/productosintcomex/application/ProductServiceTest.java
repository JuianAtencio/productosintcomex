package com.intcomex.productosintcomex.application;

import com.intcomex.productosintcomex.domain.Product;
import com.intcomex.productosintcomex.domain.ProductRepository;
import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    /**
     * Valido que el método findById devuelve el producto correcto cuando el repositorio lo encuentra
     */
    @Test
    void testFindById() {
        //creo un repositorio, un servicio y un producto mockeado
        ProductRepository repo = mock(ProductRepository.class);
        ProductService service = new ProductService(repo);
        Product product = new Product();
        product.setProductId(1);
        when(repo.findById(1)).thenReturn(Optional.of(product));

        Optional<Product> result = service.findById(1);
        //Valido las respuestas
        assertTrue(result.isPresent());
        assertEquals(1, result.get().getProductId());
    }
}