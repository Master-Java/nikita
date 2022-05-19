package com.example.nikita.service.impl;

import com.example.nikita.dao.UserDao;
import com.example.nikita.domain.User;
import com.example.nikita.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UserDao userDao;

    @Override
    public User getUserById(int id){
        return userDao.getById(id);
    }

    @Override
    public void insert(User user) {
        userDao.insert(user);
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public void deleteUserById(int id) {
        userDao.deleteUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}
