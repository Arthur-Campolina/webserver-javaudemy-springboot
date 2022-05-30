package com.webserver.webserver.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.Instant;

@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_payments")
public class Payment extends AbstractEntity {

    private Instant moment;

    @JsonIgnore
    @OneToOne
    @MapsId
    private Order order;
}
