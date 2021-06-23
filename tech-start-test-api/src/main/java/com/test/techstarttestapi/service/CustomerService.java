package com.test.techstarttestapi.service;

import com.test.techstarttestapi.model.CustomerLocation;
import com.test.techstarttestapi.repository.CustomerLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements BaseService<CustomerLocation, String>{
    @Autowired
    CustomerLocationRepository repository;

    @Override
    public void save(CustomerLocation customerLocation) {
        repository.save(customerLocation);
    }

    @Override
    public List<CustomerLocation> getAll() {
        return repository.findAll();
    }

    @Override
    public CustomerLocation find(String name) {
        return repository.findCustomerLocationByName(name);
    }
}
