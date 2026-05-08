package com.lautaro.springboot.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import com.lautaro.springboot.di.app.springboot_di.models.Product;

public class ProductRepository {

    private List<Product> data;

    public ProductRepository() {
        this.data = Arrays.asList(
            new Product(1L, "Product 1", 100L),
            new Product(2L, "Product 2", 200L),
            new Product(3L, "Product 3", 300L)
        );        
    }

    public List<Product> findAll() {
        return data;
    }

    
}
