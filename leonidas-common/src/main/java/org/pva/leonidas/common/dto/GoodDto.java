package org.pva.leonidas.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GoodDto {

    private String id;
    private String title;
    private String gtin;
    private String description;
    private BigDecimal price;
}
