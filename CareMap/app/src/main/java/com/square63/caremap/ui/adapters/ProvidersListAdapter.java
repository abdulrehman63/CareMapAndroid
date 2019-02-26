package com.square63.caremap.ui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter;
import com.square63.caremap.R;
import com.square63.caremap.constants.Constants;
import com.square63.caremap.models.ProviderChildModel;
import com.square63.caremap.models.ProviderGroupModel;
import com.square63.caremap.ui.views.ChildsViewHolder;
import com.square63.caremap.ui.views.GroupsViewHolder;

import java.util.List;


public class ProvidersListAdapter extends ExpandableRecyclerAdapter<ProviderGroupModel, ProviderChildModel, GroupsViewHolder, ChildsViewHolder> {

    private LayoutInflater mInflater;

    public ProvidersListAdapter(Context context, @NonNull List<ProviderGroupModel> recipeList) {
        super(recipeList);
        mInflater = LayoutInflater.from(context);
    }

    // onCreate ...
    @Override
    public GroupsViewHolder onCreateParentViewHolder(@NonNull ViewGroup parentViewGroup, int viewType) {
        View recipeView = mInflater.inflate(R.layout.list_item_group, parentViewGroup, false);
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
    }

    @Override
    public void onBindChildViewHolder(@NonNull ChildsViewHolder ingredientViewHolder, int parentPosition, int childPosition, @NonNull ProviderChildModel ingredient) {
        ingredientViewHolder.bind(ingredient);
    }
}