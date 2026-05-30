package com.lautaro.springboot.di.app.springboot_di.repositories;
import org.springframework.core.io.Resource;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;



import com.lautaro.springboot.di.app.springboot_di.models.Product;
import tools.jackson.databind.ObjectMapper;

public class ProductRepositoryJson implements ProductRepository {

    private List<Product> list;

    

    public ProductRepositoryJson(Resource resource) {
        
        ObjectMapper mapper = new ObjectMapper();
        try {
            list = Arrays.asList(mapper.readValue(resource.getFile(), Product[].class));
        } catch (IOException e) {            
            e.printStackTrace();
        }
    }


    @Override
    public List<Product> findAll() {
        return list;
    }
    @Override
    public Product findById(Long id) {
        return list.stream().filter(p -> {
            return p.getId().equals(id);
        }).findFirst().orElse(null);
    }
   
}
