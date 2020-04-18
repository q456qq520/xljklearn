package com.xljk.learn.dao;

import com.xljk.learn.entity.MUser;

public interface MUserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(MUser record);

    int insertSelective(MUser record);

    MUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(MUser record);

    int updateByPrimaryKey(MUser record);
}