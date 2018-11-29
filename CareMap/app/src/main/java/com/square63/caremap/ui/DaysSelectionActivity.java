package com.square63.caremap.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.square63.caremap.R;
import com.square63.caremap.listeners.RecyclerItemClickListener;
import com.square63.caremap.models.DayModel;
import com.square63.caremap.models.LanguageModel;
import com.square63.caremap.ui.adapters.DaysAdpater;
import com.square63.caremap.ui.adapters.LanguagesAdapater;

import java.util.ArrayList;

public class DaysSelectionActivity extends AppCompatActivity {

    private DaysAdpater daysAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days_selection);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        ArrayList<DayModel> data = new ArrayList<>();
        for (int i= 1; i <=  28; i++){
            DayModel dayModel = new DayModel();
            data.add(dayModel);
        }
        setRecyclerView(data);
    }
    private void setRecyclerView(ArrayList<DayModel> data) {
        daysAdapter=new DaysAdpater(this, data);
        recyclerView.setAdapter(daysAdapter);
        RecyclerView.LayoutManager mManager =new GridLayoutManager(this, 7);
        recyclerView.setLayoutManager(mManager);
         recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
               /* Intent intent = new Intent(getActivity(), AgentDetailActivity.class);
                intent.putExtra(Constants.AGENT_ID,agentList.get(position).getId());

                startActivity(intent);*/
            }
        }));
    }
}
