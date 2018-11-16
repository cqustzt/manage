package edu.whitehou.service.service;

import edu.whitehou.entity.User;

import java.util.Collection;

/**
 * @author : white.hou
 * @description : 对用户操作的service层
 * @date: 2018/11/10_19:39
 */
public interface UserService {
    /**
     * 查询所有用户
     */
    Collection<User> findAllUsers();

    /**
     * 添加用户
     * @param user
     */
    void addUser(User user);

    /**
     * 根据ID查找指定用户
     * @param id
     * @return
     */
    User findUserById(Integer id);

    /**
     * 修改用户信息
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除用户
     * @param id
     */
    void deleteUserById(Integer id);

}
