package com.xljk.learn.dao;

import com.xljk.learn.entity.MArticle;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

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

    /**
     * 查询老师类问题
     * @return
     */
    List<MArticle> selectTeacherAri();

    /**
     * 查询学生类问题
     * @return
     */
    List<MArticle> selectStudentAri();

    /**
     * 查询家长类问题
     * @return
     */
    List<MArticle> selectParentAri();

    /**
     * 获取全部文章
     * @return
     */
    List<MArticle>  getAll();
}