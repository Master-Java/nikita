package com.example.nikita.controllers;

import com.example.nikita.domain.Announcement;
import com.example.nikita.service.AnnouncementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/announcement")
@RequiredArgsConstructor
public class AnnouncementController {

    private final AnnouncementService announcementService;

    @GetMapping("/{id}")
    public Announcement getAnnouncementById(@PathVariable int id) {
        return announcementService.getAnnouncementById(id);
    }

    @PostMapping("")
    public void insertUser(@RequestBody Announcement announcement){
        announcementService.insertAnnouncement(announcement);
    }

    @PutMapping("")
    public void updateUser(@RequestBody Announcement announcement){
        announcementService.updateAnnouncement(announcement);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable int id) {
        announcementService.deleteAnnouncementById(id);
    }

    @GetMapping("/ad")
    public List<Announcement> getAllAd(){
        return announcementService.getAllAd();
    }

    @GetMapping("/sale")
    public List<Announcement> getAllSale(){
        return announcementService.getAllSale();
    }
}
