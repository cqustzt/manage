package edu.whitehou.controller;

import edu.whitehou.entity.User;
import edu.whitehou.service.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author : white.hou
 * @description : 管理员对用户的管理模块
 * @date: 2018/11/12_15:43
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 返回所有员工
     */
    @GetMapping("/users")
    public String list(Model model){
        Collection<User> allUsers =userService.findAllUsers();
        model.addAttribute("users",allUsers);
        return "user/list";
    }

    /**
     * 跳转到添加页面
     * @return
     */
    @GetMapping("/user")
    public String toAddUser(){
        return "user/add";
    }

    /**
     * 添加新用户
     * @param user
     * @return
     */
    @PostMapping("/user")
    public String addUser(User user){
        try{
            userService.addUser(user);
        }catch (Exception e){
            Logger logger=LoggerFactory.getLogger(getClass());
            logger.warn("请检查您的输入");
            e.printStackTrace();
        }
        return  "redirect:/users";
    }

    /**
     * 跳转到编辑页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/user/{id}")
    public String toEditUser(@PathVariable("id") Integer id, Model model){
        User userById = userService.findUserById(id);
        model.addAttribute("user",userById);
        return "user/add";
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    @PutMapping("/user")
    public String updateUser(User user){
        try {
            userService.updateUser(user);
        }catch (Exception e){
            Logger logger=LoggerFactory.getLogger(getClass());
            logger.warn("您尚未完成修改动作，请重新修改");
            e.printStackTrace();
        }
        return "redirect:/users";
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        userService.deleteUserById(id);
        return "redirect:/users";
    }
}
