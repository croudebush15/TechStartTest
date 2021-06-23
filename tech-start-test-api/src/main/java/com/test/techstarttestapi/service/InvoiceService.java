package com.test.techstarttestapi.service;

import com.test.techstarttestapi.model.CustomerLocation;
import com.test.techstarttestapi.model.Invoice;
import com.test.techstarttestapi.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService implements BaseService<Invoice, Integer> {

    @Autowired
    InvoiceRepository repository;

    @Override
    public void save(Invoice invoice) {
        repository.save(invoice);
    }

    @Override
    public List<Invoice> getAll() {
        return repository.findAll();
    }

    public void removeAll(){
        repository.deleteAll();
    }

    @Override
    public Invoice find(Integer invoiceNumber) {
        return repository.findInvoiceByInvoiceNumber(invoiceNumber);
    }
}
