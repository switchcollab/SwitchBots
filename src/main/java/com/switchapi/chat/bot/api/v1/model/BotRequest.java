package com.switchapi.chat.bot.api.v1.model;

/*
 * BotRequest is the model that represents the request that the bot receives
 * 
 * @author <a href="mailto:pablo@pramirez.dev">Pablo Ramirez</a>
 */
public class BotRequest {
    /**
     * The message that the bot receives
     */
    private Message message;

    /**
     * The callback query that the bot receives
     */
    private BotCallbackQuery callbackQuery;

    public BotRequest(Message message) {
        this.message = message;
    }

    public BotRequest(BotCallbackQuery callbackQuery) {
        this.callbackQuery = callbackQuery;
    }

    public BotRequest(Message message, BotCallbackQuery callbackQuery) {
        this.message = message;
        this.callbackQuery = callbackQuery;
    }

    public Message getMessage() {
        return message;
    }

    public BotCallbackQuery getCallbackQuery() {
        return callbackQuery;
    }

    public boolean hasCallbackQuery() {
        return callbackQuery != null;
    }

    public boolean hasMessage() {
        return message != null;
    }

}
