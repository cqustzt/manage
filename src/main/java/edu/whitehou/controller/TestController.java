package edu.whitehou.controller;

import edu.whitehou.entity.User;
import edu.whitehou.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    UserService userService;
    @GetMapping("/use/{id}")
    public User userById(@PathVariable("id") Integer id){
        User userById = userService.findUserById(id);

        return userById;

    }

}
