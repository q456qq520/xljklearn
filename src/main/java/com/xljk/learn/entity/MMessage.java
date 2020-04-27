package com.xljk.learn.entity;

import java.lang.invoke.MutableCallSite;

public class MMessage {
    private Integer messageId;

    private Integer userId;

    private MUser user;

    private Integer articleId;

    private String messageDate;

    private String messageContent;

    public MUser getUser() {return user; }

    public void setUser(MUser user) {this.user = user; }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(String messageDate) {
        this.messageDate = messageDate == null ? null : messageDate.trim();
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent == null ? null : messageContent.trim();
    }
}