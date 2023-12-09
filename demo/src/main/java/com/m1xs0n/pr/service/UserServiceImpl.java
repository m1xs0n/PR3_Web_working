package com.m1xs0n.pr.service;


import com.m1xs0n.pr.business.entities.User;
import com.m1xs0n.pr.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> updateUser(Long id, User updatedUser) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            updatedUser.setId(existingUser.get().getId());
            return Optional.of(userRepository.save(updatedUser));
        }
        return Optional.empty();
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
