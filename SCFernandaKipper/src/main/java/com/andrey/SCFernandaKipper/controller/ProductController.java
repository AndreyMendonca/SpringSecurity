package com.andrey.SCFernandaKipper.controller;

import com.andrey.SCFernandaKipper.domain.Product;
import com.andrey.SCFernandaKipper.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product save(@RequestBody Product product){
        return service.save(product);
    }

    @GetMapping
    public List<Product> findAll(){
        return service.findAll();
    }
}
