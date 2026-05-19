package com.lautaro.springboot.di.app.springboot_di.repositories;

import java.util.Collections;
import java.util.List;


import org.springframework.stereotype.Repository;

import com.lautaro.springboot.di.app.springboot_di.models.Product;

 //Le indicamos a Spring que esta clase es la implementacion principal del repositorio, es decir, la que se va a usar por defecto,
//  en caso de haber varias implementaciones, se puede usar @Qualifier para especificar cual usar

@Repository
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
