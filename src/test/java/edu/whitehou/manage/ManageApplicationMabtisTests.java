package edu.whitehou.manage;

import edu.whitehou.entity.Root;
import edu.whitehou.entity.User;
import edu.whitehou.mapper.RootMapper;
import edu.whitehou.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
//@SpringBootTest
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ManageApplicationMabtisTests {
    @Autowired
    private RootMapper rootMapper;
    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads() {
       /* Root root01 = rootMapper.findRootTokenByRootName("root01");
        System.out.println(root01);*/
//        Collection<User> allUsers = userMapper.findAllUsers();
//        System.out.println(allUsers);
  /*      User user=new User("test","test",1,"test","test","test","test");
        userMapper.addUser(user);
        System.out.println(user);*/
        /*User userById = userMapper.findUserById(1);
        System.out.println(userById);*/
        /*Collection<Root> allRoot = rootMapper.findAllRoots();
        System.out.println(allRoot);
*/
        Integer userCountNum = userMapper.findUserCountNum();
        System.out.println(userCountNum);

    }


}
