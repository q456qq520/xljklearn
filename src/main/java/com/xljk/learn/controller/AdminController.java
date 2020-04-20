package com.xljk.learn.controller;

import com.xljk.learn.entity.MAdmin;
import com.xljk.learn.entity.MArticle;
import com.xljk.learn.entity.MUser;
import com.xljk.learn.service.AdminService;
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

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

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
}
