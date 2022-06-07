package com.webserver.webserver.dto.pkdto;

import com.webserver.webserver.dto.OrderDTO;
import com.webserver.webserver.dto.ProductDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Embeddable
public class OrderItemPKDTO {

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderDTO order;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductDTO product;
}
