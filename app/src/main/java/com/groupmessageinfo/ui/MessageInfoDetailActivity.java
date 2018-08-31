package com.groupmessageinfo.ui;

/**
 * Created by gboss on 30/08/18.
 */

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import com.groupmessageinfo.MessageNotifier;
import com.groupmessageinfo.R;
import com.groupmessageinfo.adapter.AdapterSectionRecycler;
import com.groupmessageinfo.datamodel.Child;
import com.groupmessageinfo.datamodel.MessageObject;
import com.groupmessageinfo.datamodel.MessageStatus;
import com.groupmessageinfo.datamodel.SectionHeader;
import com.groupmessageinfo.util.CommonFunctions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MessageInfoDetailActivity extends AppCompatActivity implements MessageNotifier {

  AdapterSectionRecycler mAdapterRecycler;
  List<SectionHeader> mSectionHeaders;
  private RecyclerView mRecyclerView;
  private TextView mMsgtxt, mTimeFrom;
  ImageView mMsgStatus;
  private MessageObject mMessageObj;
  ArrayList<MessageStatus> mMessageStatus;
  private int[] mRemainingCountArry;

  public enum MESSAGE_STAUS {
    SENDING(0),
    SENT(1),
    DELIVERED(2),
    READ(3);

    private final int value;

    MESSAGE_STAUS(final int newValue) {
      value = newValue;
    }

    public int getValue() {
      return value;
    }
  }


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_message_info_detail_layout);
    intializeView();
    loadStaticData();
    loadRecyclView();


  }

  @Override
  public void updateMessageStatus(int messageId, MessageStatus messageStatus) {

    if (mMessageObj != null) {

      if (mMessageObj.getMessageId() == messageId) {

        if (messageStatus != null && mMessageStatus != null && mMessageStatus.size() > 0) {

          Iterator<MessageStatus> statusIterator = mMessageStatus.iterator();
          while (statusIterator.hasNext()) {

            MessageStatus localMsgStatusObj = statusIterator.next();

            if (localMsgStatusObj != null) {

              if (messageStatus.getUserId() == localMsgStatusObj.getUserId()) {

                statusIterator.remove();

                mMessageStatus.add(messageStatus);

                loadRecyclView();

                break;
              }


            }


          }

        }


      }


    }

  }

  private void intializeView() {
    // Get Toolbar component.
    Toolbar toolbar = (Toolbar) findViewById(R.id.collapsing_toolbar);
    // Use Toolbar to replace default activity action bar.
    setSupportActionBar(toolbar);

    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      // Display home menu item.
      actionBar.setDisplayHomeAsUpEnabled(true);
    }

    //messge header

    mMsgtxt = (TextView) findViewById(R.id.txt_msg_from);

    mTimeFrom = (TextView) findViewById(R.id.txt_time_from);

    mMsgStatus = (ImageView) findViewById(R.id.img_msg_status);

    //initialize RecyclerView
    mRecyclerView = (RecyclerView) findViewById(R.id.collapsing_toolbar_recycler_view);

    //setLayout Manager
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
    mRecyclerView.setLayoutManager(linearLayoutManager);
    mRecyclerView.setHasFixedSize(true);
  }


  private void loadStaticData() {

    mMessageStatus = new ArrayList<>();

    MessageStatus mMessageStaus1 =
        new MessageStatus("Lalit", CommonFunctions.uniqueId(), MESSAGE_STAUS.READ.getValue(),
            "Just now");
    MessageStatus mMessageStaus2 =
        new MessageStatus("Mukesh", CommonFunctions.uniqueId(), MESSAGE_STAUS.SENT.getValue(),
            "1 minutes ago");
    MessageStatus mMessageStaus3 =
        new MessageStatus("Jitesh", CommonFunctions.uniqueId(), MESSAGE_STAUS.READ.getValue(),
            "Today 02:12 PM");
    MessageStatus mMessageStaus4 =
        new MessageStatus("Aniket", CommonFunctions.uniqueId(), MESSAGE_STAUS.READ.getValue(),
            "August 28, 9:15 AM");

    MessageStatus mMessageStaus5 =
        new MessageStatus("Rohit", CommonFunctions.uniqueId(), MESSAGE_STAUS.DELIVERED.getValue(),
            "5 minutes ago");
    MessageStatus mMessageStaus6 =
        new MessageStatus("Rehan", CommonFunctions.uniqueId(), MESSAGE_STAUS.SENDING.getValue(),
            "Just now");
    MessageStatus mMessageStaus7 =
        new MessageStatus("Romit", CommonFunctions.uniqueId(), MESSAGE_STAUS.SENT.getValue(),
            "Today 05:12 PM");
    MessageStatus mMessageStaus8 =
        new MessageStatus("Bharat", CommonFunctions.uniqueId(), MESSAGE_STAUS.DELIVERED.getValue(),
            "4 minutes ago");

    mMessageStatus.add(mMessageStaus1);
    mMessageStatus.add(mMessageStaus2);
    mMessageStatus.add(mMessageStaus3);
    mMessageStatus.add(mMessageStaus4);
    mMessageStatus.add(mMessageStaus5);
    mMessageStatus.add(mMessageStaus6);
    mMessageStatus.add(mMessageStaus7);
    mMessageStatus.add(mMessageStaus8);

    mMessageObj = new MessageObject(CommonFunctions.uniqueId(), "8:50 AM",
        getString(R.string.msg_txt), mMessageStatus, false);

    mMsgtxt.setText(mMessageObj.getMessageText());

    mTimeFrom.setText(mMessageObj.getMessageTime());

    if (mMessageObj.isSent()) {
      mMsgStatus.setImageResource(R.drawable.msg_read);
    } else {
      mMsgStatus.setImageResource(R.drawable.msg_delieverd);
    }

  }


  void loadRecyclView() {
    //Create a List of Child DataModel
    List<Child> readBychildList = new ArrayList<>();
    List<Child> deliveredTochildList = new ArrayList<>();

    mRemainingCountArry = CommonFunctions.calculateRemCount(mMessageStatus);
    int position = 1;
    Iterator<MessageStatus> statusIterator = mMessageStatus.iterator();
    while (statusIterator.hasNext()) {

      MessageStatus localMsgStatusObj = statusIterator.next();

      String remaingText = null;
      if (localMsgStatusObj != null) {

        if (localMsgStatusObj.getStatus() == MESSAGE_STAUS.READ.getValue()) {//read by

          remaingText = mRemainingCountArry[0] + " remaining";

          readBychildList
              .add(new Child(localMsgStatusObj.getUserName(), localMsgStatusObj.getTime(),
                  remaingText, "http://placehold.it/120x120&text=image" + position));


        } else if (localMsgStatusObj.getStatus() == MESSAGE_STAUS.DELIVERED
            .getValue()) {//delivered to
          remaingText = mRemainingCountArry[1] + " remaining";
          deliveredTochildList
              .add(
                  new Child(localMsgStatusObj.getUserName(), localMsgStatusObj.getTime(),
                      remaingText,
                      "http://placehold.it/120x120&text=image" + position));
        }

      }

      position++;
    }

//Create a List of SectionHeader DataModel implements SectionHeader
    mSectionHeaders = new ArrayList<>();
    mSectionHeaders
        .add(new SectionHeader(readBychildList, getString(R.string.header_tille_read_by), 6));

    mSectionHeaders
        .add(new SectionHeader(deliveredTochildList, getString(R.string.header_tille_delivered_to),
            2));

    mAdapterRecycler =
        new AdapterSectionRecycler(this, mSectionHeaders);

    mRecyclerView.setAdapter(mAdapterRecycler);
  }

}
