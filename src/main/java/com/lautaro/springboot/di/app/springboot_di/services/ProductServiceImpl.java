package com.lautaro.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lautaro.springboot.di.app.springboot_di.models.Product;
import com.lautaro.springboot.di.app.springboot_di.repositories.ProductRepositoryImpl;


@Component
public class ProductServiceImpl implements ProductService {

    //Inyectamos el repositorio para poder usarlo en el servicio, nos provee el acceso a los datos
    @Autowired
    private ProductRepositoryImpl repository;
    
    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {
            Double priceTax = p.getPrice() * 1.25d;
            //Product newProduct = new Product(p.getId(), p.getName(), priceTax.longValue());
            Product newProduct = (Product) p.clone(); //clonamos el producto para no modificar el original
            newProduct.setPrice(priceTax.longValue());
            return newProduct;
        }).collect(Collectors.toList());
    }
    
    @Override
    public Product findById(Long id) {
        return repository.findById(id); 
    }
}
