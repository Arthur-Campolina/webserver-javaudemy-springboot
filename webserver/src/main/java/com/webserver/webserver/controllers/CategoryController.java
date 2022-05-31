package com.webserver.webserver.controllers;


import com.webserver.webserver.entities.Category;
import com.webserver.webserver.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/categories")
public class CategoryController {

    private final CategoryService categoryService;

    //controlador rest que responde no caminho /Categorys
    @GetMapping//endpoint pra acessar os usuarios
    //ResponseEntity é do tipo generics, retorno de tipo especifico para requisicoes do tipo web.
    public ResponseEntity<Page<Category>> findAll(Pageable page) {
        Page<Category> list = categoryService.findAll(page);
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Integer id) {
        Category Category = categoryService.findById(id);
        return ResponseEntity.ok().body(Category);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
