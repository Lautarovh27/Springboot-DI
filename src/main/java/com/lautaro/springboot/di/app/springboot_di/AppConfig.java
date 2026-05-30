package com.lautaro.springboot.di.app.springboot_di;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import com.lautaro.springboot.di.app.springboot_di.repositories.ProductRepository;
import com.lautaro.springboot.di.app.springboot_di.repositories.ProductRepositoryJson;
import org.springframework.core.io.Resource;

@Configuration
@PropertySource("classpath:config.properties") //Le indicamos a Spring que cargue el archivo de propiedades, para poder usar las propiedades definidas en el archivo    

public class AppConfig {

    @Value("classpath:product.json")
    private Resource resource;
    @Bean("productJson")
    @Primary
    ProductRepository productRepositoryJson() {
        return new ProductRepositoryJson(resource);
    }
}
