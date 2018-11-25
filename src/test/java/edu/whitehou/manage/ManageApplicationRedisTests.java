package edu.whitehou.manage;

import edu.whitehou.entity.User;
import edu.whitehou.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManageApplicationRedisTests {
    /**
     * k-v  都是对象
     */
    @Autowired
    RedisTemplate redisTemplate;
    /**
     * k-v都是字符串你
     */
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    /**
     * Redis 五大数据类型
     * String List Set Hash ZSet(有序集合)
     */
    @Autowired
    UserMapper userMapper;
    @Autowired
    RedisTemplate<Object,User>  userRedisTemplate;
    @Test
    public void contextLoads() {
        /*stringRedisTemplate.opsForValue().append("msg","today");*/
        /*String msg = stringRedisTemplate.opsForValue().get("msg");
        System.out.println(msg);*/
        /*User userById = userMapper.findUserById(1);*/
       /* redisTemplate.opsForValue().set("user-01",userById);*/
/*
        Collection<User> allUsers = userMapper.findAllUsers();
        redisTemplate.opsForValue().set("all",allUsers);
        Object all = redisTemplate.opsForValue().get("all");
        System.out.println(all);*/
     /*   HashMap<String, Object> objectObjectHashMap = new HashMap<String, Object>();
        objectObjectHashMap.put("id",100);
        objectObjectHashMap.put("userId",11110000);
        objectObjectHashMap.put("password",11110000);
        objectObjectHashMap.put("username","test");
        objectObjectHashMap.put("gender".0);
        objectObjectHashMap.put("identity","user:test");
        objectObjectHashMap.put("collage","信息1");
        objectObjectHashMap.put("grade","admin");
        objectObjectHashMap.put("phone"."11110000");*/
        User user = new User();
        user.setUserId("11110001");
        user.setPassword("11110000");
        user.setUserName("test");
        user.setGender(0);
        user.setCollage("test");
        user.setIdentity("test");
        user.setPhone("11110000");
        user.setGrade("test");
        userMapper.addUser(user);
        userRedisTemplate.opsForValue().set(user.getId(),user);
        Object o = userRedisTemplate.opsForValue().get(user.getId());
        System.out.println(o);
    }

}
