package org.pva.leonidas.db.repository;

import org.pva.leonidas.db.model.TelegramUser;
import org.springframework.data.repository.CrudRepository;

public interface TelegramUserRepository extends CrudRepository<TelegramUser, String> {
}
