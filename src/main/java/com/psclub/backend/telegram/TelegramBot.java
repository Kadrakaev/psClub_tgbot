package com.psclub.backend.telegram;

import com.psclub.backend.model.User;
import com.psclub.backend.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    private final UserService userService;

    @Value("${telegram.bot.username}")
    private String botUsername;

    @Value("${telegram.bot.token}")
    private String botToken;

    public TelegramBot(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            var msg = update.getMessage();
            var chatId = msg.getChatId().toString();
            var text = msg.getText();
            var username = msg.getFrom().getUserName();
            var fullName = msg.getFrom().getFirstName() + " " + msg.getFrom().getLastName();

            if (text.equals("/start")) {
                // Регистрируем пользователя
                User user = User.builder()
                        .telegramId(chatId)
                        .username(username)
                        .fullName(fullName)
                        .build();
                userService.registerUser(user);

                sendText(chatId, "Добро пожаловать в PS Club, " + fullName + "!");
            } else {
                sendText(chatId, "Команда не распознана. Используйте /start");
            }
        }
    }

    private void sendText(String chatId, String message) {
        SendMessage msg = new SendMessage();
        msg.setChatId(chatId);
        msg.setText(message);
        try {
            execute(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
