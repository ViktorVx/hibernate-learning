package org.pva.leonidas.controller.dto;

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
