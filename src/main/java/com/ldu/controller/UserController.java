package com.ldu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.ldu.pojo.User;
import com.ldu.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/register")
    public String register() {
        return "user/register";
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.GET)
    public String addUser(@ModelAttribute("user") User user1) {
        //检测该用户是否已经存在
        User user=userService.getUserByUserName(user1.getUsername());
        if(user==null) {
            return "redirect:user/register";
        }
        return "redirect:user/login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login() {
        return "user/login";
    }

    @RequestMapping(value = "/loginValidate",method = RequestMethod.POST)
    public String loginValidate(@RequestParam("username") String username,@RequestParam("password") String password,HttpSession httpSession) {
        if(username==null || password==null)
            return "user/login";
        else {
            User user = userService.getUserByUserName(username);
            if(user.getPassword().equals(password)) {
                httpSession.setAttribute("username", username);
                return "redirect:/stu/student/stuList";
            } else  {
                return "user/login";
            }
        }
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession httpSession) {
        httpSession.removeAttribute("username");
        return "redirect:/user/login";
    }

}