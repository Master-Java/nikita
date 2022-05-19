package com.example.nikita.dao;

import com.example.nikita.domain.Announcement;

import java.util.List;

public interface AnnouncementDao {
    Announcement getAnnouncementById(int id);

    void insertAnnouncement(Announcement announcement);

    List<Announcement> getAllAd();

    List<Announcement> getAllSale();

    void deleteAnnouncementById(int id);

    void updateAnnouncement(Announcement announcement);
}
