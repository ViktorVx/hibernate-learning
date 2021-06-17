package org.pva.leonidas.telegram.bot.mapper;

import org.mapstruct.Mapper;
import org.pva.leonidas.common.dto.TelegramUserDto;
import org.telegram.telegrambots.meta.api.objects.User;

@Mapper(componentModel = "spring")
public interface TelegramUserMapper {

    TelegramUserDto toTelegramUserDto(User user);
}
