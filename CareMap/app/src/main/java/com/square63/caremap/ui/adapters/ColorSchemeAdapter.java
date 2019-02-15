package com.square63.caremap.ui.adapters;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.support.v4.content.ContextCompat;
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


public class ColorSchemeAdapter extends RecyclerView.Adapter<ColorSchemeAdapter.Viewholder> {
    private Context context;
    private Context SkillsAdapater;
    private ArrayList<InterestModel> data;
    private ISkills iSkills;
    private ArrayList<InterestModel> filteredData;

    public ColorSchemeAdapter(Context context, ArrayList<InterestModel> data) {
        this.context = context;
        this.data = data;
        this.filteredData = data;
        this.iSkills = iSkills;
    }

    @Override
    public ColorSchemeAdapter.Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ColorSchemeAdapter.Viewholder(LayoutInflater.from(context).inflate(R.layout.list_item_color_scheme, parent, false));
    }

    @Override
    public void onBindViewHolder(ColorSchemeAdapter.Viewholder holder, final int position) {
        if (filteredData.size() > 0) {
            final InterestModel agent = this.filteredData.get(position);

            if (holder.imgIcon.getBackground() instanceof ShapeDrawable) {
                ((ShapeDrawable)holder.imgIcon.getBackground()).getPaint().setColor(agent.getIcone());
            } else if (holder.imgIcon.getBackground() instanceof GradientDrawable) {
                ((GradientDrawable)holder.imgIcon.getBackground()).setColor(agent.getIcone());
            } else if (holder.imgIcon.getBackground() instanceof ColorDrawable) {
                ((ColorDrawable)holder.imgIcon.getBackground()).setColor(agent.getIcone());
            }
            if (holder.imgColorBig.getBackground() instanceof ShapeDrawable) {
                ((ShapeDrawable)holder.imgColorBig.getBackground()).getPaint().setColor(agent.getIcone());
            } else if (holder.imgColorBig.getBackground() instanceof GradientDrawable) {
                ((GradientDrawable)holder.imgColorBig.getBackground()).setColor(agent.getIcone());
            } else if (holder.imgColorBig.getBackground() instanceof ColorDrawable) {
                ((ColorDrawable)holder.imgColorBig.getBackground()).setColor(agent.getIcone());
            }

            if (agent.isSelected()) {
                holder.imgColorBig.setVisibility(View.VISIBLE);
                holder.imgIcon.setVisibility(View.GONE);
            } else {
                holder.imgColorBig.setVisibility(View.GONE);
                holder.imgIcon.setVisibility(View.VISIBLE);
            }

            holder.imgIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (int i = 0; i < filteredData.size(); i++) {
                        filteredData.get(i).setSelected(false);
                    }

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
        LinearLayout relMain;
        TextView txtName;
        ImageView imgIcon,imgColorBig;

        public Viewholder(View itemView) {
            super(itemView);

            imgIcon = (ImageView) itemView.findViewById(R.id.imgColor);
            imgColorBig = (ImageView) itemView.findViewById(R.id.imgColorBig);
            relMain = (LinearLayout) itemView.findViewById(R.id.relMain);

        }
    }


    public interface ISkills {
        public void selectedSkills(ArrayList<String> policies);

    }
}