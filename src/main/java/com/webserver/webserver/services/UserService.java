package com.webserver.webserver.services;

import com.webserver.webserver.entities.User;
import com.webserver.webserver.repositories.UserRepository;
import com.webserver.webserver.services.exceptions.DatabaseException;
import com.webserver.webserver.services.exceptions.ResourceNotFoundException;
import com.webserver.webserver.services.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService implements ServiceImpl<User> {

    private final UserRepository userRepository;

    public Page<User> findAll(Pageable page) {
        return userRepository.findAll(page);
    }

    public User findById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return user;
    }

    public User isert(User obj) {
        return userRepository.save(obj);
    }

    public void delete(Integer id) {
        try {
        userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Integer id, User obj) {
            User entity = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
            updateUser(entity, obj);
            return userRepository.save(entity);
    }

    private void updateUser(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
