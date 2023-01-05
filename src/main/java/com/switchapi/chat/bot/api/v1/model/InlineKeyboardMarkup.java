package com.switchapi.chat.bot.api.v1.model;

import java.util.ArrayList;
import java.util.List;

/**
 * InlineKeyboardMarkup is the model that represents the keyboard
 * presented to the user when the bot sends a message
 * 
 * 
 * @author <a href="mailto:pablo@pramirez.dev">Pablo Ramirez</a>
 */
public class InlineKeyboardMarkup extends ReplyMarkup {
    List<List<InlineKeyboardButton>> inlineKeyboard;

    public InlineKeyboardMarkup() {
        this.inlineKeyboard = new ArrayList<>();
    }

    public void addRow(List<InlineKeyboardButton> row) {
        inlineKeyboard.add(row);
    }

    public List<List<InlineKeyboardButton>> getInlineKeyboard() {
        return inlineKeyboard;
    }

    @Override
    public String toString() {
        return "InlineKeyboardMarkup [inlineKeyboard=" + inlineKeyboard + "]";
    }
}
