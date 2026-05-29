package com.lautaro.springboot.di.app.springboot_di.repositories;

import java.util.Collections;
import java.util.List;


import org.springframework.stereotype.Repository;

import com.lautaro.springboot.di.app.springboot_di.models.Product;


@Repository("productFoo") //Le indicamos a Spring que esta clase es un repositorio, es decir, una clase encargada de acceder a los datos
public class ProductRepositoryFoo implements ProductRepository{

    @Override
    public List<Product> findAll(){
        return Collections.singletonList(new Product(1L, "Product Foo1", 1002L));
    }    

    @Override
    public Product findById(Long id) {
        return new Product(id, "Product Foo2", 100L);
    }
}   
