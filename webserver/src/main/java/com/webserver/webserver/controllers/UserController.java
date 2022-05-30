package com.webserver.webserver.controllers;


import com.webserver.webserver.entities.User;
import com.webserver.webserver.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    //controlador rest que responde no caminho /users
    @GetMapping//endpoint pra acessar os usuarios
    //ResponseEntity é do tipo generics, retorno de tipo especifico para requisicoes do tipo web.
    public ResponseEntity<Page<User>> findAll(Pageable page) {
        Page<User> list = userService.findAll(page);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Integer id) {
        User user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<User> isert(@RequestBody User obj) {
        obj = userService.isert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
}
