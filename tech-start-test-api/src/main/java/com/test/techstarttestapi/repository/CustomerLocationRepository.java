package com.test.techstarttestapi.repository;

import com.test.techstarttestapi.model.CustomerLocation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CustomerLocationRepository extends MongoRepository<CustomerLocation, String> {
    public CustomerLocation findCustomerLocationByName (String name);
}
