package com.switchapi.chat.bot.api.v1.model;

public class BotCallbackQuery {
    private Message message;
    private String data;

    public BotCallbackQuery(Message message, String data) {
        this.message = message;
        this.data = data;
    }

    public Message getMessage() {
        return message;
    }

    public String getData() {
        return data;
    }
}
