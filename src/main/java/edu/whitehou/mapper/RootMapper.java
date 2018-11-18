package edu.whitehou.mapper;

import edu.whitehou.entity.Root;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @author : white.hou
 * @description : 对管理员进行操作
 * @date: 2018/11/10_19:24
 */
@Repository
public interface RootMapper {
    /**
     * 通过用户账号（登录账号）查询用户Token
     * @param rootName
     */
    Root findRootTokenByRootName(String rootName);

    /**
     * 找出所有管理员
     *
     */
    Collection<Root>  findAllRoots();

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
     * 通过id查询管理员
     * @param id
     * @return
     */
    Root findRootById(Integer id);

    /**
     * 通过id删除管理员
     * @param id
     */
    void deleteRoot(Integer id);
}
