package com.yuqiqi.growup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by yuyunbo on 2019/4/26.
 */
@RestController
@RequestMapping("/dbtest")
public class DBTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/getTest")
    public Object getTest(){
        return "this is test";
    }

    @RequestMapping("/getTestDB")
    public Object getTestDB(){
        String sql = "select * from data_sys_user limit 10";
        List<Map<String,Object>> list =jdbcTemplate.queryForList(sql);
        return list;
    }



}
