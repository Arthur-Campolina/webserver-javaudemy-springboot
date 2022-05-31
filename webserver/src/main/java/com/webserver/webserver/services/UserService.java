package com.webserver.webserver.services;

import com.webserver.webserver.entities.User;
import com.webserver.webserver.repositories.UserRepository;
import com.webserver.webserver.services.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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

    public User update(Integer id, User obj) {
        User entity = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado!"));
        updateUser(entity, obj);
        return userRepository.save(entity);
    }

    private void updateUser(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
