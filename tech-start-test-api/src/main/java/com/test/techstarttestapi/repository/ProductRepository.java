package com.test.techstarttestapi.repository;

import com.test.techstarttestapi.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductRepository extends MongoRepository<Product, String> {
    public Product findProductByProductCode (Integer productCode);
}
