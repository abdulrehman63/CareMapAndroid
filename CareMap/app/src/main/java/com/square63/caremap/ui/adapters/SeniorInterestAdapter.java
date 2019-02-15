package com.square63.caremap.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.square63.caremap.R;
import com.square63.caremap.models.InterestModel;

import java.util.ArrayList;


public class SeniorInterestAdapter extends RecyclerView.Adapter<SeniorInterestAdapter.Viewholder> {
    private Context context;
    private Context SkillsAdapater;
    private ArrayList<InterestModel> data;
    private ISkills iSkills;
    private ArrayList<InterestModel> filteredData;

    public SeniorInterestAdapter(Context context, ArrayList<InterestModel> data) {
        this.context = context;
        this.data = data;
        this.filteredData = data;
        this.iSkills = iSkills;
    }

    @Override
    public SeniorInterestAdapter.Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SeniorInterestAdapter.Viewholder(LayoutInflater.from(context).inflate(R.layout.list_item_senior_interest, parent, false));
    }

    @Override
    public void onBindViewHolder(SeniorInterestAdapter.Viewholder holder, final int position) {
        if (filteredData.size() > 0) {
            final InterestModel agent = this.filteredData.get(position);
            holder.txtName.setText(agent.getName());
            holder.imgIcon.setImageResource(agent.getIcone());


        }
    }

    @Override
    public int getItemCount() {
        return this.filteredData.size();
    }

    class Viewholder extends RecyclerView.ViewHolder {
        LinearLayout relMain;
        TextView txtName;
        ImageView imgIcon;

        public Viewholder(View itemView) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.txtName);
            imgIcon = (ImageView) itemView.findViewById(R.id.imgIcon);
            relMain = (LinearLayout) itemView.findViewById(R.id.relMain);

        }
    }


    public interface ISkills {
        public void selectedSkills(ArrayList<String> policies);

    }
}