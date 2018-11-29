package com.square63.caremap.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.square63.caremap.R;
import com.square63.caremap.models.LanguageModel;

import java.util.ArrayList;


public class LanguagesAdapater extends RecyclerView.Adapter<LanguagesAdapater.Viewholder> implements Filterable {
    private Context context;
    private Context SkillsAdapater;
    private ArrayList<LanguageModel> data;
    private ISkills iSkills;
    private ArrayList<LanguageModel> filteredData;

    public LanguagesAdapater(Context context, ArrayList<LanguageModel> data) {
        this.context = context;
        this.data = data;
        this.filteredData = data;
        this.iSkills=iSkills;
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
                holder.cbSkills.setChecked(true);

            } else {
                holder.cbSkills.setChecked(false);
            }

            holder.cbSkills.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CheckBox cb = (CheckBox) v;
                    filteredData.get(position).setSelected(cb.isChecked());
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
        CheckBox cbSkills;

        public Viewholder(View itemView) {
            super(itemView);
             cbSkills = (CheckBox) itemView.findViewById(R.id.cb_Skills);
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
    public interface ISkills{
        public void selectedSkills(ArrayList<String> policies);

    }
}