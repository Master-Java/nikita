package com.example.nikita.dao;

import com.example.nikita.domain.News;

import java.util.List;

public interface NewsDao {

    News getById(int id);

    void insert(News news);

    List<News> getAllNews();

    void deleteNewsById(int id);

    void updateNews(News news);
}
