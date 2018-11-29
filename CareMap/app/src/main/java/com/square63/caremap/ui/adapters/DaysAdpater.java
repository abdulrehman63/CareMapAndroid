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
import com.square63.caremap.models.DayModel;

import java.util.ArrayList;


public class DaysAdpater extends RecyclerView.Adapter<DaysAdpater.Viewholder> {
    private Context context;
    private Context SkillsAdapater;
    private ArrayList<DayModel> data;
    private ISkills iSkills;
    private ArrayList<DayModel> filteredData;

    public DaysAdpater(Context context, ArrayList<DayModel> data) {
        this.context = context;
        this.data = data;
        this.filteredData = data;
        this.iSkills = iSkills;
    }

    @Override
    public DaysAdpater.Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DaysAdpater.Viewholder(LayoutInflater.from(context).inflate(R.layout.list_item_day, parent, false));
    }

    @Override
    public void onBindViewHolder(DaysAdpater.Viewholder holder, final int position) {
        if (filteredData.size() > 0) {
            final DayModel agent = this.filteredData.get(position);

            if (agent.isSelected()) {
                holder.imgDot.setVisibility(View.VISIBLE);

            } else {
                holder.imgDot.setVisibility(View.GONE);
            }

            holder.relMain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (filteredData.get(position).isSelected())
                        filteredData.get(position).setSelected(false);
                    else
                        filteredData.get(position).setSelected(true);
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
        RelativeLayout relMain;
        ImageView imgDot;

        public Viewholder(View itemView) {
            super(itemView);
            imgDot = (ImageView) itemView.findViewById(R.id.imgDot);
            relMain = (RelativeLayout) itemView.findViewById(R.id.relMain);

        }
    }


    public interface ISkills {
        public void selectedSkills(ArrayList<String> policies);

    }
}