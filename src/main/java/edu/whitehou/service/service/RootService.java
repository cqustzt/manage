package edu.whitehou.service.service;

import edu.whitehou.entity.Root;

public interface RootService {
    /**
     * 通过用户账号（登录账号）查询用户
     * @param rootName
     */
    Root findRootTokenByRootName(String rootName);
}
