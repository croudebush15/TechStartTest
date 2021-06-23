package com.test.techstarttestapi.repository;

import com.test.techstarttestapi.model.DistributorLocation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DistributorLocationRepository extends MongoRepository<DistributorLocation, String> {
    public DistributorLocation findDistributorLocationByNameEquals (String Name);
}
