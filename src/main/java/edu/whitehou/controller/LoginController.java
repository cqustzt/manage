package edu.whitehou.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author : white.hou
 * @description : 登录的controller 类
 * @date: 2018/11/10_21:06
 */
@Controller
public class LoginController {
    /**
     * 登录逻辑处理模块
     */
    @PostMapping("/login")
    public String login(@RequestParam("rootName") String rootName, @RequestParam("password") String password, Model model) {
        /**
         * Shiro便携认证操作：
         *   1 获取subject
         *   2 封装用户数据
         *   3 执行登录方法
         */
        org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(rootName, password);
        try {
            subject.login(usernamePasswordToken);
       /*      //界面优化的坑
            model.addAttribute("rootIdentity",usernamePasswordToken.getUsername());*/
            // 重定向
            return "redirect:/main.html";
        } catch (UnknownAccountException e) {
            /**
             * 登录失败:用户名不存在
             */
            model.addAttribute("msg", "用户名不存在，请校验后登录");
            return "/login";
        } catch (IncorrectCredentialsException e) {
            /**
             * 登录失败:密码错误
             */
            model.addAttribute("msg", "密码错误，请重新输入");
            return "/login";
        }
    }
    /**
     * 跳转控制模块
     */
    @RequestMapping("/tologin")
    public String tologin() {
        return "/login";
    }
    /**
     * 未授权页面
     *
     * @return
     */
    @RequestMapping("/noAuth")
    public String noAuth() {
        return "/noAuth";
    }
}
