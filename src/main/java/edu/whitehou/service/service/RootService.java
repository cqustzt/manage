package edu.whitehou.service.service;

import edu.whitehou.entity.Root;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.Collection;

public interface RootService {
    /**
     * 通过用户账号（登录账号）查询用户
     * @param rootName
     */
    Root findRootTokenByRootName(String rootName);

    /**
     * 查询所有管理员
     * @return
     */
    Collection<Root> findAllRoots();

    /**
     * 新增管理员
     */
    void addRoot(Root root);

    /**
     * 修改管理员信息
     * @param root
     */
    void updateRoot(Root root);

    /**
     * 通过id查询用户
     * @param id
     * @return
     */
    Root findRootById(Integer id);

    /**
     * 通过id删除指定管理员
     * @param id
     */
    void deleteRoot(Integer id);
}
