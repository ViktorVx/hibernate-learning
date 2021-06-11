package org.pva.leonidas.starter.service;

import lombok.AllArgsConstructor;
import org.pva.leonidas.starter.autoconfiguration.LeonidasStoreProperties;

@AllArgsConstructor
public class LeonidasBhService {

    private final LeonidasStoreProperties leonidasStoreProperties;

    public String saveTelegramUser() {
        return String.format("SUCCESS. Host: %s, port: %s",
                leonidasStoreProperties.getHost(),
                leonidasStoreProperties.getPort());
    }

    public String getAllGoods() {
        return "GOOD_LIST";
    }

    public String getGoodById() {
        return "GOOD";
    }
}
