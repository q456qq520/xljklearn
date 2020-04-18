package com.xljk.learn.dao;

import com.xljk.learn.entity.MQuestion;
import com.xljk.learn.entity.MQuestionWithBLOBs;

public interface MQuestionMapper {
    int deleteByPrimaryKey(Integer questionId);

    int insert(MQuestionWithBLOBs record);

    int insertSelective(MQuestionWithBLOBs record);

    MQuestionWithBLOBs selectByPrimaryKey(Integer questionId);

    int updateByPrimaryKeySelective(MQuestionWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(MQuestionWithBLOBs record);

    int updateByPrimaryKey(MQuestion record);
}