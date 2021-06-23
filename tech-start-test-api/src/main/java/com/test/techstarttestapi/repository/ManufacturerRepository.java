package com.test.techstarttestapi.repository;

import com.test.techstarttestapi.model.Manufacturer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ManufacturerRepository extends MongoRepository<Manufacturer, String> {
    public Manufacturer findManufacturerByName (String name);
}
