package com.webserver.webserver.services;

import com.webserver.webserver.entities.Order;
import com.webserver.webserver.entities.enums.OrderStatus;
import com.webserver.webserver.repositories.OrderRepository;
import com.webserver.webserver.services.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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

    public Order isert(Order order) {
        return orderRepository.save(order);
    }

    public void delete(Integer id) {
        orderRepository.deleteById(id);
    }

    public Order update(Integer id, Order obj) {
        Order entity = orderRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado!"));
        orderUpdate(entity, obj);
        return orderRepository.save(entity);
    }

    public void orderUpdate(Order entity, Order obj) {
        entity.setOrderStatus(OrderStatus.valueOf(obj.getOrderStatus()));
    }
}
