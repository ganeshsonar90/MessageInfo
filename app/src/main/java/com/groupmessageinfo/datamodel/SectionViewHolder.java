package com.groupmessageinfo.datamodel;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.groupmessageinfo.R;


public class SectionViewHolder extends RecyclerView.ViewHolder {

  public TextView txtSectionHeader;
  public ImageView imgHeaderMsgStatus;

  public SectionViewHolder(View itemView) {
    super(itemView);
    txtSectionHeader = (TextView) itemView.findViewById(R.id.sectionHeader);
    imgHeaderMsgStatus = (ImageView) itemView.findViewById(R.id.img_header_msg_status);

  }
}
