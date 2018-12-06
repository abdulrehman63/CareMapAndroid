package com.square63.caremap.dialoges;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.TextView;

import com.square63.caremap.R;
import com.square63.caremap.listeners.RecyclerItemClickListener;
import com.square63.caremap.models.LanguageModel;
import com.square63.caremap.ui.adapters.LanguagesAdapater;
import com.square63.caremap.utils.Validations;


import java.util.ArrayList;


public class LanguageSelectionDialoge extends DialogFragment implements View.OnClickListener{

    private static final String ARG_PARAM1 = "param1";

    private RecyclerView recyclerView;


    private LanguagesAdapater skillsAdapter;
    private LanguagesAdapater.ISelectedLanguages iSelectedLanguages;
    private ArrayList<LanguageModel> data = new ArrayList<>();
    private SearchView searchView;
    private ImageButton imgBack;
    private TextView titileToolbar,toolbarTitleRight;
    private ArrayList<LanguageModel> languageModelArrayList = new ArrayList<>();


    public LanguageSelectionDialoge() {
        // Required empty public constructor
    }



    public static LanguageSelectionDialoge newInstance(ArrayList<LanguageModel> skillsModel) {
        LanguageSelectionDialoge fragment = new LanguageSelectionDialoge();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, skillsModel);

        fragment.setArguments(args);
        return fragment;
    }
    public void setSelectedLanguages( LanguagesAdapater.ISelectedLanguages iSelectedLanguages){
        this.iSelectedLanguages = iSelectedLanguages;

    }
    private void initToolBar(View view){

        imgBack =(ImageButton) view.findViewById(R.id.imgBackbtn);
        imgBack.setVisibility(View.VISIBLE);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        titileToolbar = (TextView)view.findViewById(R.id.toolbarTittle);
        toolbarTitleRight = (TextView)view.findViewById(R.id.toolbarTitleRight);
        titileToolbar.setText("Languages");
        toolbarTitleRight.setText("Done");
        toolbarTitleRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iSelectedLanguages.selectedLanguages(languageModelArrayList);
                dismiss();

            }
        });
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(android.support.v4.app.DialogFragment.STYLE_NO_TITLE, R.style.AppTheme);
        if (getArguments() != null) {
            ArrayList<LanguageModel> skillsModels= (ArrayList<LanguageModel>)getArguments().getSerializable(ARG_PARAM1);

            languageModelArrayList.clear();
            languageModelArrayList.addAll(skillsModels);
          //  mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialoge_languages, container, false);

        recyclerView= (RecyclerView)view.findViewById(R.id.recyclerView);

        setRecyclerViewBudgetAdapter(languageModelArrayList);
        initToolBar(view);
        searchView = (SearchView) view.findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchView.clearFocus();

                if (query.length() > 0) {
                    skillsAdapter.getFilter().filter(query);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                //  if (query.length() > 0)
                if(skillsAdapter != null)
                    skillsAdapter.getFilter().filter(query);

                return false;
            }
        });

        return view;
    }
    private void setRecyclerViewBudgetAdapter(ArrayList<LanguageModel> data) {
        skillsAdapter=new LanguagesAdapater(getContext(), data, new LanguagesAdapater.ISelectedLanguages() {
            @Override
            public void selectedLanguages(ArrayList<LanguageModel> languageModels) {
                LanguageSelectionDialoge.this.languageModelArrayList = languageModels;

            }
        });
        recyclerView.setAdapter(skillsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
               /* Intent intent = new Intent(getActivity(), AgentDetailActivity.class);
                intent.putExtra(Constants.AGENT_ID,agentList.get(position).getId());

                startActivity(intent);*/
            }
        }));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            /*case R.id.txtSubmit:
                if(data.size() == 0 )
                    iGetSkills.getSkills(skillsModelArrayList);
                else
                    iGetSkills.getSkills(data);

                break;
            case R.id.txtCancel:
                dismiss();
                break;
            case R.id.imgCross:
                dismiss();
                break;*/
        }
    }



    public interface IGetSkills{
        void getSkills(ArrayList<LanguageModel> skillsModelArrayList);
    }
}
