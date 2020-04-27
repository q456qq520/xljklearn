package com.xljk.learn.controller;

import com.alibaba.fastjson.JSON;
import com.xljk.learn.entity.MArticle;
import com.xljk.learn.entity.MMessage;
import com.xljk.learn.entity.MQuestion;
import com.xljk.learn.entity.MUser;
import com.xljk.learn.service.ArticleService;
import com.xljk.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/index")
public class IndexController  {
    public static int ids;
    public static MUser user;
    @Autowired
    private UserService userService;
    @Autowired
    private ArticleService articleService;


    @RequestMapping(value = "/index")
    public ModelAndView login(){
        return new ModelAndView("cici");
    }
    @RequestMapping(value = "/detail")
    public ModelAndView detail(String id, HttpServletRequest request){
        HttpSession session = request.getSession();
        user = (MUser) session.getAttribute("user");
        ids = Integer.parseInt(id);
        return new ModelAndView("article");
    }
    /**
     * 详情界面数据显示
     *
     */
    @RequestMapping(value = "article")
    @ResponseBody
    public String article(){
        MArticle art = articleService.getAriDetail(ids);
        String json = JSON.toJSONString(art);
        return json;
    }


    @RequestMapping(value = "/exam")
    @ResponseBody
    public String exam(){
        List<MQuestion> list = articleService.selectAllQ(ids);
        String json = JSON.toJSONString(list);
        return json;
    }
    @RequestMapping(value = "/result")
    @ResponseBody
    public String result(){
        List<MQuestion> list = articleService.selectAllQ(ids);
        String json = list.get(0).getQuestionKey();
        return json;
    }


    @RequestMapping(value = "/comment")
    @ResponseBody
    public String comment(){
        List<MMessage> list = articleService.selectAllM(ids);
        System.out.println(list);
        String json = JSON.toJSONString(list);
        return json;
    }
    @RequestMapping(value = "/message",method = RequestMethod.POST)
    @ResponseBody
    public String message(String content){
        System.out.println(user);
        System.out.println(content);
        MMessage message = new MMessage();
        message.setUserId(user.getUserId());
        message.setMessageContent(content);
        message.setArticleId(ids);
        message.setMessageDate(new Date().toString());
        articleService.insertMessage(message);
        return "true";
    }
    /**
     * 主页数据显示
     * @return
     */

    @RequestMapping(value = "/teacher",method = RequestMethod.POST)
    @ResponseBody
    public String teacher(){
        List<MArticle> teacherList = articleService.getTeacherAri();
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
