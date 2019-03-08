package com.square63.caremap.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.square63.caremap.R;
import com.square63.caremap.constants.Constants;
import com.square63.caremap.models.SkillsModel;
import com.square63.caremap.models.chatModule.Thread;
import com.square63.caremap.ui.ChatActivity;

import java.util.ArrayList;

public class ThreadAdapter extends RecyclerView.Adapter<ThreadAdapter.Viewholder> {
    private Context context;
    private Context SkillsAdapater;
    private ArrayList<SkillsModel> data;
    private ISkills iSkills;
    private ArrayList<Thread> filteredData;

    public ThreadAdapter(Context context, ArrayList<Thread> data) {
        this.context = context;
        this.filteredData = data;
        this.iSkills = iSkills;
    }

    @Override
    public ThreadAdapter.Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ThreadAdapter.Viewholder(LayoutInflater.from(context).inflate(R.layout.item_thread, parent, false));
    }

    @Override
    public void onBindViewHolder(ThreadAdapter.Viewholder holder, final int position) {
        if (filteredData.size() > 0) {
            holder.txtTitle.setText(filteredData.get(position).getMessages().get(filteredData.get(position).getMessages().size()-1).getToUser().getFirstName() +" "+filteredData.get(position).getMessages().get(filteredData.get(position).getMessages().size()-1).getToUser().getFirstName());
            holder.txtMessage.setText(filteredData.get(position).getMessages().get(filteredData.get(position).getMessages().size()-1).getMessageText());
            holder.layoutMain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ChatActivity.class);
                    intent.putExtra(Constants.DATA,filteredData.get(position));
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return this.filteredData.size();
    }

    class Viewholder extends RecyclerView.ViewHolder {
        public  TextView txtTitle,txtMessage;
        public ConstraintLayout layoutMain;

        public Viewholder(View itemView) {
            super(itemView);
            txtTitle = (TextView) itemView.findViewById(R.id.textView16);
            layoutMain = (ConstraintLayout) itemView.findViewById(R.id.layoutMain);
            txtMessage = (TextView) itemView.findViewById(R.id.textView17);

        }
    }


    public interface ISkills {
        public void selectedSkills(ArrayList<String> policies);

    }
}
