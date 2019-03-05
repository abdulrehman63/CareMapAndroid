package com.square63.caremap.ui.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.square63.caremap.R;
import com.square63.caremap.models.InterestModel;
import com.square63.caremap.models.LanguageModel;
import com.square63.caremap.models.SkillsModel;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class SkillsAdapter extends RecyclerView.Adapter<SkillsAdapter.Viewholder> {
    private Context context;
    private Context SkillsAdapater;
    private ArrayList<SkillsModel> data;
    private ISkills iSkills;
    private ArrayList<SkillsModel> filteredData;

    public SkillsAdapter(Context context, ArrayList<SkillsModel> data) {
        this.context = context;
        this.data = data;
        this.filteredData = data;
        this.iSkills = iSkills;
    }

    public SkillsAdapter(Context context, ArrayList<SkillsModel> data,ISkills iSkills) {
        this.context = context;
        this.data = data;
        this.filteredData = data;
        this.iSkills = iSkills;
    }

    @Override
    public SkillsAdapter.Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SkillsAdapter.Viewholder(LayoutInflater.from(context).inflate(R.layout.list_item_skills, parent, false));
    }

    @Override
    public void onBindViewHolder(SkillsAdapter.Viewholder holder, final int position) {
        if (filteredData.size() > 0) {
            final SkillsModel agent = this.filteredData.get(position);
            holder.txtSkill.setText(agent.getName());
            if (agent.isSelected()) {
                holder.imgLanguage.setVisibility(View.VISIBLE);

            } else {
                holder.imgLanguage.setVisibility(View.GONE);
            }

            holder.relMain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(filteredData.get(position).isSelected()){
                        filteredData.get(position).setSelected(false);
                    }else {
                        filteredData.get(position).setSelected(true);
                    }
                    //iSelectedLanguages.selectedLanguages(filteredData);
                    notifyDataSetChanged();
                    iSkills.selectedSkills(filteredData);

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return this.filteredData.size();
    }

    class Viewholder extends RecyclerView.ViewHolder {
        TextView txtSkill;
        ImageView imgLanguage;
        RelativeLayout relMain;

        public Viewholder(View itemView) {
            super(itemView);
            relMain = (RelativeLayout) itemView.findViewById(R.id.relMain);
            imgLanguage = (ImageView) itemView.findViewById(R.id.imgLanguage);
            txtSkill = (TextView) itemView.findViewById(R.id.txtSkill);


        }
    }


    public interface ISkills {
        public void selectedSkills(ArrayList<SkillsModel> data );

    }
}
