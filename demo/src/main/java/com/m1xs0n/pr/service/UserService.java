package com.m1xs0n.pr.service;



import com.m1xs0n.pr.business.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    User createUser(User user);
    Optional<User> updateUser(Long id, User user);
    void deleteUser(Long id);
}
