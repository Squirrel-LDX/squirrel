package com.ldu.controller;

import com.ldu.util.MD5;
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

    /**
     * 用户注册
     * @param user1
     * @return
     */
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user1) {
        //对密码进行MD5加密
        String str = MD5.md5(user1.getPassword());
        System.out.println(str);
        User user=userService.getUserByPhone(user1.getPhone());
        if(user==null) {//检测该用户是否已经注册
            user1.setPassword(str);
            userService.addUser(user1);
            return "redirect:/";
        }
        return "redirect:/";
    }

    /**
     * 登录验证
     * @param phone
     * @param password
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/loginValidate")
    public String loginValidate(@RequestParam("phone") String phone,@RequestParam("password") String password,HttpSession httpSession) {
        System.out.println("loginValidate");
        User user = userService.getUserByPhone(phone);
        if(user == null)
            return "redirect:/";
        if(user != null) {
            String pwd = MD5.md5(password);
            if(pwd.equals(user.getPassword())) {
                httpSession.setAttribute("user",user);
                return "redirect:/";
            }
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession httpSession) {
        httpSession.removeAttribute("user");
        return "redirect:/";
    }

}