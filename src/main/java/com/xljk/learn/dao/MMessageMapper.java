package com.xljk.learn.dao;

import com.xljk.learn.entity.MMessage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component(value = "mMessageMapper")
public interface MMessageMapper {
    int deleteByPrimaryKey(Integer messageId);

    int insert(MMessage record);

    int insertSelective(MMessage record);

    MMessage selectByPrimaryKey(Integer messageId);

    int updateByPrimaryKeySelective(MMessage record);

    int updateByPrimaryKeyWithBLOBs(MMessage record);

    int updateByPrimaryKey(MMessage record);

    /**
     * 所有留言
     */
    List<MMessage> selectAllM(Integer id);
}