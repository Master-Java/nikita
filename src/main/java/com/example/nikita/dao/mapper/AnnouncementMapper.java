package com.example.nikita.dao.mapper;

import com.example.nikita.domain.Announcement;
import com.example.nikita.domain.TypeAnnouncement;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AnnouncementMapper implements RowMapper<Announcement> {
    @Override
    public Announcement mapRow(ResultSet rs, int rowNum) throws SQLException {
        Announcement announcement = new Announcement();
        announcement.setId(rs.getInt("id"));
        announcement.setDate(rs.getString("date"));
        announcement.setDescription(rs.getString("description"));
        announcement.setType(rs.getString("type").equalsIgnoreCase(TypeAnnouncement.SALE.name())
                ? TypeAnnouncement.SALE
                : TypeAnnouncement.AD);
        announcement.setUserId(rs.getInt("user_id"));
        return announcement;
    }
}
