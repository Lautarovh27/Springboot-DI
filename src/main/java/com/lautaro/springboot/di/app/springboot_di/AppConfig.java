package com.lautaro.springboot.di.app.springboot_di;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config.properties") //Le indicamos a Spring que cargue el archivo de propiedades, para poder usar las propiedades definidas en el archivo    

public class AppConfig {

}
