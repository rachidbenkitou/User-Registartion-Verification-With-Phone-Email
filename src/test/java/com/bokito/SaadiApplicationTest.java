package com.bokito;

import com.bokito.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SaadiApplicationTest {

    @Test
    void addTest() {
        RestTemplate client= new RestTemplate();
        Product pr= new Product();
        pr.setName("Test");
        pr.setDescription("Test Test");
        pr.setPrice(192.4);
        Product p= client.postForObject("http://localhost:8080/products/",pr, Product.class);
        assertNotNull(p);
    }

}
