package com.example.nikita.service.impl;

import com.example.nikita.dao.ContactsDao;
import com.example.nikita.domain.User;
import com.example.nikita.service.ContactsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactsServiceImpl implements ContactsService {

    private final ContactsDao contactsDao;

    @Override
    public void insert(User consumer, User client) {
        contactsDao.insert(consumer, client);
    }

    @Override
    public void deleteById(int idConsumer, int idClient) {
        contactsDao.deleteById(idConsumer, idClient);
    }
}
