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

public class MobilityAdapter extends RecyclerView.Adapter<MobilityAdapter.Viewholder> {
    private Context context;
    private Context SkillsAdapater;
    private ArrayList<InterestModel> data;
    private ISkills iSkills;
    private ArrayList<InterestModel> filteredData;

    public MobilityAdapter(Context context, ArrayList<InterestModel> data) {
        this.context = context;
        this.data = data;
        this.filteredData = data;
        this.iSkills = iSkills;
    }
    public MobilityAdapter(Context context, ArrayList<InterestModel> data,ISkills iSkills) {
        this.context = context;
        this.data = data;
        this.filteredData = data;
        this.iSkills = iSkills;
    }

    @Override
    public MobilityAdapter.Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MobilityAdapter.Viewholder(LayoutInflater.from(context).inflate(R.layout.list_item_interest, parent, false));
    }

    @Override
    public void onBindViewHolder(MobilityAdapter.Viewholder holder, final int position) {
        if (filteredData.size() > 0) {
            final InterestModel agent = this.filteredData.get(position);
            holder.txtName.setText(agent.getName());
            holder.imgIcon.setImageResource(agent.getIcone());

            if (agent.isSelected()) {
                holder.txtName.setTextColor(context.getResources().getColor(R.color.black));
                holder.imgIcon.setAlpha(1.0f);


            } else {
                holder.txtName.setTextColor(context.getResources().getColor(R.color.grey));
                holder.imgIcon.setAlpha(0.3f);
            }

            holder.relMain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (int i = 0; i < filteredData.size(); i++) {
                        filteredData.get(i).setSelected(false);
                    }

                    filteredData.get(position).setSelected(true);
                    iSkills.selectedSkills(filteredData.get(position).getInterestID());
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
        public void selectedSkills(String mobilityId);

    }
}