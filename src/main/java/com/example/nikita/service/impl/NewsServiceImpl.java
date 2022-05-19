package com.example.nikita.service.impl;

import com.example.nikita.dao.NewsDao;
import com.example.nikita.domain.News;
import com.example.nikita.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    private final NewsDao newsDao;

    @Override
    public News getById(int id) {
        return newsDao.getById(id);
    }

    @Override
    public void insert(News news) {
        newsDao.insert(news);
    }

    @Override
    public List<News> getAllNews() {
        return newsDao.getAllNews();
    }

    @Override
    public void deleteNewsById(int id) {
        newsDao.deleteNewsById(id);
    }

    @Override
    public void updateNews(News news) {
        newsDao.updateNews(news);
    }
}
