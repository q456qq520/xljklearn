package com.xljk.learn.service;

import com.xljk.learn.dao.MUserMapper;
import com.xljk.learn.entity.MUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private MUserMapper mUserMapper;

    public  MUser getUser(int id){
        return mUserMapper.selectByPrimaryKey(id);
    }

    public  MUser getUserByUsername(MUser mUser){
        return mUserMapper.getUserbyUsername(mUser.getUserAccount());
    }

    public boolean userLogin(MUser mUser){
        MUser rsUser =  mUserMapper.getUserbyUsername(mUser.getUserAccount());
        if(rsUser==null) {return false;}
        if(!rsUser.getUserAccount().equals(mUser.getUserAccount()) ||
        !rsUser.getUserPassword().equals(mUser.getUserPassword())){
            return false;
        }
        return true;
    }

    public void userRegist(MUser mUser){
        mUserMapper.insertSelective(mUser);
    }
}
