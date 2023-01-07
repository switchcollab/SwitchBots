package com.switchapi.chat.bot.api.v1.samples.echobot;

import com.switchapi.chat.bot.api.v1.*;
import com.switchapi.chat.bot.api.v1.model.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pramirez
 */
public class EchoBot extends BotBase {

    

    @Override
    public void invoke(IBotContext ctx) {
        BotRequest req = ctx.getRequest();

        if (req.hasMessage()) {
            Message m = req.getMessage();
            String text = m.getMessage();
            Message response = ctx.makeResponseMessage(m);
            if (text.trim().equalsIgnoreCase("/test")) {
                response.setMessage("You have invoked test command");
                ctx.createMessage(response);
            } else if (text.trim().equalsIgnoreCase("/test2")) {

                response.setMessage("You have invoked test command 2");
                InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
                markup.addRow(new ArrayList<InlineKeyboardButton>() {
                    {
                        add(new InlineKeyboardButton("Button 01", "button1"));
                        add(new InlineKeyboardButton("Button 02", "button2"));
                    }
                });
                response.setInlineKeyboard(markup);
                ctx.createMessage(response);
            }
        } else if (req.hasCallbackQuery()) {
            System.out.println("Callback query " + req.getCallbackQuery().getData());
            Message m = req.getCallbackQuery().getMessage();
            String data = req.getCallbackQuery().getData();
            if (data.equals("button1")) {
                m.setMessage("You have clicked button 1");
                ctx.editMessage(m);
            } else if (data.equals("button2")) {
                m.setMessage("You have clicked button 2");
                ctx.editMessage(m);
            }
        }
        System.out.println(ctx.getRequest());
    }

    @Override
    public List<BotCommand> getCommands() {
        return new ArrayList<BotCommand>() {
            {
                add(new BotCommand("/test", "test command", false));
            }
            {
                add(new BotCommand("/test2", "test command 2", true));
            }
        };
    }

}
