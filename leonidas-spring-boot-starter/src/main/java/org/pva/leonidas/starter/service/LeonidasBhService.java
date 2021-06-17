package org.pva.leonidas.starter.service;

import lombok.AllArgsConstructor;
import org.pva.leonidas.common.dto.TelegramUserDto;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@AllArgsConstructor
public class LeonidasBhService {

    private final WebClient webClient;

    public void storeTelegramUser(TelegramUserDto telegramUserDto) {
        var uriSpec = webClient.post();
        uriSpec.uri("/telegramUser/save");
        uriSpec.bodyValue(telegramUserDto);
        uriSpec.exchangeToMono(r -> Mono.empty());
    }

    public String getAllGoods() {
        return "GOOD_LIST";
    }

    public String getGoodById() {
        return "GOOD";
    }
}
