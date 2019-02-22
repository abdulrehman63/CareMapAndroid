package com.square63.caremap.ui.fragments;

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

import com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter;
import com.square63.caremap.R;
import com.square63.caremap.models.ProviderChildModel;
import com.square63.caremap.models.ProviderGroupModel;
import com.square63.caremap.ui.adapters.MarketPlaceAdapter;
import com.square63.caremap.ui.adapters.ProvidersListAdapter;

import java.util.ArrayList;


public class SeekerHomeFragment extends Fragment {


    private MarketPlaceAdapter adapter;
    private RecyclerView recyclerView;
    int position  = -1;

    public SeekerHomeFragment() {
        // Required empty public constructor
    }


    public static SeekerHomeFragment newInstance() {
        SeekerHomeFragment fragment = new SeekerHomeFragment();
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
        View view =  inflater.inflate(R.layout.seeker_home, container, false);
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
        adapter = new MarketPlaceAdapter(getContext(),providerGroupModelArrayList);
        recyclerView.setLayoutManager(layoutManager);
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
