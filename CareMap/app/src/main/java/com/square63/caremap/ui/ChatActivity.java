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
import com.square63.caremap.ui.adapters.MessageAdapter;
import com.square63.caremap.utils.PreferenceHelper;
import com.square63.caremap.utils.UIHelper;
import com.square63.caremap.webapi.Apiinterface.ApiCallBack2;
import com.square63.caremap.webapi.Apiinterface.ApiCallback;
import com.square63.caremap.webapi.requests.GetGiverInterestById;
import com.square63.caremap.webapi.requests.GetMaeesageByIdRequest;
import com.square63.caremap.webapi.responses.MainResponse;
import com.square63.caremap.webapi.responses.MainResponse2;
import com.square63.caremap.webapi.webservices.WebServiceFactory;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {

    private MessageAdapter messageAdapter;
    EditText editTextMessage;
    ListView messagesView;
    private ImageButton imgBack;
    private TextView titileToolbar,toolbarTitleRight;
    private ImageView imgShare;
    private String toId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        init();
        initToolBar();
    }
    private void  init(){
        editTextMessage = (EditText) findViewById(R.id.editTextMessage);
        messagesView = (ListView) findViewById(R.id.messages_view);

        if(getIntent() != null && getIntent().getStringExtra(Constants.ID) != null){
            toId = getIntent().getStringExtra(Constants.ID);
        }
        getMessages();
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
    private void getMessages(){
        WebServiceFactory.getInstance().init(this);
        PreferenceHelper.getInstance().init(this);
        GetMaeesageByIdRequest profileRequest = new GetMaeesageByIdRequest();
        profileRequest.getFilterCaregiver().setUserId(PreferenceHelper.getInstance().getString(Constants.GIVER_ID, ""));

        WebServiceFactory.getInstance().apiGetMessages(profileRequest, new ApiCallBack2() {
            @Override
            public void onSuccess(MainResponse2 mainResponse) {
                ArrayList<Message> messageArrayList = new ArrayList<>();

                for (int i= 0; i < mainResponse.getResultResponse().getMessages().size(); i++){
                    Message message;
                    if(mainResponse.getResultResponse().getMessages().get(i).getFromUserID().equalsIgnoreCase(PreferenceHelper.getInstance().getString(Constants.GIVER_ID,""))){
                        message = new Message( mainResponse.getResultResponse().getMessages().get(i).getMessageText(),null,true);
                    }else {
                        message = new Message( mainResponse.getResultResponse().getMessages().get(i).getMessageText(),null,false);
                    }
                     messageArrayList.add(message);


                }
                messageAdapter = new MessageAdapter(ChatActivity.this,messageArrayList);
                messagesView.setAdapter(messageAdapter);

            }
        });
    }
    public void sendMessage(View view) {
        PreferenceHelper.getInstance().init(this);
        CreateMessageRequest createMessageRequest = new CreateMessageRequest();
        createMessageRequest.setFromUserID(PreferenceHelper.getInstance().getString(Constants.GIVER_ID,""));
        createMessageRequest.setToUserID(toId);
        createMessageRequest.setMessageText(editTextMessage.getText().toString());
        WebServiceFactory.getInstance().init(this);
        WebServiceFactory.getInstance().apiInsertMessage(createMessageRequest, new ApiCallback() {
            @Override
            public void onSuccess(MainResponse mainResponse) {
                String message = editTextMessage.getText().toString();
                MemberData memberData = new MemberData();

                Message message1 = new Message(editTextMessage.getText().toString(),memberData,true);
                if (message.length() > 0) {
                    publishMessage(message1);
                    editTextMessage.getText().clear();
                }
            }
        });

    }
    private void publishMessage(Message message){

        messageAdapter.add(message);
        messagesView.setSelection(messagesView.getCount() - 1);
    }
}
