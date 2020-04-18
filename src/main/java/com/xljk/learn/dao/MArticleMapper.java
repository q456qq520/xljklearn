package com.xljk.learn.dao;

import com.xljk.learn.entity.MArticle;

public interface MArticleMapper {
    int deleteByPrimaryKey(Integer articleId);

    int insert(MArticle record);

    int insertSelective(MArticle record);

    MArticle selectByPrimaryKey(Integer articleId);

    int updateByPrimaryKeySelective(MArticle record);

    int updateByPrimaryKeyWithBLOBs(MArticle record);

    int updateByPrimaryKey(MArticle record);
}