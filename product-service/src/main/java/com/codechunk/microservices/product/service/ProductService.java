package com.codechunk.microservices.product.service;

import com.codechunk.microservices.product.dto.ProductRequest;
import com.codechunk.microservices.product.dto.ProductResponse;
import com.codechunk.microservices.product.model.Product;
import com.codechunk.microservices.product.repo.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponse createProduct(ProductRequest productRequest){
        Product product = Product.builder()

                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();

        productRepository.save(product);
        log.info("Product created successfully");
        return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());


    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice()))
                .toList();
    }



}
