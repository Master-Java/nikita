package com.example.nikita.dao;

import com.example.nikita.domain.User;

import java.util.List;

public interface UserDao {

    User getById(int id);

    void insert(User user);

    List<User> getUsers();

    void deleteUserById(int id);

    void updateUser(User user);
}
