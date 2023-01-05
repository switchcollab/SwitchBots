package com.switchapi.chat.bot.api.v1;

import com.switchapi.chat.bot.api.v1.model.BotRequest;
import com.switchapi.chat.bot.api.v1.model.Message;
import com.switchapi.chat.bot.api.v1.model.UserInfo;

/**
 * IBotContext is the interface that the bots use to interact with the chat
 * platform.
 * 
 * 
 * @author <a href="mailto:pablo@pramirez.dev">Pablo Ramirez</a>
 */
public interface IBotContext {
    /**
     * Returns the request that triggered the bot
     * 
     * @return
     */
    public BotRequest getRequest();

    /**
     * Returns the user that sent the message or the callback query
     * 
     * @return
     */
    public UserInfo getSender();

    /**
     * Returns the bot that is being invoked
     * 
     * @return
     */
    public UserInfo getBot();

    /**
     * Creates a new message in the chat
     * 
     * @param message
     */
    public void createMessage(Message message);

    /**
     * Edits a message in the chat
     * 
     * @param message
     */
    public void editMessage(Message message);

    /**
     * Deletes a message in the chat
     * 
     * @param message
     */
    public void deleteMessage(Message message);

    /**
     * Logs a message
     * 
     * @param message
     */
    public void log(String message);

    /**
     * Returns the logger
     * 
     * @return
     */
    public BotLogger getLogger();

    /**
     * Returns a new message that is a response to the original message
     * 
     * @param original
     * @return
     */
    public Message makeResponseMessage(Message original);
}
