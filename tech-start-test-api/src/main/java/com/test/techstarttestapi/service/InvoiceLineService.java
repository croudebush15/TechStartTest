package com.test.techstarttestapi.service;

import com.test.techstarttestapi.model.InvoiceLine;
import com.test.techstarttestapi.repository.InvoiceLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceLineService implements BaseService<InvoiceLine, String> {
    @Autowired
    InvoiceLineRepository repository;

    @Override
    public void save(InvoiceLine invoiceLine) {
        repository.save(invoiceLine);
    }

    @Override
    public List<InvoiceLine> getAll() {
        return repository.findAll();
    }

    @Override
    public InvoiceLine find(String s) {
        return null;
    }
}
