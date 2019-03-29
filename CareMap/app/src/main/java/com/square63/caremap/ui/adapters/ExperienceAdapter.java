package com.square63.caremap.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.square63.caremap.R;
import com.square63.caremap.models.SkillsModel;

import java.util.ArrayList;


public class ExperienceAdapter extends RecyclerView.Adapter<ExperienceAdapter.Viewholder> {
    private Context context;
    private Context SkillsAdapater;
    private ArrayList<SkillsModel> data;
    private ISkills iSkills;
    private ArrayList<SkillsModel> filteredData;

    public ExperienceAdapter(Context context, ArrayList<SkillsModel> data) {
        this.context = context;
        this.data = data;
        this.filteredData = data;
        this.iSkills = iSkills;
    }

    @Override
    public ExperienceAdapter.Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ExperienceAdapter.Viewholder(LayoutInflater.from(context).inflate(R.layout.list_item_experience, parent, false));
    }

    @Override
    public void onBindViewHolder(ExperienceAdapter.Viewholder holder, final int position) {
        if (filteredData.size() > 0) {
            holder.txtName.setText(filteredData.get(position).getName());
            if (filteredData.get(position).getId() != null)
            holder.txtDesc.setText(filteredData.get(position).getId());
        }
    }

    @Override
    public int getItemCount() {
        return this.filteredData.size();
    }

    class Viewholder extends RecyclerView.ViewHolder {

        public TextView txtName,txtDesc;
        public Viewholder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.textView16);
            txtDesc = itemView.findViewById(R.id.textView17);


        }
    }


    public interface ISkills {
        public void selectedSkills(ArrayList<String> policies);

    }
}
