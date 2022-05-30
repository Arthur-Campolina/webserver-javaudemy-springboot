package com.webserver.webserver.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.webserver.webserver.entities.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@AllArgsConstructor
@Entity
@Table(name = "tb_orders")
public class Order extends AbstractEntity {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;
    private String orderStatus;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();

    public Order() {
    }

    public Order(Instant moment, OrderStatus orderStatus, User client) {
        super();
        this.moment = moment;
        setOrderStatus(orderStatus);
        this.client = client;
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    public OrderStatus getOrderStauts() {
        return OrderStatus.content(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus != null) {
            this.orderStatus = orderStatus.getDescription();
        }
    }
}
