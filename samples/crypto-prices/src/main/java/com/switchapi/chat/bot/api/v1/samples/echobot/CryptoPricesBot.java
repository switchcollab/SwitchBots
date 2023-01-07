package com.switchapi.chat.bot.api.v1.samples.echobot;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.switchapi.chat.bot.api.v1.*;
import com.switchapi.chat.bot.api.v1.model.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pramirez
 */
public class CryptoPricesBot extends BotBase {
    private static final String API_ENDPONT = "https://api.coingecko.com/api/v3/coins/%s?localization=false&tickers=false&market_data=true&community_data=false&developer_data=false&sparkline=false";

    /**
     * Returns a JSON sub-element from the given JsonElement and the given path
     *
     * @param json - a Gson JsonElement
     * @param path - a JSON path, e.g. a.b.c[2].d
     * @return - a sub-element of json according to the given path
     */
    public static JsonElement getJsonElement(JsonElement json, String path) {

        String[] parts = path.split("\\.|\\[|\\]");
        JsonElement result = json;

        for (String key : parts) {

            key = key.trim();
            if (key.isEmpty())
                continue;

            if (result == null) {
                result = JsonNull.INSTANCE;
                break;
            }

            if (result.isJsonObject()) {
                result = ((JsonObject) result).get(key);
            } else if (result.isJsonArray()) {
                int ix = Integer.valueOf(key) - 1;
                result = ((JsonArray) result).get(ix);
            } else
                break;
        }

        return result;
    }

    private String getPrice(String currency) throws IOException {
        URL url = new URL(String.format(API_ENDPONT, currency));
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        // Read the response
        java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();
        String jsonResponse = content.toString();
        Gson gson = new Gson();

        JsonObject jsonObject = gson.fromJson(jsonResponse, JsonObject.class);
        JsonElement price = getJsonElement(jsonObject, "market_data.current_price.usd");

        return price.getAsString();
    }

    private void showPriceForCurrency(IBotContext ctx, Message original, String currency) {
        try {
            original.setMessage("Price for " + currency + " is: USD" + getPrice(currency));

        } catch (Exception e) {
            original.setMessage("Error getting price for " + currency + ": " + e.getMessage());
        }
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        markup.addRow(new ArrayList<InlineKeyboardButton>() {
            {
                add(new InlineKeyboardButton("Back", "main_menu"));
            }
        });
        ctx.editMessage(original);
    }

    private void showMainMenu(IBotContext ctx, Message original, boolean isCallabck, String messageText) {
        Message m = isCallabck ? ctx.getRequest().getCallbackQuery().getMessage() : ctx.getRequest().getMessage();
        if (messageText == null) {
            messageText = "Please select a currency";
        }
        if (!isCallabck) {
            m = ctx.makeResponseMessage(m);
        }

        m.setMessage(messageText);
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        markup.addRow(new ArrayList<InlineKeyboardButton>() {
            {
                add(new InlineKeyboardButton("BTC", "btc_price"));
                add(new InlineKeyboardButton("ETH", "eth_price"));
            }
        });
        markup.addRow(new ArrayList<InlineKeyboardButton>() {
            {
                add(new InlineKeyboardButton("LTC", "ltc_price"));
                add(new InlineKeyboardButton("XRP", "xrp_price"));
            }
        });
        m.setInlineKeyboard(markup);

        if (!isCallabck) {
            ctx.createMessage(m);
        } else {
            ctx.editMessage(m);
        }

    }

    @Override
    public void invoke(IBotContext ctx) {
        BotRequest req = ctx.getRequest();

        if (req.hasMessage()) {
            Message m = req.getMessage();
            String text = m.getMessage();
            if (text.trim().equalsIgnoreCase("/prices")) {
                showMainMenu(ctx, m, false, null);
            } else if (text.matches("/price\\s+(\\w+)")) {
                showPriceForCurrency(ctx, m, text.split("\\s+")[1].trim());
            } else {
                Message response = ctx.makeResponseMessage(m);
                response.setMessage(
                        "Usage:\r\n/prices - get prices of crypto currencies\r\n/price [currency]- get the price of one crypto currency");
                ctx.createMessage(response);
            }
        } else if (req.hasCallbackQuery()) {
            Message m = req.getCallbackQuery().getMessage();
            String data = req.getCallbackQuery().getData();
            if (data.equals("main_menu")) {
                showMainMenu(ctx, m, true, null);
            } else {
                switch (data) {
                    case "btc_price":
                        showPriceForCurrency(ctx, m, "bitcoin");
                        break;
                    case "eth_price":
                        showPriceForCurrency(ctx, m, "ethereum");
                        break;
                    case "ltc_price":
                        showPriceForCurrency(ctx, m, "litecoin");
                        break;
                    case "xrp_price":
                        showPriceForCurrency(ctx, m, "ripple");
                        break;
                    default:
                        showMainMenu(ctx, m, true, "Invalid option, please select a currency");
                        break;
                }
            }
        }

    }

    @Override
    public List<BotCommand> getCommands() {
        return new ArrayList<BotCommand>() {
            {
                add(new BotCommand("/prices", "get prices of crypto currencies", false));
            }
            {
                add(new BotCommand("/price", "get the price of one crypto currency", true));
            }
        };
    }

}
