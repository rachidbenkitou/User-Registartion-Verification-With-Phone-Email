package com.bokito.service;

import com.bokito.model.Product;

import java.util.List;

public interface ProductService {
    public Product addProduct(Product p);
    public List<Product> getProducts();
}
