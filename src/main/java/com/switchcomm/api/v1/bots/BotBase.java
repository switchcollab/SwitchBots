package com.switchapi.chat.bot.api.v1;

import java.util.List;

import com.switchapi.chat.bot.api.v1.model.BotCommand;

/**
 * BotBase is the base class for all bots
 * 
 * 
 * @author <a href="mailto:pablo@pramirez.dev">Pablo Ramirez</a>
 */
public abstract class BotBase {

    /**
     * Invoke bot
     * 
     * @param ctx - bot context
     */
    public abstract void invoke(IBotContext ctx);

    /**
     * Return list of commands that bot can handle
     * 
     * @return
     */
    public abstract List<BotCommand> getCommands();

    /**
     * Return bot description
     * 
     * @return
     */
    public String getBotDescription() {
        return "";
    }

    public boolean hasCommand(String command) {
        if (getCommands() == null)
            return false;

        return getCommands().stream().anyMatch(c -> c.getCommand().equals(command));
    }
}
