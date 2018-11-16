package edu.whitehou.service.service.impl;

import edu.whitehou.entity.Root;
import edu.whitehou.mapper.RootMapper;
import edu.whitehou.service.service.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/** 
 * @author : white.hou
 * @description : 
 * @date: 2018/11/10_23:03
 */
@Service
public class RootServiceImpl implements RootService {
    @Autowired
    private RootMapper rootMapper;
    @Override
    public Root findRootTokenByRootName(String rootName) {
        return rootMapper.findRootTokenByRootName(rootName);
    }
}
