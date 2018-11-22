package edu.whitehou.mapper;

import edu.whitehou.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * @author : white.hou
 * @description : 对用户进行操作
 * @date: 2018/11/10_19:23
 */
@Repository
public interface UserMapper {
    /**
     * 查找所有的用户
     */
    Collection <User> findAllUsers();

    /**
     * 分页用 查询所有的用户1
     * @return
     */
    List<User> findAllUsersByPage();

    /**
     * 根据Id查找指定用户
     * @return
     */
     User findUserById(Integer id);

    /**
     * 添加用户信息
     * @return
     */
    void addUser(User user);

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

    /**
     * 查询总的用户记录数目
     * @return
     */
    Integer findUserCountNum();

}
