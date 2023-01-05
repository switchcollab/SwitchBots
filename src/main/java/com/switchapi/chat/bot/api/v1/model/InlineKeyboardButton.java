package com.switchapi.chat.bot.api.v1.model;

/**
 * InlineKeyboardButton is the model that represents a button that the bot can
 * execute
 * 
 * 
 * @author <a href="mailto:pablo@pramirez.dev">Pablo Ramirez</a>
 */
public class InlineKeyboardButton {
    String text;
    String callbackData;
    String url;

    public InlineKeyboardButton(String text, String callbackData) {
        this.text = text;
        this.callbackData = callbackData;
    }

    public InlineKeyboardButton() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCallbackData() {
        return callbackData;
    }

    public void setCallbackData(String callbackData) {
        this.callbackData = callbackData;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "InlineKeyboardButton [text=" + text + ", callbackData=" + callbackData + ", url=" + url + "]";
    }
}
