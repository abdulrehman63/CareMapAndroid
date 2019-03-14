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
import android.widget.ImageView;
import android.widget.TextView;

import com.square63.caremap.R;
import com.square63.caremap.constants.Constants;
import com.square63.caremap.ui.fragments.HomeFragment;
import com.square63.caremap.ui.fragments.MessagesFragment;
import com.square63.caremap.ui.fragments.ProfileFragment;
import com.square63.caremap.ui.fragments.SeekerHomeFragment;
import com.square63.caremap.ui.fragments.SeniorProfileFragment;
import com.square63.caremap.utils.PreferenceHelper;
import com.square63.caremap.utils.UIHelper;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    public TextView mTextMessage,titileToolbar,toolbarTitleRight;

    boolean isHome, message, profile;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    if(!isHome) {

                        if (type.equalsIgnoreCase(Constants.PROVIDER)) {
                            addFragment(SeekerHomeFragment.newInstance(), "home");
                        } else {
                            addFragment(HomeFragment.newInstance(), "home");
                        }
                        titileToolbar.setText(R.string.title_home);
                        imgShare.setVisibility(View.GONE);
                        isHome = true;
                        profile = false;
                        message = false;
                    }
                    return true;
                case R.id.navigation_dashboard:
                    if(!message) {
                        addFragment(MessagesFragment.newInstance(), "MessagesFragment");
                        titileToolbar.setText(R.string.title_dashboard);
                        imgShare.setVisibility(View.GONE);
                        isHome = false;
                        profile = false;
                        message =true;
                    }
                    return true;
                case R.id.navigation_notifications:
                    if(!profile) {
                        if (type.equalsIgnoreCase(Constants.PROVIDER)) {
                            addFragment(ProfileFragment.newInstance(), "ProfileFragment");
                            titileToolbar.setText("");
                        } else {
                            addFragment(SeniorProfileFragment.newInstance(), "ProfileFragment");
                            titileToolbar.setText("F.C");
                        }

                        imgShare.setVisibility(View.VISIBLE);
                        isHome = false;
                        profile =true;
                        message =false;
                    }

                   // toolbarTitleRight.setText("Settings");
                    return true;
            }
            return false;
        }

    };
    private FrameLayout container_body;
    private ImageView imgShare;
    private String type;

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
        imgShare = (ImageView)findViewById(R.id.imgShare);
        titileToolbar.setText("MarketPlace");
       //toolbarTitleRight.setText("Next");
        imgShare.setOnClickListener(new View.OnClickListener() {
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
        PreferenceHelper.getInstance().init(this);

        mTextMessage = (TextView) findViewById(R.id.message);
        container_body = (FrameLayout) findViewById(R.id.container_body);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        initToolBar();
        type = PreferenceHelper.getInstance().getString(Constants.TYPE,"");
        if(getIntent().getStringExtra(Constants.FORM) != null){
           //onNavigationItemSelected( navigation.getMenu().getItem(2));
           navigation.setSelectedItemId(R.id.navigation_notifications);
        }else {
            if (type.equalsIgnoreCase(Constants.PROVIDER)) {
                addFragment(SeekerHomeFragment.newInstance(), "home");
            } else {
                addFragment(HomeFragment.newInstance(), "homes");
            }
        }
       // addFragment(HomeFragment.newInstance(),"home");;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment;
        switch (menuItem.getItemId()) {
            case R.id.navigation_home:
                if(!isHome) {

                    if (type.equalsIgnoreCase(Constants.PROVIDER)) {
                        addFragment(SeekerHomeFragment.newInstance(), "home");
                    } else {
                        addFragment(HomeFragment.newInstance(), "home");
                    }
                    titileToolbar.setText(R.string.title_home);
                    imgShare.setVisibility(View.GONE);
                    isHome = true;
                    profile = false;
                    message = false;
                }
                return true;
            case R.id.navigation_dashboard:
                if(!message) {
                    addFragment(MessagesFragment.newInstance(), "MessagesFragment");
                    titileToolbar.setText(R.string.title_dashboard);
                    imgShare.setVisibility(View.GONE);
                    isHome = false;
                    profile = false;
                    message =true;
                }
                return true;
            case R.id.navigation_notifications:
                if(!profile) {
                    if (type.equalsIgnoreCase(Constants.PROVIDER)) {
                        addFragment(ProfileFragment.newInstance(), "ProfileFragment");
                        titileToolbar.setText("");
                    } else {
                        addFragment(SeniorProfileFragment.newInstance(), "ProfileFragment");
                        titileToolbar.setText("F.C");
                    }

                    imgShare.setVisibility(View.VISIBLE);
                    isHome = false;
                    profile =true;
                    message =false;
                }

                // toolbarTitleRight.setText("Settings");
                return true;
        }
        return false;
    }
}
