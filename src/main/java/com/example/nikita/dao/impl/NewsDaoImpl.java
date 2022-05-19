package com.example.nikita.dao.impl;

import com.example.nikita.dao.NewsDao;
import com.example.nikita.dao.mapper.NewsMapper;
import com.example.nikita.domain.News;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsDaoImpl implements NewsDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public News getById(int id) {
        String sql = "SELECT * FROM news WHERE id = :id";
        return namedParameterJdbcTemplate.queryForObject(sql, new MapSqlParameterSource("id", id), new NewsMapper());
    }

    @Override
    public void insert(News news) {
        String sql = """
                INSERT INTO news (id,date,description,user_id)
                VALUSE ((SELECT COUNT(*) FROM news), :date, :description, :user_id,);
                """;
        namedParameterJdbcTemplate.update(sql, getMapSqlParameters(news));
    }

    @Override
    public List<News> getAllNews() {
        String sql = "SELECT * FROM news";
        return namedParameterJdbcTemplate.query(sql, new MapSqlParameterSource(), new NewsMapper());
    }

    @Override
    public void deleteNewsById(int id) {
        String sql = "DELETE FROM news WHERE id = :id";
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("id", id));
    }

    @Override
    public void updateNews(News news){
        if(news.getId() == null){
            throw new RuntimeException("news dont exists");
        } else {
            String sql = """
                    UPDATE news SET
                     (date,description,user_id) = (:date, :description, :user_id)
                      WHERE id = :id
                    """;
            namedParameterJdbcTemplate.update(sql, getMapSqlParameters(news));
        }
    }

    private SqlParameterSource getMapSqlParameters(News news) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("date", news.getDate());
        mapSqlParameterSource.addValue("description", news.getDescription());
        mapSqlParameterSource.addValue("user_id", news.getUser_id());
        return mapSqlParameterSource;
    }
}
