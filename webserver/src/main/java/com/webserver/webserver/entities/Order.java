package com.webserver.webserver.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.webserver.webserver.entities.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@AllArgsConstructor
@Setter
@Getter
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

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

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

    public Double getTotal(){
        double sum = 0;
        for(OrderItem x : items) {
           sum += x.getSubTotal();
        }
        return sum;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus != null) {
            this.orderStatus = orderStatus.getDescription();
        }
    }
}
