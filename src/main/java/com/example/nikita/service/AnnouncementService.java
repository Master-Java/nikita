package com.example.nikita.service;

import com.example.nikita.domain.Announcement;

import java.util.List;

public interface AnnouncementService {
    Announcement getAnnouncementById(int id);

    void insertAnnouncement(Announcement announcement);

    List<Announcement> getAllAd();

    List<Announcement> getAllSale();

    void deleteAnnouncementById(int id);

    void updateAnnouncement(Announcement announcement);
}
