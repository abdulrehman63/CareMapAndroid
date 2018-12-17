package com.square63.caremap.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.square63.caremap.R;
import com.square63.caremap.ui.fragments.HomeFragment;
import com.square63.caremap.ui.fragments.MessagesFragment;
import com.square63.caremap.ui.fragments.ProfileFragment;
import com.square63.caremap.utils.UIHelper;

public class HomeActivity extends AppCompatActivity {

    private TextView mTextMessage,titileToolbar,toolbarTitleRight;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    addFragment(HomeFragment.newInstance(),"home");
                    titileToolbar.setText(R.string.title_home);
                    toolbarTitleRight.setVisibility(View.GONE);
                    return true;
                case R.id.navigation_dashboard:
                    addFragment(MessagesFragment.newInstance(),"MessagesFragment");
                    titileToolbar.setText(R.string.title_dashboard);
                    toolbarTitleRight.setVisibility(View.GONE);
                    return true;
                case R.id.navigation_notifications:
                    addFragment(ProfileFragment.newInstance(),"ProfileFragment");
                    titileToolbar.setText(R.string.title_notifications);
                    toolbarTitleRight.setVisibility(View.VISIBLE);
                    toolbarTitleRight.setText("Settings");
                    return true;
            }
            return false;
        }

    };
    private FrameLayout container_body;

    private void addFragment(Fragment fragment,String tag){
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment,tag);
            fragmentTransaction.commit();


        }
    }
    private ImageButton imgBack;

    private void initToolBar(){

        imgBack =(ImageButton) findViewById(R.id.imgBackbtn);
        imgBack.setVisibility(View.GONE);


        titileToolbar = (TextView)findViewById(R.id.toolbarTittle);
        toolbarTitleRight = (TextView)findViewById(R.id.toolbarTitleRight);
        titileToolbar.setText("Market Place");
       //toolbarTitleRight.setText("Next");
        toolbarTitleRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIHelper.openActivity(HomeActivity.this,SettingsActivity.class);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mTextMessage = (TextView) findViewById(R.id.message);
        container_body = (FrameLayout) findViewById(R.id.container_body);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        initToolBar();
        addFragment(HomeFragment.newInstance(),"home");;
    }

}
