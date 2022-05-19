package com.example.nikita.service;

import com.example.nikita.domain.News;

import java.util.List;

public interface NewsService {
    News getById(int id);

    void insert(News news);

    List<News> getAllNews();

    void deleteNewsById(int id);

    void updateNews(News news);
}
