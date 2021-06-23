package com.test.techstarttestapi.repository;

import com.test.techstarttestapi.model.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface InvoiceRepository extends MongoRepository<Invoice, String> {
    public Invoice findInvoiceByInvoiceNumber (Integer invoiceNumber);
}
