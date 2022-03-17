package com.example.demo.ex;

import com.example.demo.ex.support.ProductApi;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @author makui
 * @created on  2022/3/17
 **/
@Service
public class ProductService {
    private final ProductApi productApi;

    public ProductService(ProductApi productApi) {
        this.productApi = productApi;
    }

    public void print() {
        productApi.print();
    }
}
