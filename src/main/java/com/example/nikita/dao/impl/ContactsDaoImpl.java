package com.example.nikita.dao.impl;

import com.example.nikita.dao.ContactsDao;
import com.example.nikita.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactsDaoImpl implements ContactsDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public void insert(User consumer, User client) {
        String sql = """
                INSERT INTO contacts (user_id_consumer, user_id_client, username, last_sms, phone, last_entry)
                VALUSE (:user_id_consumer, :user_id_client, :username, :last_sms, :phone, :last_entry);
                """;
        namedParameterJdbcTemplate.update(sql, getMapSqlParameters(consumer, client));
    }

    @Override
    public void deleteById(int idConsumer, int idClient) {
        String sql = """
                DELETE FROM users WHERE user_id_consumer = :user_id_consumer AND user_id_client = :user_id_client;
                """;
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("user_id_consumer",idConsumer);
        mapSqlParameterSource.addValue("user_id_client", idClient);
        namedParameterJdbcTemplate.update(sql, mapSqlParameterSource);
    }

    public SqlParameterSource getMapSqlParameters(User consumer, User client){
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("user_id_consumer",consumer.getId());
        mapSqlParameterSource.addValue("user_id_client", client.getId());
        mapSqlParameterSource.addValue("username", client.getName());
        mapSqlParameterSource.addValue("phone", client.getPhone());
        return mapSqlParameterSource;
    }
}
