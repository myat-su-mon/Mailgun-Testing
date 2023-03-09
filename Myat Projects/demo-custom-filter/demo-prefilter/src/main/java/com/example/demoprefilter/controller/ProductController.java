package com.example.demoprefilter.controller;

import com.example.demoprefilter.model.Product;
import com.example.demoprefilter.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/sell")
    public List<Product> sellProducts(){
        List<Product> products = new ArrayList<>();
        products.add(new Product("books", "john"));
        products.add(new Product("candy", "john"));
        products.add(new Product("chocolate", "julien"));
        return productService.sellProducts(products);
    }
}
