package com.webserver.webserver.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.webserver.webserver.dto.pkdto.OrderItemPKDTO;
import com.webserver.webserver.entities.OrderItem;
import lombok.*;

import javax.persistence.EmbeddedId;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OrderItemDTO {

    @EmbeddedId
    private OrderItemPKDTO id = new OrderItemPKDTO();
    private Integer quantity;
    private Double price;

    public OrderItemDTO(OrderDTO order, ProductDTO product, Integer quantity, Double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    @JsonIgnore
    public OrderDTO getOrder() {
        return id.getOrder();
    }

    public OrderItemDTO (OrderItem orderItem) {
        this.id.getOrder().setId(orderItem.getOrder().getId());
        this.id.getProduct().setId(orderItem.getProduct().getId());
        this.quantity = orderItem.getQuantity();
        this.price = orderItem.getPrice();
    }
}
