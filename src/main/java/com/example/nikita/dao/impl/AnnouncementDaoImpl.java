package com.example.nikita.dao.impl;

import com.example.nikita.dao.AnnouncementDao;
import com.example.nikita.dao.mapper.AnnouncementMapper;
import com.example.nikita.domain.Announcement;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnnouncementDaoImpl implements AnnouncementDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Announcement getAnnouncementById(int id) {
        String sql = "SELECT * FROM announcement WHERE id = :id";
        return namedParameterJdbcTemplate.queryForObject(sql, new MapSqlParameterSource("id", id), new AnnouncementMapper());
    }

    @Override
    public void insertAnnouncement(Announcement announcement) {
        String sql = """
                 INSERT INTO announcement  (user_id, description, date, type)
                 VALUSE ((SELECT COUNT(*) FROM users), :user_id, :description, :date,: type)
                """;
        namedParameterJdbcTemplate.update(sql, getMapSqlParameters(announcement));
    }

    @Override
    public List<Announcement> getAllAd() {
        String sql = "SELECT * FROM announcement WHERE type = 'AD'";
        return namedParameterJdbcTemplate.query(sql, new AnnouncementMapper());
    }

    @Override
    public List<Announcement> getAllSale() {
        String sql = "SELECT * FROM announcement WHERE type = 'SALE'";
        return namedParameterJdbcTemplate.query(sql, new AnnouncementMapper());
    }

    @Override
    public void deleteAnnouncementById(int id) {
        String sql = "DELETE FROM announcement WHERE id = :id";
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("id", id));
    }

    @Override
    public void updateAnnouncement(Announcement announcement) {
        if (announcement.getId() == null) {
            throw new RuntimeException("announcement dont exists");
        } else {
            String sql = """
                    UPDATE users SET
                     (user_id,description,date,type) = (:user_id,:description,:date,:type)
                      WHERE id = :id
                    """;
            namedParameterJdbcTemplate.update(sql, getMapSqlParameters(announcement));
        }
    }

    private SqlParameterSource getMapSqlParameters(Announcement announcement) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("user_id", announcement.getUserId());
        mapSqlParameterSource.addValue("description", announcement.getDescription());
        mapSqlParameterSource.addValue("date", announcement.getDate());
        mapSqlParameterSource.addValue("type", announcement.getType());
        return mapSqlParameterSource;
    }
}
