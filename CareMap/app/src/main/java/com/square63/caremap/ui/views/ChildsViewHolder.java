package com.square63.caremap.ui.views;

import android.view.View;
import android.widget.TextView;


import com.bignerdranch.expandablerecyclerview.ChildViewHolder;
import com.square63.caremap.R;
import com.square63.caremap.models.ProviderChildModel;


public class ChildsViewHolder extends ChildViewHolder {

  private TextView childTextView;

  public ChildsViewHolder(View itemView) {
    super(itemView);
   // childTextView = (TextView) itemView.findViewById(R.id.);
  }

  public void bind(ProviderChildModel providerChildModel)
  {
   // mIngredientTextView.setText(ingredient.getName());
  }
}
