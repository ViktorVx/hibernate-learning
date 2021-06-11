package org.pva.leonidas.telegram.bot.chatbot;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pva.leonidas.telegram.bot.provider.CredentialProvider;
import org.pva.leonidas.telegram.bot.provider.GoodsInfoProvider;
import org.pva.leonidas.telegram.bot.provider.UserInfoProvider;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@Slf4j
@AllArgsConstructor
public class LeonidasBot extends TelegramLongPollingBot {

    private final CredentialProvider credentialProvider;
    private final UserInfoProvider userInfoProvider;
    private final GoodsInfoProvider goodsInfoProvider;

    @Override
    public String getBotUsername() {
        return credentialProvider.getBotName();
    }

    @Override
    public String getBotToken() {
        return credentialProvider.getBotToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update != null && update.getMessage() != null) {
            log.info(update.getMessage().getText());
            log.info(userInfoProvider.storeUserInfo());
        }
    }
}
