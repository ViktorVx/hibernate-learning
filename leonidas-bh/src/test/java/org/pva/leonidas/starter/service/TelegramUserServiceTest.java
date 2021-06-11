package org.pva.leonidas.starter.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.pva.leonidas.common.dto.TelegramUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class TelegramUserServiceTest {

    @Autowired
    private TelegramUserService telegramUserService;

    @Test
    @Transactional
    void saveTest() {
        // Arrange
        var id = "12345";
        var telegramUser = TelegramUserDto.builder()
                .id(id)
                .name("userName")
                .info("userInfo")
                .build();

        // Act
        telegramUserService.save(telegramUser);

        // Assert
        assertEquals(telegramUser, telegramUserService.findById(id));
    }
}