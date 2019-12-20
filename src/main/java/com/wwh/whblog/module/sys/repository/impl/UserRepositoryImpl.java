package com.wwh.whblog.module.sys.repository.impl;

import com.wwh.whblog.module.sys.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepositoryImpl {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User getUserById(String userId){
        Map<String, Object> params = new HashMap<String, Object>();

        String sql = "select id, username from user where id = :id and is_deleted = :status ";
        params.put("id", userId);
        params.put("status", User.IS_NOT_DELETED);

        User data = new NamedParameterJdbcTemplate(this.jdbcTemplate).queryForObject(sql.toString(), params, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(resultSet.getString("id"));
                user.setUserName(resultSet.getString("username"));
                return user;
            }
        });
        return data;
    }

    public User getUserByUserName(String userName){
        Map<String, Object> params = new HashMap<String, Object>();

        String sql = " select id, username, is_lock, password from user where username = :userName and is_deleted = :status ";
        params.put("userName", userName);
        params.put("status", User.IS_NOT_DELETED);

        User data = new NamedParameterJdbcTemplate(this.jdbcTemplate).queryForObject(sql.toString(), params, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(resultSet.getString("id"));
                user.setUserName(resultSet.getString("username"));
                user.setIsLock(resultSet.getInt("is_lock"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        });

        return data;
    }

}
