
package com.square63.caremap.models.chatModule;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class CreateMessageRequest {

    @SerializedName("FromUserID")
    @Expose
    private String fromUserID;
    @SerializedName("ToUserID")
    @Expose
    private String toUserID;
    @SerializedName("ReplyToMessageID")
    @Expose
    private Object replyToMessageID = null;
    @SerializedName("InsertDate")
    @Expose
    private String insertDate = new Date().toString();
    @SerializedName("MessageTitle")
    @Expose
    private String messageTitle = "lfdkhg";
    @SerializedName("MessageText")
    @Expose
    private String messageText;
    @SerializedName("MessageType")
    @Expose
    private String messageType ="new";
    @SerializedName("MessageStatus")
    @Expose
    private Object messageStatus = null;
    @SerializedName("IsRead")
    @Expose
    private String isRead="no";
    @SerializedName("IsDeleted")
    @Expose
    private String isDeleted = "no";

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
