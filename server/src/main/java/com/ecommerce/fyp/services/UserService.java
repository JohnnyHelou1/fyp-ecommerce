package com.ecommerce.fyp.services;

import com.ecommerce.fyp.persistence.model.User;
import com.ecommerce.fyp.persistence.repositories.UserRepository;
import com.ecommerce.fyp.services.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository){
        this.repository = repository;
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    public User getUser(int id) throws UserNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public User createUser(User user) {
        return repository.saveAndFlush(user);
    }

    public void deleteUser(int id) {
        repository.deleteById(id);
    }
}
