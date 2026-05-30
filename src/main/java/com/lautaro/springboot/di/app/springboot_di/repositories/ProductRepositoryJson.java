package com.lautaro.springboot.di.app.springboot_di.repositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;

import com.lautaro.springboot.di.app.springboot_di.models.Product;

import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;

public class ProductRepositoryJson implements ProductRepository {

    private List<Product> products;

    public ProductRepositoryJson() {
        ClassPathResource resource = new ClassPathResource("json/product.json");
        ObjectMapper mapper = new ObjectMapper();
        try {
            products = Arrays.asList(mapper.readValue(resource.getFile(), Product[].class));
        } catch (JacksonException e) {
            e.printStackTrace();
        } catch (IOException e) {            
            e.printStackTrace();
        }
    }


    @Override
    public List<Product> findAll() {
        return products;
    }
    @Override
    public Product findById(Long id) {
        return null;
    }
   
}
