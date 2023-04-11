package com.bokito.controller;

import com.bokito.exception.ProductException;
import com.bokito.model.Product;
import com.bokito.service.ProductService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;
    //@Value("${dbServerUrl}")
    //private String dbServerUrl;
    public static Logger LOGGER= LoggerFactory.getLogger(ProductController.class);
    @PostMapping
    public Product addProduct(@RequestBody Product p){
        if(p.getName()==null) throw  new ProductException("You forgot to specify the product name.");
        return productService.addProduct(p);
    }
    @GetMapping
    public List<Product> getProducts(){
        return productService.getProducts();
    }
}
