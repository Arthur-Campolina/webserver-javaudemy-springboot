package com.webserver.webserver.services;

import com.webserver.webserver.entities.Order;
import com.webserver.webserver.repositories.OrderRepository;
import com.webserver.webserver.services.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OrderService implements ServiceImpl<Order> {

    private final OrderRepository orderRepository;

    public Page<Order> findAll(Pageable page) {
        return orderRepository.findAll(page);
    }

    public Order findById(Integer id) {
        Optional<Order> obj = orderRepository.findById(id);
        return obj.get();
    }

    public Order isert(Order obj) {
        return orderRepository.save(obj);
    }
}
