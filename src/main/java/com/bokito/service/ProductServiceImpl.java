package com.bokito.service;

import com.bokito.dao.ProductDAO;
import com.bokito.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private  ProductDAO productDAO;
    @Override
    public Product addProduct(Product p) {
        return productDAO.save(p);
    }

    @Override
    public List<Product> getProducts() {
        return productDAO.findAll();
    }
}
