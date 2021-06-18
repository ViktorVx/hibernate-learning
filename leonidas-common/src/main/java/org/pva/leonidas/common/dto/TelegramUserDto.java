package org.pva.leonidas.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TelegramUserDto {
    private String id;
    private String firstName;
    private String lastName;
    private String userName;
    private String languageCode;
    private boolean bot;
}
