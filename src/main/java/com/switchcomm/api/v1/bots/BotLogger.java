package com.switchapi.chat.bot.api.v1;

import java.util.ArrayList;
import java.util.List;

public class BotLogger {
    private List<String> lines = new ArrayList<>();

    public List<String> getLog() {
        return lines;
    }

    public void log(String message) {
        lines.add(message);
    }
}
