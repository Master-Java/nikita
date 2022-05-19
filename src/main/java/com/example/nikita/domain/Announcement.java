package com.example.nikita.domain;

import lombok.Data;

@Data
public class Announcement {
    private Integer id;
    private int userId;
    private String description;
    private String date;
    private TypeAnnouncement type;
}