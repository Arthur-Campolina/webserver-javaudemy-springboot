package com.webserver.webserver.services.impl;

import com.webserver.webserver.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServiceImpl<T> {
    Page<T> findAll(Pageable page);
    T findById(Integer id);
    T isert(T obj);
    void delete(Integer id);
}
