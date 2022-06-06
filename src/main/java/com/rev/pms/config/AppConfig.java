package com.rev.pms.config;

import com.rev.pms.model.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

//   @Scope(value = "prototype")
    @Bean
    public Product product() {
        return new Product();
    }

    // If @Component is not present for User class
    /*@Bean
    public User user(){
        return new User();
    }*/

/*
    @Bean
    public PasswordHashing getPasswordHashing(){
        return new PasswordHashing();
    }*/
}
