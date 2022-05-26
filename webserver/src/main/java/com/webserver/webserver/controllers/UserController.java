package com.webserver.webserver.controllers;

import com.webserver.webserver.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    //controlador rest que responde no caminho /users
    @GetMapping//endpoint pra acessar os usuarios
    //ResponseEntity é do tipo generics, retorno de tipo especifico para requisicoes do tipo web.
    public ResponseEntity<User> findAll() {
        User user = new User(1, "Maria", "maria@gmail.com", "319999999", "123456");
        return ResponseEntity.ok().body(user);
    }
}
