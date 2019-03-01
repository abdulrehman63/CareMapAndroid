package com.square63.caremap.ui.views;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.bignerdranch.expandablerecyclerview.ChildViewHolder;
import com.square63.caremap.R;
import com.square63.caremap.models.ProviderChildModel;


public class ChildsViewHolder extends ChildViewHolder {

  private TextView childTextView;
  public View adapter_divider_top;
  public LinearLayout lnrProfile,lnrMessage;
  public ChildsViewHolder(View itemView) {
    super(itemView);
    adapter_divider_top = (View) itemView.findViewById(R.id.adapter_divider_top);
    lnrProfile = (LinearLayout) itemView.findViewById(R.id.lnrProfile);
    lnrMessage = (LinearLayout) itemView.findViewById(R.id.lnrMessage);
   // childTextView = (TextView) itemView.findViewById(R.id.);
  }

  public void bind(ProviderChildModel providerChildModel)
  {
    if(providerChildModel.isExpanded()){
      adapter_divider_top.setVisibility(View.VISIBLE);
    }else {
      adapter_divider_top.setVisibility(View.GONE);
    }


   /* if(providerChildModel.isExpanded()){
      adapter_divider_top.setVisibility(View.GONE);
    }else {
      adapter_divider_top.setVisibility(View.VISIBLE);
    }*/
   // mIngredientTextView.setText(ingredient.getName());
  }
}
