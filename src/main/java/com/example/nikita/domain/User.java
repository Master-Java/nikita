package com.example.nikita.domain;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private String login;
    private int age;
    private String email;
    private String phone;
    private String addressHome;
}
