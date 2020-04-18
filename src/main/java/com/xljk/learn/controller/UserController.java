package com.xljk.learn.controller;

import com.alibaba.fastjson.JSON;
import com.xljk.learn.entity.MUser;
import com.xljk.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/tologin",method = RequestMethod.POST)
    @ResponseBody
    public String userLogin(MUser user, HttpServletRequest request){
        boolean bool = userService.userLogin(user);
        if(!bool){
            return "false";
        }
        MUser mUser = userService.getUserByUsername(user);
        HttpSession session = request.getSession();
        session.setAttribute("user",mUser);
        return "true";
    }

    @RequestMapping(value = "/toregist",method = RequestMethod.POST)
    @ResponseBody
    public String userRegist(MUser user, HttpServletRequest request){
        MUser ckeck = userService.getUserByUsername(user);
        if(ckeck!=null){
            return "false";
        }
        userService.userRegist(user);
        return "true";
    }
}
