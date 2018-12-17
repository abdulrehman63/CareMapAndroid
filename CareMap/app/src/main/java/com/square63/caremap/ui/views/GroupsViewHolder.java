package com.square63.caremap.ui.views;

import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ParentViewHolder;
import com.square63.caremap.R;
import com.square63.caremap.models.ProviderGroupModel;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import static android.view.animation.Animation.RELATIVE_TO_SELF;

public class GroupsViewHolder extends ParentViewHolder {


  public GroupsViewHolder(View itemView) {
    super(itemView);
   /* genreName = (TextView) itemView.findViewById(R.id.list_item_genre_name);
    arrow = (ImageView) itemView.findViewById(R.id.list_item_genre_arrow);
    icon = (ImageView) itemView.findViewById(R.id.list_item_genre_icon);*/
  }




  public void bind(ProviderGroupModel providerGroupModel) {
    //mRecipeTextView.setText(recipe.getName());
  }
}
