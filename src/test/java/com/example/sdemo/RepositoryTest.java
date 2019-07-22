package com.example.sdemo;

import com.alibaba.fastjson.JSON;
import com.example.sdemo.dao.UserRepository;
import com.example.sdemo.entity.User;
import com.example.sdemo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @program: sdemo
 * @description:
 * @author: yangfan
 * @create: 2019/06/21 10:57
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired(required = true)
    private UserService userService;

    @Test
    public void test(){
        User user = new User();
        user.setAccount("aaaa");
        user.setCreateTime(new Date());
        user.setName("aaa1");
        user.setPassword("123456");
        //userRepository.save(user);
        User u = userRepository.findUserByNameAndPassword("aaa1","123456");
        System.out.println(u);
        u = userRepository.findUserByAccount("sail");
        System.out.println(u);
    }

    @Test
    public void ServiceTest(){
        User user = new User();
        user.setAccount("aaaa");
        user.setCreateTime(new Date());
        user.setName("aaa1");
        user.setPassword("123456");
        Sort sort = new Sort(Sort.Direction.ASC,"name");
        Page<User> page = userService.search(user, PageRequest.of(0,5,sort));
        String str = JSON.toJSONString(page);
        System.out.println(str);
    }
}
