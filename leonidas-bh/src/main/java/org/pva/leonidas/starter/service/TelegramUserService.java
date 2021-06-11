package org.pva.leonidas.starter.service;

import lombok.AllArgsConstructor;
import org.pva.leonidas.common.dto.TelegramUserDto;
import org.pva.leonidas.db.model.user.CentralUserModel;
import org.pva.leonidas.db.repository.CentralUserRepository;
import org.pva.leonidas.db.repository.TelegramUserRepository;
import org.pva.leonidas.mapper.TelegramUserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@AllArgsConstructor
public class TelegramUserService {

    private final TelegramUserRepository telegramUserRepository;
    private final CentralUserRepository centralUserRepository;
    private final TelegramUserMapper telegramUserMapper;

    @Transactional
    public void save(TelegramUserDto telegramUser) {
        var telegramUserModel = telegramUserMapper.toTelegramUser(telegramUser);
        telegramUserRepository.save(telegramUserModel);

        var centralUser = centralUserRepository.findByTelegramUser(telegramUserModel);
        if (centralUser == null) {
            centralUser = CentralUserModel.builder()
                    .id(UUID.randomUUID().toString())
                    .telegramUser(telegramUserModel)
                    .build();
            centralUserRepository.save(centralUser);
        }
    }

    @Transactional
    public TelegramUserDto findById(String id) {
        var userModel = telegramUserRepository.findById(id);
        return userModel.map(telegramUserMapper::toTelegramUserDto).orElse(null);
    }
}
