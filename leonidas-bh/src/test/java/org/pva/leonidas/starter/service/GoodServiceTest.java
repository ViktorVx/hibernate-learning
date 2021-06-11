package org.pva.leonidas.starter.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.pva.leonidas.common.dto.GoodDto;
import org.pva.leonidas.mapper.GoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class GoodServiceTest {

    @Autowired
    private GoodService goodService;
    @Autowired
    private GoodMapper goodMapper;

    @Test
    @Transactional
    void save() {
        // Arrange
        var goodDto = getGoodDto("0");

        // Act
        goodService.save(goodDto);

        // Assert
        assertEquals(goodDto, goodService.findById("id0"));

    }

    @Test
    @Transactional
    void findAll() {
        // Arrange
        goodService.save(getGoodDto("0"));
        goodService.save(getGoodDto("1"));
        goodService.save(getGoodDto("2"));

        // Act
        var goodDtoList = goodService.findAll();

        // Assert
        assertEquals(3, goodDtoList.size());
        assertTrue(goodDtoList.contains(goodMapper.toGoodListDtoFromGoodDto(getGoodDto("0"))));
        assertTrue(goodDtoList.contains(goodMapper.toGoodListDtoFromGoodDto(getGoodDto("1"))));
        assertTrue(goodDtoList.contains(goodMapper.toGoodListDtoFromGoodDto(getGoodDto("2"))));
    }

    private GoodDto getGoodDto(String postfix) {
        return GoodDto.builder()
                .id("id".concat(postfix))
                .title("title".concat(postfix))
                .description("description".concat(postfix))
                .gtin("gtin".concat(postfix))
                .price(BigDecimal.ONE)
                .build();
    }
}