package com.test.techstarttestapi.repository;

import com.test.techstarttestapi.model.InvoiceLine;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface InvoiceLineRepository extends MongoRepository<InvoiceLine, String> {
}
