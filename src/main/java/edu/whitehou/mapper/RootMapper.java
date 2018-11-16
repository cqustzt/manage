package edu.whitehou.mapper;

import edu.whitehou.entity.Root;
import org.springframework.stereotype.Repository;

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
}
