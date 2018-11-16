package edu.whitehou.service.service.impl;

import edu.whitehou.entity.User;
import edu.whitehou.mapper.UserMapper;
import edu.whitehou.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
/** 
 * @author : white.hou
 * @description : 
 * @date: 2018/11/10_23:01
 */
@Service
public class UserSeviceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Collection<User> findAllUsers() {
        return userMapper.findAllUsers();
    }

    @Override
    public void addUser(User user) {
         userMapper.addUser(user);
    }

    @Override
    public User findUserById(Integer id) {
        return userMapper.findUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        userMapper.deleteUserById(id);
    }

}
