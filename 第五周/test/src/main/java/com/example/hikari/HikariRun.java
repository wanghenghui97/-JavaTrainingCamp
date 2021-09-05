package com.example.hikari;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HikariRun implements CommandLineRunner {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        String sql = "select * from sys_users";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper(User.class));
        users.stream().forEach(System.out::println);
    }
}
