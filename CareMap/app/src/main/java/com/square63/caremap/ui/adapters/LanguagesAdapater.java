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


public class LanguagesAdapater extends RecyclerView.Adapter<LanguagesAdapater.Viewholder> implements Filterable {
    private Context context;
    private Context SkillsAdapater;
    private ArrayList<LanguageModel> data;
    private ISelectedLanguages iSelectedLanguages;
    private ArrayList<LanguageModel> filteredData;

    public LanguagesAdapater(Context context, ArrayList<LanguageModel> data,ISelectedLanguages iSelectedLanguages) {
        this.context = context;
        this.data = data;
        this.filteredData = data;
        this.iSelectedLanguages=iSelectedLanguages;
    }

    @Override
    public LanguagesAdapater.Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LanguagesAdapater.Viewholder(LayoutInflater.from(context).inflate(R.layout.list_item_language, parent, false));
    }

    @Override
    public void onBindViewHolder(LanguagesAdapater.Viewholder holder, final int position) {
        if(filteredData.size() > 0) {
            final LanguageModel agent = this.filteredData.get(position);
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
                   iSelectedLanguages.selectedLanguages(filteredData);
                    notifyDataSetChanged();
                   // iSkills.selectedSkills(filteredData);

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
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    filteredData = data;
                }
                else {


                        ArrayList<LanguageModel> filteredList = new ArrayList<>();
                        for (LanguageModel row : data) {

                            // name match condition. this might differ depending on your requirement
                            // here we are looking for name or phone number match
                            if (row.getName().toLowerCase().contains(charString.toLowerCase())) {
                                filteredList.add(row);
                            }
                        }
                        filteredData = filteredList;

                }



                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredData;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredData = (ArrayList<LanguageModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
    public interface ISelectedLanguages{
        public void selectedLanguages(ArrayList<LanguageModel> languageModels);

    }
}