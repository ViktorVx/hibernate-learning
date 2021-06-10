package org.pva.leonidas.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pva.leonidas.common.dto.GoodDto;
import org.pva.leonidas.common.dto.GoodListDto;
import org.pva.leonidas.service.GoodService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/good")
@AllArgsConstructor
@Slf4j
public class GoodController {

    private final GoodService goodService;

    @PostMapping(path = "/save", consumes = "application/json", produces = "application/json")
    public void save(@RequestBody GoodDto goodDto) {
        goodService.save(goodDto);
    }

    @GetMapping("/byId/{id}")
    public GoodDto findById(@PathVariable String id) {
        return goodService.findById(id);
    }

    @GetMapping("/all")
    public List<GoodListDto> findAll() {
        return goodService.findAll();
    }
}
