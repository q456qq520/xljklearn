package com.xljk.learn.dao;

import com.xljk.learn.entity.MAdmin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "mAdminMapper")
public interface MAdminMapper {
    int deleteByPrimaryKey(Integer adminId);

    int insert(MAdmin record);

    int insertSelective(MAdmin record);

    MAdmin selectByPrimaryKey(Integer adminId);

    int updateByPrimaryKeySelective(MAdmin record);

    int updateByPrimaryKey(MAdmin record);

    MAdmin getAdminByname(@Param("adminAccount")String adminAccount);
}