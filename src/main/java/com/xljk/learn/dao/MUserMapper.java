package com.xljk.learn.dao;

import com.xljk.learn.entity.MUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "mUserMapper")
public interface MUserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(MUser record);

    int insertSelective(MUser record);

    MUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(MUser record);

    int updateByPrimaryKey(MUser record);

    MUser getUserbyUsername(@Param("userAccount")String userAccount);
}