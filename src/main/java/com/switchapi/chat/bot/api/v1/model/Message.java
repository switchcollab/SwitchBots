package com.switchapi.chat.bot.api.v1.model;

import java.sql.Timestamp;

/**
 * Message is the model that represents the message that the bot receives
 * or sends
 * 
 * 
 * @author <a href="mailto:pablo@pramirez.dev">Pablo Ramirez</a>
 */
public class Message {
    private long id;
    private String requestId;
    private long userId;
    private String groupId;
    private String message;
    private String information;
    private String mediaLink;
    private long receiverId;
    private Timestamp sentDate;
    private String channelId;
    private String communityId;
    private boolean flag;
    private boolean isEdit;
    private String mentionedIds;
    private String callbackData;
    private InlineKeyboardMarkup inlineKeyboard;

    public Message() {
        this.sentDate = new Timestamp(System.currentTimeMillis());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getMediaLink() {
        return mediaLink;
    }

    public void setMediaLink(String mediaLink) {
        this.mediaLink = mediaLink;
    }

    public long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(long receiverId) {
        this.receiverId = receiverId;
    }

    public Timestamp getSentDate() {
        return sentDate;
    }

    public void setSentDate(Timestamp sentDate) {
        this.sentDate = sentDate;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getCommunityId() {
        return communityId;
    }

    public void setCommunityId(String communityId) {
        this.communityId = communityId;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isEdit() {
        return isEdit;
    }

    public void setEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }

    public String getMentionedIds() {
        return mentionedIds;
    }

    public void setMentionedIds(String mentionedIds) {
        this.mentionedIds = mentionedIds;
    }

    public String getCallbackData() {
        return callbackData;
    }

    public void setCallbackData(String callbackData) {
        this.callbackData = callbackData;
    }

    public InlineKeyboardMarkup getInlineKeyboard() {
        return inlineKeyboard;
    }

    public void setInlineKeyboard(InlineKeyboardMarkup inlineKeyboard) {
        this.inlineKeyboard = inlineKeyboard;
    }

    @Override
    public String toString() {
        return "Message [id=" + id + ", requestId=" + requestId + ", userId=" + userId + ", groupId=" + groupId
                + ", message=" + message + ", information=" + information + ", mediaLink=" + mediaLink + ", receiverId="
                + receiverId + ", sentDate=" + sentDate + ", channelId=" + channelId + ", communityId=" + communityId
                + ", flag=" + flag + ", isEdit=" + isEdit + ", mentionedIds=" + mentionedIds + ", callbackData="
                + callbackData + ", inlineKeyboard=" + inlineKeyboard + "]";
    }
}
