package com.webserver.webserver.services;

import com.webserver.webserver.entities.Product;
import com.webserver.webserver.repositories.ProductRepository;
import com.webserver.webserver.services.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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

    public void delete(Integer id) {
        productRepository.deleteById(id);
    }

    public Product update(Integer id, Product obj) {
        Product entity = productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Produto não encontrado!"));
        updateProduct(entity, obj);
        return productRepository.save(entity);
    }

    public void updateProduct(Product entity, Product obj) {
        entity.setName(obj.getName());
        entity.setDescription(obj.getDescription());
        entity.setPrice(obj.getPrice());
    }
}
