package com.example.nikita.dao.impl;

import com.example.nikita.dao.UserDao;
import com.example.nikita.dao.mapper.UserMapper;
import com.example.nikita.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public User getById(int id) {
        String sql = "SELECT * FROM USERS WHERE id = :id";
        return namedParameterJdbcTemplate.queryForObject(sql, new MapSqlParameterSource("id", id), new UserMapper());
    }

    @Override
    public void insert(User user) {
        String sql = """
                INSERT INTO users (id,name,login,age,email,phone,addressHome)
                VALUSE ((SELECT COUNT(*) FROM users), :name, :login, :age, :email, :phone, :addressHome);
                """;
        namedParameterJdbcTemplate.update(sql, getMapSqlParameters(user));
    }

    @Override
    public List<User> getUsers() {
        String sql = "SELECT * FROM users";
        return namedParameterJdbcTemplate.query(sql, new MapSqlParameterSource(), new UserMapper());
    }

    @Override
    public void deleteUserById(int id) {
        String sql = "DELETE FROM users WHERE id = :id";
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("id", id));
    }

    @Override
    public void updateUser(User user){
        if(user.getId() == null){
            throw new RuntimeException("user dont exists");
        } else {
            String sql = """
                    UPDATE users SET
                     (name, login, age, email, phone, addressHome) = (:name, :login, :age, :email, :phone, :addressHome)
                      WHERE id = :id
                    """;
            namedParameterJdbcTemplate.update(sql, getMapSqlParameters(user));
        }
    }

    private SqlParameterSource getMapSqlParameters(User user) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("name", user.getName());
        mapSqlParameterSource.addValue("login", user.getLogin());
        mapSqlParameterSource.addValue("age", user.getAge());
        mapSqlParameterSource.addValue("email", user.getEmail());
        mapSqlParameterSource.addValue("phone", user.getPhone());
        mapSqlParameterSource.addValue("addressHome", user.getAddressHome());
        return mapSqlParameterSource;
    }
}
