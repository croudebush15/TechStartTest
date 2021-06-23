package com.test.techstarttestapi.service;

import com.test.techstarttestapi.model.Product;
import com.test.techstarttestapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements BaseService<Product, Integer>{
    @Autowired
    ProductRepository repository;

    @Override
    public void save(Product product) {
        repository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }

    @Override
    public Product find(Integer productCode) {
        return repository.findProductByProductCode(productCode);
    }
}
