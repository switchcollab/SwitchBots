package com.switchapi.chat.bot.api.v1;

import com.switchapi.chat.bot.api.utils.StringUtils;
import com.switchapi.chat.bot.api.v1.model.BotRequest;
import com.switchapi.chat.bot.api.v1.model.Message;
import com.switchapi.chat.bot.api.v1.model.UserInfo;

/**
 * BotContextBase is the base class for the bot context
 * 
 * 
 * @author <a href="mailto:pablo@pramirez.dev"> Pablo Ramirez</a>
 */
public abstract class BotContextBase implements IBotContext {
    protected BotRequest request;
    protected UserInfo bot;
    protected UserInfo sender;
    protected BotLogger logger = new BotLogger();

    public BotContextBase(BotRequest request, UserInfo bot, UserInfo sender) {
        this.request = request;
        this.bot = bot;
        this.sender = sender;
    }

    @Override
    public BotRequest getRequest() {
        return request;
    }

    @Override
    public UserInfo getSender() {
        return sender;
    }

    @Override
    public UserInfo getBot() {
        return bot;
    }

    @Override
    public abstract void createMessage(Message message);

    @Override
    public abstract void editMessage(Message message);

    @Override
    public abstract void deleteMessage(Message message);

    @Override
    public void log(String message) {
        this.getLogger().log(message);

    }

    @Override
    public BotLogger getLogger() {
        return logger;
    }

    @Override
    public Message makeResponseMessage(Message original) {
        Message message = new Message();
        if (StringUtils.isNullOrEmpty(original.getChannelId()) && StringUtils.isNullOrEmpty(original.getGroupId())) {
            message.setReceiverId(original.getUserId());
        } else {
            message.setGroupId(original.getGroupId());
            message.setChannelId(original.getChannelId());
            message.setCommunityId(original.getCommunityId());
        }
        message.setUserId(Long.parseLong(bot.getId()));
        return message;
    }

}
