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

    public View adapter_divider_top, adapter_divider_bottom;
    public TextView txtName, txtDesc;

    public GroupsViewHolder(View itemView) {

        super(itemView);
        adapter_divider_top = (View) itemView.findViewById(R.id.adapter_divider_top);
        adapter_divider_bottom = (View) itemView.findViewById(R.id.adapter_divider_bottom);
        txtName = (TextView) itemView.findViewById(R.id.textView16);
        txtDesc = (TextView) itemView.findViewById(R.id.textView17);
   /* genreName = (TextView) itemView.findViewById(R.id.list_item_genre_name);
    arrow = (ImageView) itemView.findViewById(R.id.list_item_genre_arrow);
    icon = (ImageView) itemView.findViewById(R.id.list_item_genre_icon);*/
    }


    public void bind(ProviderGroupModel providerGroupModel) {
        txtName.setText(providerGroupModel.getName());
        txtDesc.setText(providerGroupModel.getDesc());
        if (providerGroupModel.isExpanded()) {

            adapter_divider_top.setVisibility(View.GONE);
            adapter_divider_bottom.setVisibility(View.VISIBLE);
        } else {
            adapter_divider_top.setVisibility(View.VISIBLE);
            adapter_divider_bottom.setVisibility(View.GONE);
        }
        //mRecipeTextView.setText(recipe.getName());
    }
}
