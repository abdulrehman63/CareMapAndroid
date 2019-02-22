package com.square63.caremap.ui.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter;
import com.square63.caremap.R;
import com.square63.caremap.models.Artist;
import com.square63.caremap.models.Genre;
import com.square63.caremap.models.ProviderChildModel;
import com.square63.caremap.models.ProviderGroupModel;
import com.square63.caremap.models.SkillsModel;
import com.square63.caremap.ui.adapters.MarketPlaceAdapter;
import com.square63.caremap.ui.adapters.ProvidersListAdapter;
import com.square63.caremap.utils.VerticalSpaceItemDecoration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HomeFragment extends Fragment {


    private ProvidersListAdapter adapter;
    private RecyclerView recyclerView;
    int position  = -1;

    public HomeFragment() {
        // Required empty public constructor
    }


    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view){
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        // RecyclerView has some built in animations to it, using the DefaultItemAnimator.
        // Specifically when you call notifyItemChanged() it does a fade animation for the changing
        // of the data in the ViewHolder. If you would like to disable this you can use the following:
        RecyclerView.ItemAnimator animator = recyclerView.getItemAnimator();
        if (animator instanceof DefaultItemAnimator) {
            ((DefaultItemAnimator) animator).setSupportsChangeAnimations(false);
        }
        ArrayList<ProviderGroupModel> providerGroupModelArrayList = new ArrayList<>();
        for(int i = 0 ;i < 10; i++){
            ArrayList<ProviderChildModel> providerChildModelArrayList =new ArrayList<>();
            ProviderChildModel providerChildModel = new ProviderChildModel();
            providerChildModelArrayList.add(providerChildModel);
            ProviderGroupModel providerGroupModel = new ProviderGroupModel("temp",providerChildModelArrayList);
            providerGroupModelArrayList.add(providerGroupModel);
        }
        adapter = new ProvidersListAdapter(getContext(),providerGroupModelArrayList);
        recyclerView.setLayoutManager(layoutManager);
       int VERTICAL_ITEM_SPACE = 48;

        //or
        DividerItemDecoration itemDecorator = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        itemDecorator.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.divider));
        recyclerView.addItemDecoration(itemDecorator);
        recyclerView.setAdapter(adapter);
        adapter.setExpandCollapseListener(new ExpandableRecyclerAdapter.ExpandCollapseListener() {
            @UiThread
            @Override
            public void onParentExpanded(int parentPosition) {
                if(position != -1)
               adapter.collapseParent(position);
                position = parentPosition;
            }

            @UiThread
            @Override
            public void onParentCollapsed(int parentPosition) {
                if(parentPosition == position)
                    position = -1;

            }
        });

    }



}
