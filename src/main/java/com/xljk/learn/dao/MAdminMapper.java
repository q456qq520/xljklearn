package com.xljk.learn.dao;

import com.xljk.learn.entity.MAdmin;

public interface MAdminMapper {
    int deleteByPrimaryKey(Integer adminId);

    int insert(MAdmin record);

    int insertSelective(MAdmin record);

    MAdmin selectByPrimaryKey(Integer adminId);

    int updateByPrimaryKeySelective(MAdmin record);

    int updateByPrimaryKey(MAdmin record);
}