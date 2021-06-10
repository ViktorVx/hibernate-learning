package org.pva.leonidas.telegram.bot.provider;

import org.springframework.stereotype.Component;

@Component
public class UserInfoProvider {

    public String getUserInfo() {
        return "User info";
    }

    public boolean storeUserInfo() {
        return true;
    }
}
