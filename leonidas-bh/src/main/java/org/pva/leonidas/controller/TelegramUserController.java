package org.pva.leonidas.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pva.leonidas.common.dto.TelegramUserDto;
import org.pva.leonidas.service.TelegramUserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/telegramUser")
@AllArgsConstructor
@Slf4j
public class TelegramUserController {

    private final TelegramUserService telegramUserService;

    @PostMapping(path = "/save", consumes = "application/json", produces = "application/json")
    public void save(@RequestBody TelegramUserDto telegramUser) {
        telegramUserService.save(telegramUser);
    }

    @GetMapping("/byId/{id}")
    public TelegramUserDto findById(@PathVariable String id) {
        return telegramUserService.findById(id);
    }
}
