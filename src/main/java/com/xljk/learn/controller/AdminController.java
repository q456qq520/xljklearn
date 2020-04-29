package com.xljk.learn.controller;

import com.alibaba.fastjson.JSON;
import com.xljk.learn.entity.MAdmin;
import com.xljk.learn.entity.MArticle;
import com.xljk.learn.entity.MQuestion;
import com.xljk.learn.entity.MUser;
import com.xljk.learn.service.AdminService;
import com.xljk.learn.service.ArticleService;
import com.xljk.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login")
    public ModelAndView login(){
        return new ModelAndView("adminlogin");
    }

    @RequestMapping(value = "/index")
    public ModelAndView index(){
        return new ModelAndView("adminindex");
    }

    @RequestMapping(value = "/addline")
    public ModelAndView addline(){
        return new ModelAndView("form-line");
    }

    @RequestMapping(value = "/addjuan")
    public ModelAndView addjuan(){
        return new ModelAndView("addjuan");
    }

    @RequestMapping(value = "/tologin",method = RequestMethod.POST)
    @ResponseBody
    public String userLogin(MAdmin admin, HttpServletRequest request){
        boolean bool = adminService.adminLogin(admin);
        if(!bool){
            return "false";
        }
        MAdmin mAdmin = adminService.getAdminByName(admin);
        HttpSession session = request.getSession();
        session.setAttribute("admin",mAdmin);
        return "true";
    }

    @RequestMapping(value = "/addArticle")
    @ResponseBody
    @Transactional
    public String addArticle(MArticle mArticle, @RequestParam("headxiang") MultipartFile file, HttpServletRequest request){
        String type = request.getParameter("artiletype");
        if(type.equals("a")){
            //学生
            mArticle.setArticleType(0);
        }else if(type.equals("b")){
            //老师
            mArticle.setArticleType(1);
        }else {
            //家长
            mArticle.setArticleType(2);
        }

        if(file.isEmpty()){
            return "false";
        }
        String relativelyPath=System.getProperty("user.dir");
        String dataPath = "common/img/article/" +file.getOriginalFilename();
        File filepath = new File(relativelyPath+"/src/main/resources/static/"+dataPath);
        mArticle.setArticlePath(dataPath);
        try {
            file.transferTo(filepath);
            boolean rsadd = adminService.addArticle(mArticle);
            if(rsadd){
                return "true";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "false";
    }

    /**
     * 获取文章
     * @return
     */
    @RequestMapping(value = "/getArticle")
    @ResponseBody
    public String getArticle(){
        List<MArticle> mArticles = adminService.getAllArticle();
        return JSON.toJSONString(mArticles);
    }

    /**
     * 新增问题
     * @param question
     * @return
     */
    @RequestMapping(value = "/addQuestion")
    @ResponseBody
    public String addQuestion(MQuestion question, HttpServletRequest request){
        String artileid = request.getParameter("artileid");
        question.setArticleId(Integer.parseInt(artileid));
        String rightKey = request.getParameter("rightKey");
        question.setQuestionKey(rightKey);
        boolean bool = adminService.addQuestion(question);
        if(bool){
            return "true";
        }
        return "false";
    }


    /*进入查询文章页面*/
    @RequestMapping(value = "/allarticle")
    public ModelAndView allarticle(){
        return new ModelAndView("articleTable");
    }

    /*进入查询用户页面*/
    @RequestMapping(value = "/alluser")
    public ModelAndView alluser(){
        return new ModelAndView("userTable");
    }
    /*文章管理*/
    @RequestMapping(value = "/searchArticle")
    @ResponseBody
    public String searchArticle(){
        List<MArticle> list = articleService.getAllA();
        String json = JSON.toJSONString(list);
        return json;
    }
    @RequestMapping(value = "/deleteArticle")
    @ResponseBody
    public String deleteArticle( String id){
        int ids = Integer.parseInt(id);
        int result = articleService.deleteAr(ids);
        return "true";
    }
    /*用户管理*/
    @RequestMapping(value = "/searchUser")
    @ResponseBody
    public String searchUser(){
        List<MUser> list = userService.getAllU();
        String json = JSON.toJSONString(list);
        return json;
    }
    @RequestMapping(value = "/deleteUser")
    @ResponseBody
    public String deleteUser(String id){
        int ids = Integer.parseInt(id);
        int result = userService.deleteU(ids);
        System.out.println(result);
        return "true";
    }
}
