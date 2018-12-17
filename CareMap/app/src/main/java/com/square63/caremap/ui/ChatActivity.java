package com.square63.caremap.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.square63.caremap.R;
import com.square63.caremap.models.MemberData;
import com.square63.caremap.models.Message;
import com.square63.caremap.ui.adapters.MessageAdapter;

public class ChatActivity extends AppCompatActivity {

    private MessageAdapter messageAdapter;
    EditText editTextMessage;
    ListView messagesView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        init();
    }
    private void  init(){
        editTextMessage = (EditText) findViewById(R.id.editTextMessage);

        messageAdapter = new MessageAdapter(this);
        messagesView = (ListView) findViewById(R.id.messages_view);
        messagesView.setAdapter(messageAdapter);
    }
    public void sendMessage(View view) {
        String message = editTextMessage.getText().toString();
        MemberData memberData = new MemberData();

        Message message1 = new Message(editTextMessage.getText().toString(),memberData,true);
        if (message.length() > 0) {
            publishMessage(message1);
            editTextMessage.getText().clear();
        }
    }
    private void publishMessage(Message message){
        messageAdapter.add(message);
        messagesView.setSelection(messagesView.getCount() - 1);
    }
}
