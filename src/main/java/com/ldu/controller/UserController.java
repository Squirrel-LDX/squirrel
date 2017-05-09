package com.ldu.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.ldu.pojo.User;
import com.ldu.service.UserService;
import com.ldu.util.MD5;


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
     * 验证登录
     * @param request
     * @param user
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/login")
    public ModelAndView loginValidate(HttpServletRequest request,User user,ModelMap modelMap) {
        User cur_user = userService.getUserByPhone(user.getPhone());
        if(cur_user == null)
            return new ModelAndView(new RedirectView("/"));
        if(cur_user != null) {
            String pwd = MD5.md5(user.getPassword());
            if(pwd.equals(cur_user.getPassword())) {
                request.getSession().setAttribute("cur_user",cur_user);
                return new ModelAndView("redirect:/");
            }
        }
        return new ModelAndView("redirect:/");
    }
    @RequestMapping(value = "/changeName")
    public ModelAndView changeName(HttpServletRequest request,User user,ModelMap modelMap) {
        //从session中获取出当前用户
        User cur_user = (User)request.getSession().getAttribute("cur_user");
        cur_user.setUsername(user.getUsername());//更改当前用户的用户名
        userService.updateUserName(cur_user);//执行修改操作
        request.getSession().setAttribute("cur_user",cur_user);//修改session值
        return new ModelAndView("redirect:/");
    }
    /**
     * 用户退出
     * @param request
     * @return
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().setAttribute("cur_user",null);
        return "redirect:/";
    }

}