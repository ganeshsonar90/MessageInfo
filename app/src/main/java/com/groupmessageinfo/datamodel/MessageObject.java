package com.groupmessageinfo.datamodel;

import java.util.ArrayList;

/**
 * Created by gboss on 30/08/18.
 */

public class MessageObject {


  int messageId;
  String messageTime;
  String messageText;
  ArrayList<MessageStatus> messageStatus;
  boolean sent;

  public MessageObject(int messageId, String messageTime, String messageText,
      ArrayList<MessageStatus> messageStatus, boolean sent) {
    this.messageId = messageId;
    this.messageTime = messageTime;
    this.messageText = messageText;
    this.messageStatus = messageStatus;
    this.sent = sent;
  }

  public int getMessageId() {
    return messageId;
  }

  public void setMessageId(int messageId) {
    this.messageId = messageId;
  }

  public String getMessageTime() {
    return messageTime;
  }

  public void setMessageTime(String messageTime) {
    this.messageTime = messageTime;
  }

  public String getMessageText() {
    return messageText;
  }

  public void setMessageText(String messageText) {
    this.messageText = messageText;
  }

  public ArrayList<MessageStatus> getMessageStatus() {
    return messageStatus;
  }

  public void setMessageStatus(
      ArrayList<MessageStatus> messageStatus) {
    this.messageStatus = messageStatus;
  }

  public boolean isSent() {
    return sent;
  }

  public void setSent(boolean sent) {
    this.sent = sent;
  }
}
