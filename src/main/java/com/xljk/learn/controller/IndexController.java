package com.xljk.learn.controller;

import com.alibaba.fastjson.JSON;
import com.xljk.learn.entity.MArticle;
import com.xljk.learn.service.ArticleService;
import com.xljk.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/index")
public class IndexController  {
    @Autowired
    private UserService userService;
    @Autowired
    private ArticleService articleService;


    @RequestMapping(value = "/index")
    public ModelAndView login(){
        return new ModelAndView("cici");
    }
    /**
     * 主页数据显示
     * @return
     */
    //
    //
    @RequestMapping(value = "/teacher",method = RequestMethod.POST)
    @ResponseBody
    public String teacher(){
        List<MArticle> teacherList = articleService.getTeacherAri();
        System.out.println(teacherList);
        String teacherJson = JSON.toJSONString(teacherList);
        return teacherJson;
    }
    @RequestMapping(value = "/student",method = RequestMethod.POST)
    @ResponseBody
    public String student(){
        List<MArticle> studentList = articleService.getStudentAri();
        String studentJson = JSON.toJSONString(studentList);
        return studentJson;
    }
    @RequestMapping(value = "/parent",method = RequestMethod.POST)
    @ResponseBody
    public String parent(){
        List<MArticle> parentList = articleService.getParentAri();
        String parentJson = JSON.toJSONString(parentList);
        return parentJson;
    }
}
