package com.webserver.webserver.controllers;


import com.webserver.webserver.entities.Product;
import com.webserver.webserver.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/products")
public class ProductController {

    private final ProductService productService;

    //controlador rest que responde no caminho /products
    @GetMapping//endpoint pra acessar os usuarios
    //ResponseEntity é do tipo generics, retorno de tipo especifico para requisicoes do tipo web.
    public ResponseEntity<Page<Product>> findAll(Pageable page) {
        Page<Product> list = productService.findAll(page);
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Integer id) {
        Product product = productService.findById(id);
        return ResponseEntity.ok().body(product);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
