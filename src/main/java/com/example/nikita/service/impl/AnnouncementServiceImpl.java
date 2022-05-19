package com.example.nikita.service.impl;

import com.example.nikita.dao.AnnouncementDao;
import com.example.nikita.domain.Announcement;
import com.example.nikita.service.AnnouncementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnnouncementServiceImpl implements AnnouncementService {

    private final AnnouncementDao announcementDao;

    @Override
    public Announcement getAnnouncementById(int id) {
        return announcementDao.getAnnouncementById(id);
    }

    @Override
    public void insertAnnouncement(Announcement announcement) {
        announcementDao.insertAnnouncement(announcement);
    }

    @Override
    public List<Announcement> getAllAd() {
        return announcementDao.getAllAd();
    }

    @Override
    public List<Announcement> getAllSale() {
        return announcementDao.getAllSale();
    }

    @Override
    public void deleteAnnouncementById(int id) {
        announcementDao.deleteAnnouncementById(id);
    }

    @Override
    public void updateAnnouncement(Announcement announcement) {
        announcementDao.updateAnnouncement(announcement);
    }
}
