package com.andrey.SCFernandaKipper.service;

import com.andrey.SCFernandaKipper.domain.Product;
import com.andrey.SCFernandaKipper.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    @Transactional
    public Product save(Product product){
        return repository.save(product);
    }

    public List<Product> findAll(){
        return repository.findAll();
    }
}
