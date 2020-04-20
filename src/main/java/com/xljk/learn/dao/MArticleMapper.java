package com.xljk.learn.dao;

import com.xljk.learn.entity.MArticle;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "mArticleMapper")
public interface MArticleMapper {
    int deleteByPrimaryKey(Integer articleId);

    int insert(MArticle record);

    int insertSelective(MArticle record);

    MArticle selectByPrimaryKey(Integer articleId);

    int updateByPrimaryKeySelective(MArticle record);

    int updateByPrimaryKeyWithBLOBs(MArticle record);

    int updateByPrimaryKey(MArticle record);
}