package com.groupmessageinfo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.groupmessageinfo.R;
import com.groupmessageinfo.datamodel.Child;
import com.groupmessageinfo.datamodel.ChildViewHolder;
import com.groupmessageinfo.datamodel.SectionHeader;
import com.groupmessageinfo.datamodel.SectionViewHolder;


import com.groupmessageinfo.sectionedrecyclerview.SectionRecyclerViewAdapter;
import com.groupmessageinfo.ui.customView.CircleTransform;
import com.squareup.picasso.Picasso;
import java.util.List;


public class AdapterSectionRecycler extends
    SectionRecyclerViewAdapter<SectionHeader, Child, SectionViewHolder, ChildViewHolder> {

  private final List<SectionHeader> mSectionHeaderItemList;
  Context context;

  public AdapterSectionRecycler(Context context, List<SectionHeader> sectionHeaderItemList) {
    super(context, sectionHeaderItemList);
    this.context = context;
   this.mSectionHeaderItemList=sectionHeaderItemList;

  }

  @Override
  public SectionViewHolder onCreateSectionViewHolder(ViewGroup sectionViewGroup, int viewType) {
    View view = LayoutInflater.from(context)
        .inflate(R.layout.section_item, sectionViewGroup, false);
    return new SectionViewHolder(view);
  }

  @Override
  public ChildViewHolder onCreateChildViewHolder(ViewGroup childViewGroup, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.item_layout, childViewGroup, false);
    return new ChildViewHolder(view);
  }

  @Override
  public void onBindSectionViewHolder(SectionViewHolder sectionViewHolder, int sectionPosition,
      SectionHeader sectionHeader) {

    if (sectionHeader.sectionText != null) {
      sectionViewHolder.txtSectionHeader.setText(sectionHeader.sectionText);
    }

    if (sectionPosition == 0) { //read by
      sectionViewHolder.imgHeaderMsgStatus.setImageResource(R.drawable.msg_read);
    } else if (sectionPosition == 1) { //delivered to
      sectionViewHolder.imgHeaderMsgStatus.setImageResource(R.drawable.msg_delieverd);
    }

  }

  @Override
  public void onBindChildViewHolder(ChildViewHolder childViewHolder, int sectionPosition,
      int childPosition, Child child) {

    if (child.getName() != null) {
      childViewHolder.txtName.setText(child.getName());
    }

    if (child.getSeenTime() != null) {
      childViewHolder.txtSeenTime.setText(child.getSeenTime());
    }



    if (child.getUserImageurl() != null && !child.getUserImageurl().isEmpty()) {

      if (childPosition % 2 == 0) {
        Picasso.get().load(child.getUserImageurl()).transform(new CircleTransform())
            .placeholder(R.drawable.ic_profiledefaultimg)
            .into(childViewHolder.imgUser);
      } else if (childPosition % 3 == 0) {
        Picasso.get().load(R.drawable.ic_placeholder_profile).transform(new CircleTransform())
            .placeholder(R.drawable.ic_profiledefaultimg)
            .into(childViewHolder.imgUser);
      } else if (childPosition % 4 == 0) {
        Picasso.get().load(R.drawable.ic_people_working).transform(new CircleTransform())
            .placeholder(R.drawable.ic_profiledefaultimg)
            .into(childViewHolder.imgUser);
      } else {
        Picasso.get().load(R.drawable.ic_actors).transform(new CircleTransform())
            .placeholder(R.drawable.ic_profiledefaultimg)
            .into(childViewHolder.imgUser);
      }


    }


    SectionHeader sectionHeaderObj = mSectionHeaderItemList.get(sectionPosition);

    if (sectionHeaderObj.getChildItems()!=null
        &&(sectionHeaderObj.getChildItems().size()-1)==childPosition){
      childViewHolder.txtRemaining.setVisibility(View.VISIBLE);
      childViewHolder.txtRemaining.setText(child.getRemainingUser());
    }else {
      childViewHolder.txtRemaining.setVisibility(View.GONE);
    }


  }
}
