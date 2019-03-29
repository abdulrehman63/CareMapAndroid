package com.square63.caremap.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.square63.caremap.R;
import com.square63.caremap.constants.Constants;
import com.square63.caremap.models.ProviderChildModel;
import com.square63.caremap.models.ProviderGroupModel;
import com.square63.caremap.ui.ChatActivity;
import com.square63.caremap.ui.SeekerProfileActivity;
import com.square63.caremap.ui.seekerModule.SeniorProfileActivity;
import com.square63.caremap.ui.views.ChildsViewHolder;
import com.square63.caremap.ui.views.GroupsViewHolder;
import com.square63.caremap.utils.PreferenceHelper;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;



public class MarketPlaceAdapter extends ExpandableRecyclerAdapter<ProviderGroupModel, ProviderChildModel, GroupsViewHolder, ChildsViewHolder> {

    private LayoutInflater mInflater;
    private Context context;

    public MarketPlaceAdapter(Context context, @NonNull List<ProviderGroupModel> recipeList) {
        super(recipeList);
        mInflater = LayoutInflater.from(context);
        this.context = context;
    }

    // onCreate ...
    @Override
    public GroupsViewHolder onCreateParentViewHolder(@NonNull ViewGroup parentViewGroup, int viewType) {
        View recipeView = mInflater.inflate(R.layout.list_item_provider_group, parentViewGroup, false);
        return new GroupsViewHolder(recipeView);
    }

    @Override
    public ChildsViewHolder onCreateChildViewHolder(@NonNull ViewGroup childViewGroup, int viewType) {
        View ingredientView = mInflater.inflate(R.layout.list_item_child_provider, childViewGroup, false);
        return new ChildsViewHolder(ingredientView);
    }

    // onBind ...
    @Override
    public void onBindParentViewHolder(@NonNull GroupsViewHolder recipeViewHolder, int parentPosition, @NonNull ProviderGroupModel recipe) {
        recipeViewHolder.bind(recipe);
        Glide.with(context)
                .load(Constants.BASE_IMAGE_URL_SENIOR + recipe.getId() + ".png")
                .placeholder(R.drawable.profile_default)
                .into(recipeViewHolder.imgProfile);
    }

    @Override
    public void onBindChildViewHolder(@NonNull ChildsViewHolder ingredientViewHolder, int parentPosition, int childPosition, @NonNull final  ProviderChildModel ingredient) {
        ingredientViewHolder.bind(ingredient);
        ingredientViewHolder.lnrMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ChatActivity.class);
                intent.putExtra(Constants.ID,ingredient.getSeekerId());
                intent.putExtra(Constants.PREF_NAMES,ingredient.getName());
                context.startActivity(intent);
            }
        });
        ingredientViewHolder.lnrProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SeekerProfileActivity.class);
                intent.putExtra(Constants.SENIOR_ID,ingredient.getId());
                intent.putExtra(Constants.SEEKER_ID,ingredient.getSeekerId());
                context.startActivity(intent);
            }
        });
    }
}