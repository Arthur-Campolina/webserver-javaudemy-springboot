package com.webserver.webserver.services;

import com.webserver.webserver.entities.Category;
import com.webserver.webserver.repositories.CategoryRepository;
import com.webserver.webserver.services.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoryService implements ServiceImpl<Category> {

    private final CategoryRepository categoryRepository;

    public Page<Category> findAll(Pageable page) {
        return categoryRepository.findAll(page);
    }

    public Category findById(Integer id) {
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.get();
    }

    public Category isert(Category obj) {
        return categoryRepository.save(obj);
    }

    public void delete(Integer id) {
        categoryRepository.deleteById(id);
    }
}
