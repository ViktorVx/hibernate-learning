package org.pva.leonidas.mapper;

import org.mapstruct.Mapper;
import org.pva.leonidas.controller.dto.TelegramUserDto;
import org.pva.leonidas.db.model.TelegramUser;

@Mapper(componentModel = "spring")
public interface TelegramUserMapper {

    TelegramUserDto toTelegramUserDto(TelegramUser telegramUser);

    TelegramUser toTelegramUser(TelegramUserDto telegramUserDto);
}
