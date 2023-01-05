package com.switchapi.chat.bot.api.v1.testing;

import com.switchapi.chat.bot.api.v1.BotContextBase;
import com.switchapi.chat.bot.api.v1.model.BotRequest;
import com.switchapi.chat.bot.api.v1.model.Message;
import com.switchapi.chat.bot.api.v1.model.UserInfo;

public class BotSandboxContext extends BotContextBase {

    public BotSandboxContext(BotRequest request, UserInfo bot, UserInfo sender) {
        super(request, bot, sender);
    }

    @Override
    public void createMessage(Message message) {
        this.log("Save message: " + message);
    }

    @Override
    public void deleteMessage(Message message) {
        this.log("Delete message: " + message);
    }

    @Override
    public void editMessage(Message message) {
        this.log("Edit message: " + message);
    }

}
