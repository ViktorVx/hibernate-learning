package org.pva.leonidas.telegram.bot.chatbot;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pva.leonidas.telegram.bot.provider.GoodsInfoProvider;
import org.pva.leonidas.telegram.bot.provider.UserInfoProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@Slf4j
@AllArgsConstructor
public class LeonidasBot extends TelegramLongPollingBot {

    @Value("${telegram.bot.leonidas_store_bot.name}")
    private final  String botName;
    @Value("${telegram.bot.leonidas_store_bot.token}")
    private final String botToken;

    private final UserInfoProvider userInfoProvider;
    private final GoodsInfoProvider goodsInfoProvider;

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update != null && update.getMessage() != null)
            log.info(update.getMessage().getText());
    }
}
