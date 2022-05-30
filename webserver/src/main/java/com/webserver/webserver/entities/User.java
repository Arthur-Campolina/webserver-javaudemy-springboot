package com.webserver.webserver.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(name = "tb_users")
public class User extends AbstractEntity {

    private String name;
    @Column(unique = true)
    private String email;
    private String phone;
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<Order> orders = new ArrayList<>();

    public User(String name, String email, String phone, String password) {
        super();
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }
}
