package com.webserver.webserver.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.webserver.webserver.entities.Product;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ProductDTO {

    private Integer id;
    private String name;
    private String description;
    private Double price;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_product_category", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<CategoryDTO> categories = new HashSet<>();
    @OneToMany(mappedBy = "id.product")
    private Set<OrderItemDTO> items = new HashSet<>();

    @JsonIgnore
    public Set<OrderDTO> getOrders() {
        Set<OrderDTO> set = new HashSet<>();
        for (OrderItemDTO x : items) {
            set.add(x.getOrder());
        }
        return set;
    }

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
    }
}
