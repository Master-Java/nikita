package com.example.nikita.domain;

import lombok.Data;

@Data
public class News {
    private Integer id;
    private int user_id;
    private String description;
    private String date;
}
