package edu.whitehou.service.service;

import edu.whitehou.entity.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.Collection;
import java.util.List;

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

    /**
     * @Cacheable  key 指定缓存数据时使用的key，默认是方法参数，可以使sqEL表达式，与keyGenerator二选一，其中keyGenerator自己编写1
     *
     * */
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
