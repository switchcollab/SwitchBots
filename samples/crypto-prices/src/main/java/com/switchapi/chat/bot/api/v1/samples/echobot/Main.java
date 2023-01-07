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
import com.switchapi.chat.bot.api.v1.model.BotCallbackQuery;
import com.switchapi.chat.bot.api.v1.model.BotRequest;
import com.switchapi.chat.bot.api.v1.model.Message;
import com.switchapi.chat.bot.api.v1.model.UserInfo;
import com.switchapi.chat.bot.api.v1.testing.BotSandboxContext;

/**
 *
 * @author pramirez
 */
public class Main {

    public static void main(String[] args) {
        CryptoPricesBot bot = new CryptoPricesBot();
        Message m = new Message();
        UserInfo user = new UserInfo();
        user.setId("1");
        m.setUserId(1);
        m.setReceiverId(235L);
        UserInfo botInfo = new UserInfo();
        botInfo.setId("235");
        m.setMessage("/prices");
        BotRequest req = new BotRequest(m, null);
        IBotContext ctx = new BotSandboxContext(req, botInfo, user);
        bot.invoke(ctx);

        req = new BotRequest(null, new BotCallbackQuery(m, "btc_price"));
        ctx = new BotSandboxContext(req, botInfo, user);
        bot.invoke(ctx);

        req = new BotRequest(null, new BotCallbackQuery(m, "eth_price"));
        ctx = new BotSandboxContext(req, botInfo, user);
        bot.invoke(ctx);

        req = new BotRequest(null, new BotCallbackQuery(m, "ltc_price"));
        ctx = new BotSandboxContext(req, botInfo, user);
        bot.invoke(ctx);

        req = new BotRequest(null, new BotCallbackQuery(m, "xrp_price"));
        ctx = new BotSandboxContext(req, botInfo, user);
        bot.invoke(ctx);

        m.setMessage("/price bitcoin");
        req = new BotRequest(m, null);
        ctx = new BotSandboxContext(req, botInfo, user);
        bot.invoke(ctx);

        ctx.getLogger().getLog().forEach(System.out::println);
    }
}
