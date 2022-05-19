package com.example.nikita.dao.mapper;

import com.example.nikita.domain.News;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NewsMapper implements RowMapper<News> {
    @Override
    public News mapRow(ResultSet rs, int rowNum) throws SQLException {
        News news = new News();
        news.setId(rs.getInt("id"));
        news.setDate(rs.getString("date"));
        news.setDescription(rs.getString("description"));
        news.setUser_id(rs.getInt("user_id"));
        return news;
    }
}
