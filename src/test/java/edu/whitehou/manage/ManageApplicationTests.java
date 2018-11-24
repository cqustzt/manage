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

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManageApplicationTests {
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
        User userById = userMapper.findUserById(1);
       /* redisTemplate.opsForValue().set("user-01",userById);*/
        userRedisTemplate.opsForValue().set("user-01",userById);

    }

}
