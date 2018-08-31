package com.groupmessageinfo.util;

import com.groupmessageinfo.datamodel.MessageStatus;
import com.groupmessageinfo.ui.MessageInfoDetailActivity.MESSAGE_STAUS;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class CommonFunctions {

  public static int uniqueId() {
    int uniId = new AtomicInteger().incrementAndGet();
    return uniId;
  }

  public static int[] calculateRemCount(ArrayList<MessageStatus> mMessageStatus) {

    int[] reaminingCountArray = new int[2];

    int readByRemaingCount = 0;
    int deliveredToRemainingCount = 0;
    int readByCount = 0;
    int deliveredCount = 0;

    int totalCount = mMessageStatus.size();

    for (MessageStatus localMsgStatusObj : mMessageStatus) {

      if (localMsgStatusObj != null) {
        if (localMsgStatusObj.getStatus() == MESSAGE_STAUS.READ.getValue()) {
          readByCount++;

        } else if (localMsgStatusObj.getStatus() == MESSAGE_STAUS.DELIVERED.getValue()) {
          deliveredCount++;

        }
      }

    }

    readByRemaingCount = totalCount - readByCount;

    reaminingCountArray[0] = readByRemaingCount;

    deliveredToRemainingCount = (totalCount - readByCount)-deliveredCount;

    reaminingCountArray[1] = deliveredToRemainingCount;

    return reaminingCountArray;

  }

}
