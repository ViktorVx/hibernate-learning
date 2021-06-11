package org.pva.leonidas.telegram.bot.provider;

import lombok.AllArgsConstructor;
import org.pva.leonidas.starter.service.LeonidasBhService;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserInfoProvider {

    private final LeonidasBhService leonidasBhService;

    public String getUserInfo() {
        return "User info";
    }

    public String storeUserInfo() {
        return leonidasBhService.saveTelegramUser();
    }
}
