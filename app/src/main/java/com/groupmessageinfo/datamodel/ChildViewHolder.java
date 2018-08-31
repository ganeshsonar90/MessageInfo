package com.groupmessageinfo.datamodel;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.groupmessageinfo.R;


public class ChildViewHolder extends RecyclerView.ViewHolder {

  public TextView txtName, txtSeenTime, txtRemaining;
  public ImageView imgUser;

  public ChildViewHolder(View itemView) {
    super(itemView);

    txtName = (TextView) itemView.findViewById(R.id.txt_user_name);
    txtSeenTime = (TextView) itemView.findViewById(R.id.txt_seen_time);
    txtRemaining = (TextView) itemView.findViewById(R.id.txt_remaining);
    imgUser = (ImageView) itemView.findViewById(R.id.img_user);
  }
}
