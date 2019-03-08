package com.square63.caremap.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.square63.caremap.R;
import com.square63.caremap.constants.Constants;
import com.square63.caremap.models.MemberData;
import com.square63.caremap.models.Message;
import com.square63.caremap.models.chatModule.CreateMessageRequest;
import com.square63.caremap.models.chatModule.Thread;
import com.square63.caremap.ui.adapters.MessageAdapter;
import com.square63.caremap.ui.fragments.HomeFragment;
import com.square63.caremap.ui.fragments.SeekerHomeFragment;
import com.square63.caremap.utils.PreferenceHelper;
import com.square63.caremap.utils.UIHelper;
import com.square63.caremap.webapi.Apiinterface.ApiCallBack2;
import com.square63.caremap.webapi.Apiinterface.ApiCallback;
import com.square63.caremap.webapi.requests.GetGiverInterestById;
import com.square63.caremap.webapi.requests.GetMaeesageByIdRequest;
import com.square63.caremap.webapi.requests.GetUserThread;
import com.square63.caremap.webapi.responses.MainResponse;
import com.square63.caremap.webapi.responses.MainResponse2;
import com.square63.caremap.webapi.webservices.WebServiceFactory;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {

    private MessageAdapter messageAdapter;
    EditText editTextMessage;
    ListView messagesView;
    private ImageButton imgBack;
    private TextView titileToolbar,toolbarTitleRight,txtNoMessage;
    private ImageView imgShare;
    private String toId = "";
    private String type="";
    Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        editTextMessage = (EditText) findViewById(R.id.editTextMessage);
        messagesView = (ListView) findViewById(R.id.messages_view);
        txtNoMessage = (TextView) findViewById(R.id.txtNoMessage);
        initToolBar();
        init();

    }
    private void  init(){


        if(getIntent() != null && getIntent().getStringExtra(Constants.ID) != null){
            toId = getIntent().getStringExtra(Constants.ID);
            titileToolbar.setText(getIntent().getStringExtra(Constants.PREF_NAMES));
        }
        type = PreferenceHelper.getInstance().getString(Constants.TYPE,"");
        messageAdapter = new MessageAdapter(ChatActivity.this,new ArrayList<Message>());
        messagesView.setAdapter(messageAdapter);
        if(getIntent() != null && getIntent().getSerializableExtra(Constants.DATA) !=null){
            thread = (Thread) getIntent().getSerializableExtra(Constants.DATA);
            toId = thread.getMessages().get(0).getToUserID();
            titileToolbar.setText(thread.getMessages().get(0).getToUser().getFirstName() +" " +thread.getMessages().get(0).getToUser().getLastName());
           populateChat(thread.getMessages());
        }else {
            //getMessages();
            getThreads();
        }

    }
    private void populateChat(ArrayList<com.square63.caremap.models.chatModule.Message> messages){
        ArrayList<Message> messageArrayList = new ArrayList<>();
        if(type.equalsIgnoreCase(Constants.PROVIDER)) {
            for (int i= 0; i < messages.size(); i++){
                Message message;
                if(messages.get(i).getFromUserID().equalsIgnoreCase(PreferenceHelper.getInstance().getString(Constants.USER_ID,""))){
                    message = new Message( messages.get(i).getMessageText(),null,true);
                }else {
                    message = new Message( messages.get(i).getMessageText(),null,false);
                }
                messageArrayList.add(message);


            }
        }else {
            for (int i= 0; i < messages.size(); i++){
                Message message;
                if(messages.get(i).getFromUserID().equalsIgnoreCase(PreferenceHelper.getInstance().getString(Constants.SEEKER_ID,""))){
                    message = new Message( messages.get(i).getMessageText(),null,true);
                }else {
                    message = new Message( messages.get(i).getMessageText(),null,false);
                }
                messageArrayList.add(message);


            }
        }
        messageAdapter = new MessageAdapter(ChatActivity.this,messageArrayList);
        messagesView.setAdapter(messageAdapter);
    }
    private void initToolBar(){

        imgBack =(ImageButton) findViewById(R.id.imgBackbtn);
        imgBack.setVisibility(View.VISIBLE);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        titileToolbar = (TextView)findViewById(R.id.toolbarTittle);
        toolbarTitleRight = (TextView)findViewById(R.id.toolbarTitleRight);
        toolbarTitleRight.setVisibility(View.GONE);
        imgShare = (ImageView)findViewById(R.id.imgShare);
        imgShare.setVisibility(View.GONE);
        titileToolbar.setText("uCarenet");
        titileToolbar.setAllCaps(false);

        //toolbarTitleRight.setText("Next");
    }
    private void getThreads(){
        WebServiceFactory.getInstance().init(this);
        GetUserThread userThread = new GetUserThread();
        userThread.setOption("10");
        if(type.equalsIgnoreCase(Constants.PROVIDER)) {
            userThread.setUserId(PreferenceHelper.getInstance().getString(Constants.USER_ID,""));
        }else {
            userThread.setUserId(PreferenceHelper.getInstance().getString(Constants.SEEKER_ID,""));
        }

        WebServiceFactory.getInstance().apiGetThreads(userThread,new ApiCallBack2() {
            @Override
            public void onSuccess(MainResponse2 mainResponse) {
                ArrayList<Thread> threadArrayList = mainResponse.getResultResponse().getThreadArrayList();
                boolean isFound =false;
                if(threadArrayList.size() >0){
                    for (Thread thread:threadArrayList){
                        if(thread.getSecondUser().equalsIgnoreCase(toId)){
                            populateChat(thread.getMessages());
                            txtNoMessage.setVisibility(View.GONE);
                            isFound = true;
                        }
                    }
                    if(!isFound){
                        txtNoMessage.setVisibility(View.VISIBLE);
                    }

                }else {
                    txtNoMessage.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void getMessages(){
        WebServiceFactory.getInstance().init(this);
        PreferenceHelper.getInstance().init(this);
        GetMaeesageByIdRequest profileRequest = new GetMaeesageByIdRequest();
        if(type.equalsIgnoreCase(Constants.PROVIDER)) {
            profileRequest.getFilterCaregiver().setUserId(PreferenceHelper.getInstance().getString(Constants.USER_ID, ""));
        }else {
            profileRequest.getFilterCaregiver().setUserId(PreferenceHelper.getInstance().getString(Constants.SEEKER_ID, ""));
        }
        //profileRequest.getFilterCaregiver().setUserId(PreferenceHelper.getInstance().getString(Constants.GIVER_ID, ""));

        WebServiceFactory.getInstance().apiGetMessages(profileRequest, new ApiCallBack2() {
            @Override
            public void onSuccess(MainResponse2 mainResponse) {
                ArrayList<Message> messageArrayList = new ArrayList<>();
                if(type.equalsIgnoreCase(Constants.PROVIDER)) {
                    for (int i= 0; i < mainResponse.getResultResponse().getMessages().size(); i++){
                        Message message;
                        if(mainResponse.getResultResponse().getMessages().get(i).getFromUserID().equalsIgnoreCase(PreferenceHelper.getInstance().getString(Constants.USER_ID,""))){
                            message = new Message( mainResponse.getResultResponse().getMessages().get(i).getMessageText(),null,true);
                        }else {
                            message = new Message( mainResponse.getResultResponse().getMessages().get(i).getMessageText(),null,false);
                        }
                        messageArrayList.add(message);


                    }
                }else {
                    for (int i= 0; i < mainResponse.getResultResponse().getMessages().size(); i++){
                        Message message;
                        if(mainResponse.getResultResponse().getMessages().get(i).getFromUserID().equalsIgnoreCase(PreferenceHelper.getInstance().getString(Constants.SEEKER_ID,""))){
                            message = new Message( mainResponse.getResultResponse().getMessages().get(i).getMessageText(),null,true);
                        }else {
                            message = new Message( mainResponse.getResultResponse().getMessages().get(i).getMessageText(),null,false);
                        }
                        messageArrayList.add(message);


                    }
                }


                messageAdapter = new MessageAdapter(ChatActivity.this,messageArrayList);
                messagesView.setAdapter(messageAdapter);

            }
        });
    }
    public void sendMessage(View view) {
        if (editTextMessage.getText().toString().trim().length() > 0) {
            PreferenceHelper.getInstance().init(this);
            CreateMessageRequest createMessageRequest = new CreateMessageRequest();
            if (type.equalsIgnoreCase(Constants.PROVIDER)) {
                createMessageRequest.setFromUserID(PreferenceHelper.getInstance().getString(Constants.USER_ID, ""));
            } else {
                createMessageRequest.setFromUserID(PreferenceHelper.getInstance().getString(Constants.SEEKER_ID, ""));
            }
            // createMessageRequest.setFromUserID(PreferenceHelper.getInstance().getString(Constants.GIVER_ID,""));
            createMessageRequest.setToUserID(toId);
            createMessageRequest.setMessageText(editTextMessage.getText().toString());
            WebServiceFactory.getInstance().init(this);
            WebServiceFactory.getInstance().apiInsertMessage(createMessageRequest, new ApiCallback() {
                @Override
                public void onSuccess(MainResponse mainResponse) {

                }
            });
        }

        String message = editTextMessage.getText().toString();
        MemberData memberData = new MemberData();

        Message message1 = new Message(editTextMessage.getText().toString(), memberData, true);
        if (message.trim().length() > 0) {
            publishMessage(message1);
            editTextMessage.getText().clear();
        }

    }
    private void publishMessage(Message message){

        messageAdapter.add(message);
        messagesView.setSelection(messagesView.getCount() - 1);
        if(messagesView.getCount() > 0){
            txtNoMessage.setVisibility(View.GONE);
        }
    }
}
