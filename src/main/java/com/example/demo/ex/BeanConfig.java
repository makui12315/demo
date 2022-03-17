package com.example.demo.ex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author makui
 * @created on  2022/3/17
 **/
@Configuration
public class BeanConfig {
    @Bean
    public BeanRegister beanRegisTest(){
        return new BeanRegister();
    }
}
