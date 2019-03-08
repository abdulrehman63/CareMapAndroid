
package com.square63.caremap.models.chatModule;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Message implements Serializable{

    @SerializedName("fromUser")
    @Expose
    private FromUser fromUser;
    @SerializedName("replyToMessage")
    @Expose
    private Object replyToMessage;
    @SerializedName("toUser")
    @Expose
    private ToUser toUser;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("fromUserID")
    @Expose
    private String fromUserID;
    @SerializedName("toUserID")
    @Expose
    private String toUserID;
    @SerializedName("replyToMessageID")
    @Expose
    private Object replyToMessageID;
    @SerializedName("insertDate")
    @Expose
    private String insertDate;
    @SerializedName("messageTitle")
    @Expose
    private String messageTitle;
    @SerializedName("messageText")
    @Expose
    private String messageText;
    @SerializedName("messageType")
    @Expose
    private String messageType;
    @SerializedName("messageStatus")
    @Expose
    private Object messageStatus;
    @SerializedName("isRead")
    @Expose
    private String isRead;
    @SerializedName("isDeleted")
    @Expose
    private String isDeleted;

    public FromUser getFromUser() {
        return fromUser;
    }

    public void setFromUser(FromUser fromUser) {
        this.fromUser = fromUser;
    }

    public Object getReplyToMessage() {
        return replyToMessage;
    }

    public void setReplyToMessage(Object replyToMessage) {
        this.replyToMessage = replyToMessage;
    }

    public ToUser getToUser() {
        return toUser;
    }

    public void setToUser(ToUser toUser) {
        this.toUser = toUser;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFromUserID() {
        return fromUserID;
    }

    public void setFromUserID(String fromUserID) {
        this.fromUserID = fromUserID;
    }

    public String getToUserID() {
        return toUserID;
    }

    public void setToUserID(String toUserID) {
        this.toUserID = toUserID;
    }

    public Object getReplyToMessageID() {
        return replyToMessageID;
    }

    public void setReplyToMessageID(Object replyToMessageID) {
        this.replyToMessageID = replyToMessageID;
    }

    public String getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(String insertDate) {
        this.insertDate = insertDate;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public Object getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(Object messageStatus) {
        this.messageStatus = messageStatus;
    }

    public String getIsRead() {
        return isRead;
    }

    public void setIsRead(String isRead) {
        this.isRead = isRead;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

}
