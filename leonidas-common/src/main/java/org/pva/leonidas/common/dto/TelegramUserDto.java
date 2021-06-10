package org.pva.leonidas.common.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TelegramUserDto {
    private String id;
    private String name;
    private String info;
}
