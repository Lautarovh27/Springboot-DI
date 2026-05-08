package com.lautaro.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import com.lautaro.springboot.di.app.springboot_di.models.Product;
import com.lautaro.springboot.di.app.springboot_di.repositories.ProductRepository;

public class ProductService {

    //acceso a datos
    private ProductRepository repository = new ProductRepository();
    
    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {
            Double priceTax = p.getPrice() * 1.25d;
            p.setPrice(priceTax.longValue());
            return p;
        }).collect(Collectors.toList());
    }

    public Product findById(Long id) {
        return repository.findById(id);
    }
}
