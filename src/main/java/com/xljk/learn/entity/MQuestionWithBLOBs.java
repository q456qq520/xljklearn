package com.xljk.learn.entity;

public class MQuestionWithBLOBs extends MQuestion {
    private String questionTitle;

    private String questionA;

    private String questionB;

    private String questionC;

    private String questionD;

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle == null ? null : questionTitle.trim();
    }

    public String getQuestionA() {
        return questionA;
    }

    public void setQuestionA(String questionA) {
        this.questionA = questionA == null ? null : questionA.trim();
    }

    public String getQuestionB() {
        return questionB;
    }

    public void setQuestionB(String questionB) {
        this.questionB = questionB == null ? null : questionB.trim();
    }

    public String getQuestionC() {
        return questionC;
    }

    public void setQuestionC(String questionC) {
        this.questionC = questionC == null ? null : questionC.trim();
    }

    public String getQuestionD() {
        return questionD;
    }

    public void setQuestionD(String questionD) {
        this.questionD = questionD == null ? null : questionD.trim();
    }
}