package org.pva.leonidas.service;

import lombok.AllArgsConstructor;
import org.pva.leonidas.db.model.TelegramUser;
import org.pva.leonidas.db.repository.TelegramUserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TelegramUserService {

    private final TelegramUserRepository telegramUserRepository;

    public void save(TelegramUser telegramUser) {
        telegramUserRepository.save(telegramUser);
    }

    public Optional<TelegramUser> findById(String id) {
        return telegramUserRepository.findById(id);
    }
}
