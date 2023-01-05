/*
 * Copyright 2023 pramirez.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.switchapi.chat.bot.api.v1.samples.echobot;

import com.switchapi.chat.bot.api.v1.IBotContext;
import com.switchapi.chat.bot.api.v1.model.BotRequest;
import com.switchapi.chat.bot.api.v1.model.Message;
import com.switchapi.chat.bot.api.v1.testing.BotSandboxContext;

/**
 *
 * @author pramirez
 */
public class Main {

    public static void main(String[] args) {
        EchoBot bot = new EchoBot();
        Message m = new Message();
        m.setMessage("/echo");
        BotRequest req = new BotRequest(m, null);
        IBotContext ctx = new BotSandboxContext(req, null, null);
        bot.invoke(ctx);
        ctx.getLogger().getLog().forEach(System.out::println);
    }
}
