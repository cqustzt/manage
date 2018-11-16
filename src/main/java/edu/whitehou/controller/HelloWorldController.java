package edu.whitehou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : white.hou
 * @description : hello world
 * @date: 2018/11/10_18:43
 */
@Controller
public class HelloWorldController {
    /**
     * 测试Hello World
     */
    @ResponseBody
    @RequestMapping("/helloworld")
    public String hello(){
        return "Hello World";
    }
}
