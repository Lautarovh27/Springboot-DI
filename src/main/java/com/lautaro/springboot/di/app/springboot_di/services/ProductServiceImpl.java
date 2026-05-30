package com.lautaro.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import com.lautaro.springboot.di.app.springboot_di.models.Product;
import com.lautaro.springboot.di.app.springboot_di.repositories.ProductRepository;



@Service //Le indicamos a Spring que esta clase es un servicio, es decir, una clase encargada de contener la logica de negocio
public class ProductServiceImpl implements ProductService {

    
    
    //Inyectamos el repositorio para poder usarlo en el servicio, nos provee el acceso a los datos
    private ProductRepository repository;
    @Value("${config.price.tax}") //Le indicamos a Spring que inyecte el valor de la propiedad config.price.tax, definida en el archivo de propiedades, en esta variable
    private Double tax;


    public ProductServiceImpl(@Qualifier("productJson") ProductRepository repository, Environment environment) {
        this.repository = repository;
        
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {
            
            Double priceTax = p.getPrice() * tax;
            //Product newProduct = new Product(p.getId(), p.getName(), priceTax.longValue());
            Product newProduct = (Product) p.clone(); //clonamos el producto para no modificar el original
            newProduct.setPrice(priceTax.longValue());
            return newProduct;
            //p.setPrice(priceTax.longValue());
            //return p;
        }).collect(Collectors.toList());
    }
    
    @Override
    public Product findById(Long id) {
        return repository.findById(id); 
    }

}
