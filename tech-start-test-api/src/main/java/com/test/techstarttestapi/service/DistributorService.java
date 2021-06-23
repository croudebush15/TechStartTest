package com.test.techstarttestapi.service;

import com.test.techstarttestapi.model.DistributorLocation;
import com.test.techstarttestapi.repository.DistributorLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DistributorService implements BaseService<DistributorLocation, String> {

    @Autowired
    DistributorLocationRepository repository;

    @Override
    public void save(DistributorLocation distributorLocation) {
        repository.save(distributorLocation);
    }

    @Override
    public List<DistributorLocation> getAll() {
        return repository.findAll();
    }

    @Override
    public DistributorLocation find(String Name) {
        return repository.findDistributorLocationByNameEquals(Name);
    }
}
