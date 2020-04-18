package com.xljk.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/tologin",method = RequestMethod.POST)
    public void userLogin(
                           HttpServletRequest request, HttpServletResponse response){
        System.out.println("eee");
    }
}
