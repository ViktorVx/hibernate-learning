package org.pva.leonidas.mapper;

import org.mapstruct.Mapper;
import org.pva.leonidas.common.dto.TelegramUserDto;
import org.pva.leonidas.db.model.user.TelegramUserModel;

@Mapper(componentModel = "spring")
public interface TelegramUserMapper {

    TelegramUserDto toTelegramUserDto(TelegramUserModel telegramUserModel);

    TelegramUserModel toTelegramUser(TelegramUserDto telegramUserDto);
}
