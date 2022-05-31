package com.webserver.webserver.services;

import com.webserver.webserver.entities.User;
import com.webserver.webserver.repositories.UserRepository;
import com.webserver.webserver.services.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService implements ServiceImpl<User> {

    private final UserRepository userRepository;

    public Page<User> findAll(Pageable page) {
        return userRepository.findAll(page);
    }

    public User findById(Integer id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.get();
    }

    public User isert(User obj) {
        return userRepository.save(obj);
    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
    }
}
