package com.codechunk.microservices.product.repo;

import com.codechunk.microservices.product.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
