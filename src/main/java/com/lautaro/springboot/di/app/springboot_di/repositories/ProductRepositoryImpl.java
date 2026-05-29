package com.lautaro.springboot.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
//import org.springframework.web.context.annotation.RequestScope;
//import org.springframework.web.context.annotation.SessionScope;


import com.lautaro.springboot.di.app.springboot_di.models.Product;

 //Le indicamos a Spring que esta clase es la implementacion principal del repositorio, es decir, la que se va a usar por defecto,
//  en caso de haber varias implementaciones, se puede usar @Qualifier para especificar cual usar
@Primary
//@SessionScope//Le indicamos a Spring que esta clase tiene un alcance de sesion, es decir, que se va a crear una instancia por cada sesion de usuario
@Repository("productList") //Le indicamos a Spring que esta clase es un repositorio, es decir, una clase encargada de acceder a los datos
public class ProductRepositoryImpl implements ProductRepository {

    private List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
            new Product(1L, "Product 1", 100L),
            new Product(2L, "Product 2", 200L),
            new Product(3L, "Product 3", 300L)
        );        
    }

    @Override
    public List<Product> findAll() {
        return data;
    }

    @Override
    public Product findById(Long id) {
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
     
    }
}
