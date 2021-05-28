package org.pva.leonidas.service;

import lombok.AllArgsConstructor;
import org.pva.leonidas.controller.dto.TelegramUserDto;
import org.pva.leonidas.db.repository.TelegramUserRepository;
import org.pva.leonidas.mapper.TelegramUserMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TelegramUserService {

    private final TelegramUserRepository telegramUserRepository;
    private final TelegramUserMapper telegramUserMapper;

    public void save(TelegramUserDto telegramUser) {
        var telegramUserModel = telegramUserMapper.toTelegramUser(telegramUser);
        telegramUserRepository.save(telegramUserModel);
    }

    public TelegramUserDto findById(String id) {
        var userModel = telegramUserRepository.findById(id);
        return userModel.map(telegramUserMapper::toTelegramUserDto).orElse(null);
    }
}
