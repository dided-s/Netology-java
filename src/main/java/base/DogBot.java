package base;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

// https://github.com/rubenlagus/TelegramBots/blob/aad139de980ae25ee7a4b06bbe7644c6077421ce/TelegramBots.wiki/Getting-Started.md
public class DogBot extends TelegramLongPollingBot {

    String botName;
    String botToken;

    public DogBot(String botName, String botToken) {
        this.botName = botName;
        this.botToken = botToken;

        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(this);
        } catch (TelegramApiException e) {
            System.out.println("Не получилось зарегистрировать бота");
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            long chatId = update.getMessage().getChatId();
            String messageText = update.getMessage().getText();

            System.out.println("Log: " + chatId + ": " + messageText);

            switch (messageText) {
                case "/start":
                    sendMessage(chatId, "Здравствуйте");
                    break;
                case "/help":
                    sendMessage(chatId, "Тут помощь");
                    break;
                default:
                    String dogImage = DogImageReceiver.getDogImage(messageText);
                    sendMessage(chatId, dogImage);
            }
        }
    }

    private void sendMessage(long chatId, String messageText) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(messageText);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }
}
