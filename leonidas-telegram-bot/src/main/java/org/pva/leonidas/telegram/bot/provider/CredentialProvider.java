package org.pva.leonidas.telegram.bot.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CredentialProvider {

    @Value("${telegram.bot.leonidas_store_bot.name}")
    private String botName;
    @Value("${telegram.bot.leonidas_store_bot.token}")
    private String botToken;

    public String getBotName() {
        return botName;
    }

    public String getBotToken() {
        return botToken;
    }
}
