package com.webserver.webserver.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.webserver.webserver.entities.Order;
import com.webserver.webserver.entities.OrderItem;
import com.webserver.webserver.entities.enums.OrderStatus;
import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class OrderDTO {

    private Integer id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;
    private String orderStatus;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private UserDTO client;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private PaymentDTO payment;

    public Double getTotal() {
        double sum = 0;
        for (OrderItem x : items) {
            sum += x.getSubTotal();
        }
        return sum;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus != null) {
            this.orderStatus = orderStatus.getDescription();
        }
    }

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.moment = order.getMoment();
        this.orderStatus = order.getOrderStatus();
        this.items = order.getItems();
        this.payment.setId(order.getPayment().getId());
    }
}
