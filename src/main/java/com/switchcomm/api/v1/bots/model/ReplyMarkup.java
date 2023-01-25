package com.switchapi.chat.bot.api.v1.model;

import java.util.ArrayList;
import java.util.List;

/**
 * ReplyMarkup is the model that represents the keyboard
 * presented to the user when the bot sends a message
 * 
 * 
 * @author <a href="mailto:pablo@pramirez.dev">Pablo Ramirez</a>
 */
public class ReplyMarkup {
    List<List<InlineKeyboardButton>> inlineKeyboard = new ArrayList<>();

    public List<List<InlineKeyboardButton>> getInlineKeyboard() {
        return inlineKeyboard;
    }

    public void setInlineKeyboard(List<List<InlineKeyboardButton>> inlineKeyboard) {
        this.inlineKeyboard = inlineKeyboard;
    }

}
