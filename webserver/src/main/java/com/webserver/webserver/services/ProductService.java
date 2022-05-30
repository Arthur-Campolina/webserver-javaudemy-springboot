package com.webserver.webserver.services;

import com.webserver.webserver.entities.Product;
import com.webserver.webserver.repositories.ProductRepository;
import com.webserver.webserver.services.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService implements ServiceImpl<Product> {

    private final ProductRepository productRepository;

    public Page<Product> findAll(Pageable page) {
        return productRepository.findAll(page);
    }

    public Product findById(Integer id) {
        Optional<Product> obj = productRepository.findById(id);
        return obj.get();
    }

    public Product isert(Product obj) {
        return productRepository.save(obj);
    }
}
