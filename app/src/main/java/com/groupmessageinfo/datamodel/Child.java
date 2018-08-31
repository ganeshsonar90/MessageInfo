package com.groupmessageinfo.datamodel;


public class Child {

    String name;
    String seenTime;
    String remainingUser;
    String userImageurl;

    public Child(String name,String seenTime,String remainingUser,String userImageurl) {
        this.name = name;
        this.seenTime = seenTime;
        this.remainingUser = remainingUser;
        this.userImageurl = userImageurl;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeenTime() {
        return seenTime;
    }

    public void setSeenTime(String seenTime) {
        this.seenTime = seenTime;
    }

    public String getRemainingUser() {
        return remainingUser;
    }

    public void setRemainingUser(String remainingUser) {
        this.remainingUser = remainingUser;
    }

    public String getUserImageurl() {
        return userImageurl;
    }

    public void setUserImageurl(String userImageurl) {
        this.userImageurl = userImageurl;
    }
}