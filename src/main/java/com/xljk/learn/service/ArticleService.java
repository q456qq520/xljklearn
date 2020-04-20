package com.xljk.learn.service;

import com.xljk.learn.dao.MArticleMapper;
import com.xljk.learn.entity.MArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private MArticleMapper mArticleMapper;

    public List<MArticle> getTeacherAri() { return mArticleMapper.selectTeacherAri();}

    public List<MArticle> getStudentAri() { return mArticleMapper.selectStudentAri();}

    public List<MArticle> getParentAri() { return mArticleMapper.selectParentAri();}
}
