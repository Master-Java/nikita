package com.example.nikita.controllers;

import com.example.nikita.domain.User;
import com.example.nikita.service.ContactsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/contacts")
@RequiredArgsConstructor
public class ContactsController {

    private final ContactsService contactsService;

    @PostMapping
    public void insert(@RequestBody User consumer, @RequestBody User client){
        contactsService.insert(consumer, client);
    }

    @DeleteMapping("/{idConsumer}/{idClient}")
    public void deleteContactsById(@PathVariable int idConsumer, @PathVariable int idClient){
        contactsService.deleteById(idConsumer,idClient);
    }
}
