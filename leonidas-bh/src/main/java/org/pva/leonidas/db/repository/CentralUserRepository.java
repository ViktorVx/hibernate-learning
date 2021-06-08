package org.pva.leonidas.db.repository;

import org.pva.leonidas.db.model.user.CentralUserModel;
import org.pva.leonidas.db.model.user.TelegramUserModel;
import org.springframework.data.repository.CrudRepository;

public interface CentralUserRepository extends CrudRepository<CentralUserModel, String> {

    CentralUserModel findByTelegramUser(TelegramUserModel telegramUserModel);
}
