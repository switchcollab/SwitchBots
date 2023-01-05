package com.switchapi.chat.bot.api.v1.model;

/**
 * BotCommand is the model that represents a command that the bot can execute
 * 
 * 
 * @author <a href="mailto:pablo@pramirez.dev">Pablo Ramirez</a>
 */
public class BotCommand {
    /**
     * The command that the bot will execute
     * <p>
     * Example <b>/start</b>
     */
    String command;
    /**
     * The description of the command
     */
    String description;
    /**
     * Indicates if the command can be executed in a channel
     */
    Boolean chanel;

    public BotCommand(String command, String description, Boolean chanel) {
        this.command = command;
        this.description = description;
        this.chanel = chanel;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getChanel() {
        return chanel;
    }

    public void setChanel(Boolean chanel) {
        this.chanel = chanel;
    }

}
