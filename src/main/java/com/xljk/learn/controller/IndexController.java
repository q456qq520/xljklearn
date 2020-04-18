package com.xljk.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/index")
public class IndexController  {

    @RequestMapping(value = "/index")
    public ModelAndView login(){
        return new ModelAndView("cici");
    }
}
