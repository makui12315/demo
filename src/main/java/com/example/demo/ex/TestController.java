package com.example.demo.ex;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author makui
 * @created on  2022/3/17
 **/
@RestController
public class TestController {
    private final ProductService productService;

    public TestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/test")
    public String  print(){
        productService.print();
        return "success";
    }
}
