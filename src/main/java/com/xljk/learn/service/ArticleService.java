package com.xljk.learn.service;

import com.xljk.learn.dao.MArticleMapper;
import com.xljk.learn.dao.MMessageMapper;
import com.xljk.learn.dao.MQuestionMapper;
import com.xljk.learn.dao.MUserMapper;
import com.xljk.learn.entity.MArticle;
import com.xljk.learn.entity.MMessage;
import com.xljk.learn.entity.MQuestion;
import com.xljk.learn.entity.MUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private MArticleMapper mArticleMapper;
    @Autowired
    private MMessageMapper mMessageMapper;
    @Autowired
    private MUserMapper mUserMapper;
    @Autowired
    private MQuestionMapper mQuestionMapper;

    public List<MArticle> getTeacherAri() { return mArticleMapper.selectTeacherAri();}

    public List<MArticle> getStudentAri() { return mArticleMapper.selectStudentAri();}

    public List<MArticle> getParentAri() { return mArticleMapper.selectParentAri();}

    public MArticle getAriDetail(int id){ return mArticleMapper.selectByPrimaryKey(id);}

    public List<MMessage> selectAllM(int id){
        List<MMessage> list = mMessageMapper.selectAllM(id);
        for (MMessage message:list) {
            MUser user = mUserMapper.selectByPrimaryKey(message.getUserId());
            message.setUser(user);
        }
        return list;
    }
    public int insertMessage(MMessage message) {
        int result = mMessageMapper.insert(message);
        return result;
    }

    public List<MQuestion> selectAllQ(int id) {
        return mQuestionMapper.selectAllByAid(id);
    }
}
