package com.example.nikita.service;

import com.example.nikita.domain.User;

public interface ContactsService {

    void insert(User consumer, User client);

    void deleteById(int idConsumer, int idClient);
}
