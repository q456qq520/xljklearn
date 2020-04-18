package com.xljk.learn.entity;

import java.io.Serializable;

public class MUser implements Serializable {
    private Integer userId;

    private String userAccount;

    private String userPassword;

    private String userName;

    private String userPhone;

    private String userEmail;

    private String userHeadpath;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getUserHeadpath() {
        return userHeadpath;
    }

    public void setUserHeadpath(String userHeadpath) {
        this.userHeadpath = userHeadpath == null ? null : userHeadpath.trim();
    }

    @Override
    public String toString() {
        return "MUser{" +
                "userId=" + userId +
                ", userAccount='" + userAccount + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userHeadpath='" + userHeadpath + '\'' +
                '}';
    }
}