package com.pgprog.controller;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @Autowired
    @Qualifier("postgresJdbcTemplate")
    private JdbcTemplate postgresTemplate;

    @RequestMapping(value = "/")
    public String getPGUser() {
        Map<String, Object> map = new HashMap<String, Object>();
        String query = "select * from usermaster";
        try {
            map = postgresTemplate.queryForMap(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "PostgreSQL Data: " + map.toString();
    }
}