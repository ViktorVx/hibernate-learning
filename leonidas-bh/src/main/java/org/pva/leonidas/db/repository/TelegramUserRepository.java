package org.pva.leonidas.db.repository;

import org.pva.leonidas.db.model.user.TelegramUserModel;
import org.springframework.data.repository.CrudRepository;

public interface TelegramUserRepository extends CrudRepository<TelegramUserModel, String> {
}
