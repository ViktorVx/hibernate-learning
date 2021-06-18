package org.pva.leonidas.starter.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pva.leonidas.common.dto.TelegramUserDto;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Slf4j
public class LeonidasBhService {

    private final WebClient webClient;

    public void storeTelegramUser(TelegramUserDto telegramUserDto) {
        webClient.post()
                .uri("/telegramUser/save")
                .body(Mono.just(telegramUserDto), TelegramUserDto.class)
                .retrieve()
                .bodyToMono(TelegramUserDto.class)
                .subscribe();
    }

    public String getAllGoods() {
        return "GOOD_LIST";
    }

    public String getGoodById() {
        return "GOOD";
    }
}
