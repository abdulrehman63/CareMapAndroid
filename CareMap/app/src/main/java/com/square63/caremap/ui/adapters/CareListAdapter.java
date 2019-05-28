package com.square63.caremap.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.square63.caremap.R;
import com.square63.caremap.models.LanguageModel;

import java.util.ArrayList;


public class CareListAdapter extends RecyclerView.Adapter<com.square63.caremap.ui.adapters.CareListAdapter.Viewholder> {
    private Context context;
    private Context SkillsAdapater;
    private ArrayList<LanguageModel> data;
    private com.square63.caremap.ui.adapters.CareListAdapter.ISelectedLanguages iSelectedLanguages;
    private ArrayList<LanguageModel> filteredData;

    public CareListAdapter(Context context, ArrayList<LanguageModel> data, com.square63.caremap.ui.adapters.CareListAdapter.ISelectedLanguages iSelectedLanguages) {
        this.context = context;
        this.data = data;
        this.filteredData = data;
        this.iSelectedLanguages = iSelectedLanguages;
    }

    @Override
    public com.square63.caremap.ui.adapters.CareListAdapter.Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new com.square63.caremap.ui.adapters.CareListAdapter.Viewholder(LayoutInflater.from(context).inflate(R.layout.list_item_care, parent, false));
    }

    @Override
    public void onBindViewHolder(com.square63.caremap.ui.adapters.CareListAdapter.Viewholder holder, final int position) {
        if (filteredData.size() > 0) {
            final LanguageModel agent = this.filteredData.get(position);
            holder.txtName.setText(agent.getName());
            if (agent.isSelected()) {
                holder.txtName.setTextColor(context.getResources().getColor(R.color.white));
                holder.relMain.setBackgroundResource(R.drawable.widerectangleshadowpressed_2x);
            } else {
                holder.txtName.setTextColor(context.getResources().getColor(R.color.text_grey));
                holder.relMain.setBackgroundResource(R.drawable.widerectangleshadow_2x);
            }

            holder.relMain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (filteredData.get(position).isSelected()) {
                        filteredData.get(position).setSelected(false);
                    } else {
                        filteredData.get(position).setSelected(true);
                    }
                    iSelectedLanguages.selectedLanguages(filteredData);
                    notifyDataSetChanged();
                    // iSkills.selectedSkills(filteredData);

                }
            });

        }
    }
    public void setSelectedData(){
        for (int i = 0; i < filteredData.size(); i++) {
            filteredData.get(i).setSelected(true);
        }
        iSelectedLanguages.selectedLanguages(filteredData);
        notifyDataSetChanged();
    }

    public void setUnSelectedData(){
        for (int i = 0; i < filteredData.size(); i++) {
            filteredData.get(i).setSelected(false);
        }
        iSelectedLanguages.selectedLanguages(filteredData);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return this.filteredData.size();
    }

    class Viewholder extends RecyclerView.ViewHolder {
        TextView txtName;
        ImageView imgLanguage;
        RelativeLayout relMain;

        public Viewholder(View itemView) {
            super(itemView);
            relMain = (RelativeLayout) itemView.findViewById(R.id.relMain);
            txtName = (TextView) itemView.findViewById(R.id.txtName);


        }
    }

    public interface ISelectedLanguages {
        public void selectedLanguages(ArrayList<LanguageModel> languageModels);

    }
}