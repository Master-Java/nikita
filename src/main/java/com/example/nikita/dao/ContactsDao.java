package com.example.nikita.dao;

import com.example.nikita.domain.User;

public interface ContactsDao {

    void insert(User consumer, User client);

    void deleteById(int idConsumer, int idClient);
}
