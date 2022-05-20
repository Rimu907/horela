package com.hl;

import com.hl.dao.UserMapper;
import com.hl.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Date;

/**
 * @Date:2022/3/24 17:26
 * @Author:NANDI_GUO
 */
@Slf4j
@SpringBootTest
public class SqlTest {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserMapper userMapper;

//    @Test
//    public void buildUser(){
//        User build = User.builder().sex("男").birth(Date.valueOf("1999-01-15")).username("xiaoming").build();
//        System.out.println(build);
//    }
//
//    @Test
//    public void getUser(){
//        User user = userMapper.selectById(1);
//        System.out.println(user);
//    }
//
//
//    @Test
//    public void deleteUser(){
//        userMapper.deleteById(1);
//        log.info("User deleted");
//    }
//
//
//
//    @Test
//    public void testConnection() throws Exception {
//        System.out.println("数据库连接: " + dataSource.getConnection());
//    }
}
