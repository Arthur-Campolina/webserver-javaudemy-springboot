package com.webserver.webserver.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.webserver.webserver.entities.Category;
import lombok.*;

import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class CategoryDTO {

    private Integer id;
    private String name;
    @JsonIgnore
    @ManyToMany(mappedBy = "categories")
    private Set<ProductDTO> products = new HashSet<>();

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }
}
