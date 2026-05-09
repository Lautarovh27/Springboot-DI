package com.lautaro.springboot.di.app.springboot_di.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.lautaro.springboot.di.app.springboot_di.models.Product;
import com.lautaro.springboot.di.app.springboot_di.services.ProductServiceImpl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api")
public class SomeController {

    private ProductServiceImpl service = new ProductServiceImpl();
    
    @GetMapping   
    public List<Product> list(){    
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Product show(@PathVariable Long id) {
        return service.findById(id);
    }
}
