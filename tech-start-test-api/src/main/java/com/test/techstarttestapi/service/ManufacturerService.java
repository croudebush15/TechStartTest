package com.test.techstarttestapi.service;

import com.test.techstarttestapi.model.Manufacturer;
import com.test.techstarttestapi.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerService implements BaseService<Manufacturer, String>{

    @Autowired
    ManufacturerRepository repository;

    @Override
    public void save(Manufacturer manufacturer) {
        repository.save(manufacturer);
    }

    @Override
    public List<Manufacturer> getAll() {
        return repository.findAll();
    }

    @Override
    public Manufacturer find(String name) {
        return repository.findManufacturerByName(name);
    }
}
