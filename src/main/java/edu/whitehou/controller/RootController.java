package edu.whitehou.controller;

import edu.whitehou.entity.Root;
import edu.whitehou.service.service.RootService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author : white.hou
 * @description : 超级管理员管理所有管理员
 * @date: 2018/11/16_12:20
 */
@Controller
public class RootController {
    @Autowired
    private RootService rootService;

    /**
     * 查询所有管理员给前端页面
     * @param model
     * @return
     */
    @GetMapping("/roots")
    public String rootList(Model model){
        Collection<Root> allRoot = rootService.findAllRoots();
        model.addAttribute("roots",allRoot);
        System.out.println(model);
        return "root/list";
    }

    /**
     * 跳转到添加页面
     * @return
     */
    @GetMapping("/root")
    public String toAddRoot(){
        return "root/add";
    }

    /**
     * 增加管理员
     * @return
     */
    @PostMapping("/root")
    public String addRoot(Root root){
        try{
            rootService.addRoot(root);
        }catch (Exception e){
            Logger logger=LoggerFactory.getLogger(getClass());
            logger.warn("请检查您的输入");
            e.printStackTrace();
        }
        return  "redirect:/roots";
    }

    /**
     * 跳转到编辑页面，编辑添加二合一
     * @param id
     * @return
     */
    @GetMapping("/root/{id}")
    public String toEdit(@PathVariable("id") Integer id,Model model){
        Root rootById = rootService.findRootById(id);
        model.addAttribute("root",rootById);
        return "root/add";
    }

    /**
     * 修改管理员信息
     * @param root
     * @return
     */
    @PutMapping("/root")
    public String updateRoot(Root root){
        try {
            rootService.updateRoot(root);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  "redirect:/roots";
    }

    /**
     * 删除指定员工
     * @param id
     * @return
     */
    @DeleteMapping("/root/{id}")
    public String deleteRoot(@PathVariable("id") Integer id){
        rootService.deleteRoot(id);
        return "redirect:/roots";
    }
}
