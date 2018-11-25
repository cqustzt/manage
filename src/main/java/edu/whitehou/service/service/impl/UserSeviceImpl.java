package edu.whitehou.service.service.impl;

import com.github.pagehelper.PageHelper;
import edu.whitehou.entity.PageBean;
import edu.whitehou.entity.User;
import edu.whitehou.mapper.UserMapper;
import edu.whitehou.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * @author : white.hou
 * @description : 
 * @date: 2018/11/10_23:01
 */
@Service
public class UserSeviceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
/*    @Autowired
    RedisTemplate redisTemplate;*/

    @Override
/*    @Cacheable(cacheNames = "allUser")*/
    public Collection<User> findAllUsers() {
        return userMapper.findAllUsers();
    }

    @Override
 /*   @Cacheable(cacheNames = "user",key = "#user.id")*/
    public void addUser(User user) {
         userMapper.addUser(user);
    }

    @Override
   /* @Cacheable(cacheNames = "user",key = "#id",cacheManager = "userRedisCacheManager")*/
    public User findUserById(Integer id) {
      /*  System.out.println("查询第"+id+"号用户");
        if (!(id==null)){
            return (User)redisTemplate.opsForValue().get(id);
        }else {
            User userById = userMapper.findUserById(id);
            return userById;
        }*/
      return userMapper.findUserById(id);
    }

    @Override
   /* @CachePut(cacheNames = "user",key = "#user.id")*/
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
/*    @CacheEvict(cacheNames = "user",key = "#id")*/
    public void deleteUserById(Integer id) {
        userMapper.deleteUserById(id);
    }


}

