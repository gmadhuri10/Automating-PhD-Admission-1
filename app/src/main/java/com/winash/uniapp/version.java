package com.winash.uniapp;

public class version {

    public String que, con, ans, user;
    private boolean expandable;

    public boolean isExpandable() {
        return expandable;
    }

    public void setExpandable(boolean expandable) {
        this.expandable = expandable;
    }

    public version(String que, String con, String ans, String user) {
        this.que = que;
        this.con = con;
        this.ans = ans;
        this.user = user;
        this.expandable = false;
    }

    public String getQue() {
        return que;
    }

    public void setQue(String que) {
        this.que = que;
    }

    public String getCon() {
        return con;
    }

    public void setCon(String con) {
        this.con = con;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "version{" +
                "que='" + que + '\'' +
                ", con='" + con + '\'' +
                ", ans='" + ans + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}
