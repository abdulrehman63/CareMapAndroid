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


import java.util.ArrayList;


public class LanguageSelectionDialoge extends DialogFragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private ImageButton imgCross;
    private TextView txtTitle,txtSubmit,txtCancel;
    private RecyclerView recyclerView;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private ArrayList<LanguageModel> skillsModelArrayList=new ArrayList<>();
    private LanguagesAdapater skillsAdapter;
    private IGetSkills iGetSkills;
    private ArrayList<LanguageModel> data = new ArrayList<>();
    private SearchView searchView;

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
    public void setISkills( IGetSkills iGetSkills){
        this.iGetSkills = iGetSkills;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            ArrayList<LanguageModel> skillsModels= (ArrayList<LanguageModel>)getArguments().getSerializable(ARG_PARAM1);
            skillsModelArrayList.clear();
            skillsModelArrayList.addAll(skillsModels);
          //  mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialoge_languages, container, false);

        recyclerView= (RecyclerView)view.findViewById(R.id.recyclerView);

        setRecyclerViewBudgetAdapter(skillsModelArrayList);
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
        skillsAdapter=new LanguagesAdapater(getContext(), data);
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
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
       // mListener = null;
    }

   /* @Override
    public void selectedSkills(ArrayList<LanguageModel> data) {
        this.data.clear();
        this.data.addAll(data);

    }*/

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


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
    public interface IGetSkills{
        void getSkills(ArrayList<LanguageModel> skillsModelArrayList);
    }
}
