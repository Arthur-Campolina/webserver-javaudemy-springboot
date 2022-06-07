package com.webserver.webserver.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.webserver.webserver.entities.Order;
import com.webserver.webserver.entities.Payment;
import lombok.*;

import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PaymentDTO {

    private Integer id;
    private Instant moment;
    @JsonIgnore
    @OneToOne
    @MapsId
    private Order order;

    public PaymentDTO (Payment payment) {
        this.id = payment.getId();
        this.moment = payment.getMoment();
        this.order = payment.getOrder();
    }
}
