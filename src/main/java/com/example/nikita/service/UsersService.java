package com.example.nikita.service;

import com.example.nikita.domain.User;

import java.util.List;

public interface UsersService {
    User getUserById(int id);

    void insert(User user);

    List<User> getUsers();

    void deleteUserById(int id);

    void updateUser(User user);
}
