package com.example.nikita.controllers;

import com.example.nikita.domain.News;
import com.example.nikita.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/news")
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @GetMapping("/{id}")
    public News getNewsById(@PathVariable int id) {
        return newsService.getById(id);
    }

    @PostMapping("")
    public void insertNews(@RequestBody News news) {
        newsService.insert(news);
    }

    @PutMapping("")
    public void updateNews(@RequestBody News news) {
        newsService.updateNews(news);
    }

    @DeleteMapping("/{id}")
    public void deleteNewsById(@PathVariable int id) {
        newsService.deleteNewsById(id);
    }

    @GetMapping("/all")
    public List<News> getAllNews() {
        return newsService.getAllNews();
    }
}
