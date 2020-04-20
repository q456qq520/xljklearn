package com.xljk.learn.dao;

import com.xljk.learn.entity.MQuestion;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "mQuestionMapper")
public interface MQuestionMapper {
    int deleteByPrimaryKey(Integer questionId);

    int insert(MQuestion record);

    int insertSelective(MQuestion record);

    MQuestion selectByPrimaryKey(Integer questionId);

    int updateByPrimaryKeySelective(MQuestion record);

    int updateByPrimaryKey(MQuestion record);
}