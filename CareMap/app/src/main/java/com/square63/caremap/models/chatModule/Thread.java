
package com.square63.caremap.models.chatModule;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Thread implements Serializable{

    @SerializedName("firstUser")
    @Expose
    private String firstUser;
    @SerializedName("secondUser")
    @Expose
    private String secondUser;
    @SerializedName("messages")
    @Expose
    private ArrayList<Message> messages = null;
    @SerializedName("id")
    @Expose
    private String id;

    public String getFirstUser() {
        return firstUser;
    }

    public void setFirstUser(String firstUser) {
        this.firstUser = firstUser;
    }

    public String getSecondUser() {
        return secondUser;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    public void setSecondUser(String secondUser) {
        this.secondUser = secondUser;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
