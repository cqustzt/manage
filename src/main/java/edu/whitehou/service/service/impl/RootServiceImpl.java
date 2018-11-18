package edu.whitehou.service.service.impl;

import edu.whitehou.entity.Root;
import edu.whitehou.mapper.RootMapper;
import edu.whitehou.service.service.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

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

    @Override
    public Collection<Root> findAllRoots() {
        return rootMapper.findAllRoots();
    }

    @Override
    public void addRoot(Root root) {
        rootMapper.addRoot(root);
    }

    @Override
    public void updateRoot(Root root) {
        rootMapper.updateRoot(root);
    }

    @Override
    public Root findRootById(Integer id) {
        return rootMapper.findRootById(id);
    }

    @Override
    public void deleteRoot(Integer id) {
        rootMapper.deleteRoot(id);
    }
}
