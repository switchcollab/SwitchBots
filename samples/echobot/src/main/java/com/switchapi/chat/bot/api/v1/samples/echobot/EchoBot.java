/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.switchapi.chat.bot.api.v1.samples.echobot;

import com.switchapi.chat.bot.api.v1.BotBase;
import com.switchapi.chat.bot.api.v1.IBotContext;
import com.switchapi.chat.bot.api.v1.model.BotCommand;
import com.switchapi.chat.bot.api.v1.model.Message;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pramirez
 */
public class EchoBot extends BotBase {

    @Override
    public void invoke(IBotContext ibc) {
        Message message=new Message();
        message.setMessage(ibc.getRequest().getMessage().getMessage());
        ibc.createMessage(message);
    }

    @Override
    public List<BotCommand> getCommands() {
       return new ArrayList<BotCommand>(){{
           add(new BotCommand("/echo", "Prints your message back", false));
       }};
    }
    
}
