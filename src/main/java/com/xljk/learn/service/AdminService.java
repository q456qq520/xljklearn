package com.xljk.learn.service;

import com.xljk.learn.dao.MAdminMapper;
import com.xljk.learn.dao.MArticleMapper;
import com.xljk.learn.entity.MAdmin;
import com.xljk.learn.entity.MArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 管理员业务层
 */
@Service
public class AdminService {
    @Autowired
    private MAdminMapper mAdminMapper;

    @Autowired
    private MArticleMapper mArticleMapper;
    /**
     * 根据id获取管理员
     * @param id
     * @return
     */
    public MAdmin getAdmin(int id){
        return mAdminMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据账号获取管理员
     * @param admin
     * @return
     */
    public  MAdmin getAdminByName(MAdmin admin){
        return mAdminMapper.getAdminByname(admin.getAdminAccount());
    }

    /**
     * 管理员登录
     * @param admin
     * @return
     */
    public boolean adminLogin(MAdmin admin){
        MAdmin rsAdmin =  mAdminMapper.getAdminByname(admin.getAdminAccount());
        if(rsAdmin==null) {return false;}
        if(!rsAdmin.getAdminAccount().equals(admin.getAdminAccount()) ||
                !rsAdmin.getAdminPassword().equals(admin.getAdminPassword())){
            return false;
        }
        return true;
    }

    /**
     * 新增文章
     * @param mArticle
     * @return
     */
    public boolean addArticle(MArticle mArticle){
        mArticleMapper.insertSelective(mArticle);
        return true;
    }
}
