package org.pva.leonidas.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pva.leonidas.common.dto.TelegramUserDto;
import org.pva.leonidas.db.repository.CentralUserRepository;
import org.pva.leonidas.db.repository.TelegramUserRepository;
import org.pva.leonidas.mapper.TelegramUserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
public class TelegramUserService {

    private final TelegramUserRepository telegramUserRepository;
    private final CentralUserRepository centralUserRepository;
    private final TelegramUserMapper telegramUserMapper;

    @Transactional
    public void save(TelegramUserDto telegramUser) {
        log.info(String.valueOf(telegramUser));
        var telegramUserModel = telegramUserMapper.toTelegramUser(telegramUser);
        telegramUserRepository.save(telegramUserModel);
    }

    @Transactional
    public TelegramUserDto findById(String id) {
        var userModel = telegramUserRepository.findById(id);
        return userModel.map(telegramUserMapper::toTelegramUserDto).orElse(null);
    }
}
