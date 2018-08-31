package com.groupmessageinfo;

import com.groupmessageinfo.datamodel.MessageStatus;

public interface MessageNotifier {

  void updateMessageStatus (int messageId, MessageStatus messageStatus);

}
