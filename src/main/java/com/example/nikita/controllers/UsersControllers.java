package com.example.nikita.controllers;

import com.example.nikita.domain.User;
import com.example.nikita.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UsersControllers {

    private final UsersService usersService;

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return usersService.getUserById(id);
    }

    @PostMapping("")
    public void insertUser(@RequestBody User user){
        usersService.insert(user);
    }

    @PutMapping("")
    public void updateUser(@RequestBody User user){
        usersService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable int id) {
        usersService.deleteUserById(id);
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return usersService.getUsers();
    }
}
