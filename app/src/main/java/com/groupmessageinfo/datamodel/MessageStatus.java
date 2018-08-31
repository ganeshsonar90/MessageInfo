package com.groupmessageinfo.datamodel;

/**
 * Created by gboss on 30/08/18.
 */

public class MessageStatus {

  int userId;
  int status;
  String time;
  String userName;

  public MessageStatus(String userName,int userId, int status, String time) {
    this.userName=userName;
    this.userId = userId;
    this.status = status;
    this.time = time;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }
}
