package com.baizhi.mybatisgenerator;

import com.baizhi.mybatisgenerator.dao.UserMapper;
import com.baizhi.mybatisgenerator.entity.User;
import com.baizhi.mybatisgenerator.entity.UserExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @project: BeiJingProject
 * @author: AdminLi
 * @date: 2019/2/22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MGApp.class)
public class MGAppTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {
        List<User> users = userMapper.selectByExample(null);
        users.forEach(System.out::println);
    }

    @Test
    public void testSelectById() {
        User user = userMapper.selectByPrimaryKey(47);
        System.out.println(user);
    }

    @Test
    public void testSelectByName() {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo("刘少奇");
        List<User> users = userMapper.selectByExample(example);
        users.forEach(System.out::println);
    }

    @Test
    public void testSelectByName2() {
        UserExample example = new UserExample();
        example.createCriteria().andIdBetween(30, 50);
        List<User> users = userMapper.selectByExample(example);
        users.forEach(System.out::println);
    }

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setName("test generator2");
        user.setPwd("123");
        // int i = userMapper.insert(user);
        int i = userMapper.insertSelective(user);
        System.out.println(i);
    }

    @Test
    public void testUpdateUserById() {
        User user = new User();
        user.setPwd("123");
        UserExample example = new UserExample();
        example.createCriteria().andIdBetween(1, 30);
        int i = userMapper.updateByExampleSelective(user, example);
        System.out.println(i);
    }

    @Test
    public void testCount() {
        int count = userMapper.countByExample(null);
        System.out.println(count);
    }

    @Test
    public void testDelete() {
        UserExample example = new UserExample();
        example.createCriteria().andIdBetween(25, 27);
        int i = userMapper.deleteByExample(example);
        System.out.println(i);
    }

    @Test
    public void testSelect() {
        UserExample example = new UserExample();
        example.setOrderByClause("id");
        List<User> users = userMapper.selectByExample(example);
        users.forEach(System.out::println);
    }

    @Test
    public void test2() {

    }
}
