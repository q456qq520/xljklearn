package com.xljk.learn.dao;

import com.xljk.learn.entity.MMessage;

public interface MMessageMapper {
    int deleteByPrimaryKey(Integer messageId);

    int insert(MMessage record);

    int insertSelective(MMessage record);

    MMessage selectByPrimaryKey(Integer messageId);

    int updateByPrimaryKeySelective(MMessage record);

    int updateByPrimaryKeyWithBLOBs(MMessage record);

    int updateByPrimaryKey(MMessage record);
}