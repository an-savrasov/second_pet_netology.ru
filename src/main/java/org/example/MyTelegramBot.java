package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.IOException;

public class MyTelegramBot extends TelegramLongPollingBot {
    static Token token = new Token();
   public static final String BOT_TOKEN = token.getToken();

    public static final String BOT_USERNAME = "savrasov_nasa_bot";

    static Configuration configuration = new Configuration();
    public static final String URL = configuration.getUrl();

    public static long chat_id;

    public MyTelegramBot() throws TelegramApiException {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(this);
    }

    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            chat_id = update.getMessage().getChatId();
            switch (update.getMessage().getText()) {
                case "/start":
                    sendMessage("Привет");
                    break;
                case "/help":
                    sendMessage("Я высылаю ссылки на картинки по запросу. " +
                            "Для получения картинки введите /give. Картинки на сайте NASA обновляются раз в сутки");
                    break;
                case "/give":
                    try {
                        sendMessage(Utils.getUrl(URL));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                default:
                    sendMessage("Я не понимаю. Воспользуйтесь командой /help");
            }
        }
    }


    private void sendMessage(String messageText) {
        SendMessage message = new SendMessage();
        message.setChatId(chat_id);
        message.setText(messageText);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}