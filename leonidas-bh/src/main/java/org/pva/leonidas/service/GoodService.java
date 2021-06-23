package org.pva.leonidas.service;

import lombok.AllArgsConstructor;
import org.pva.leonidas.common.dto.GoodDto;
import org.pva.leonidas.common.dto.GoodListDto;
import org.pva.leonidas.db.repository.GoodRepository;
import org.pva.leonidas.mapper.GoodMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class GoodService {

    private final GoodRepository goodRepository;
    private final GoodMapper goodMapper;

    public void save(GoodDto goodDto) {
        var goodModel = goodMapper.toGoodModel(goodDto);
        goodRepository.save(goodModel);
    }

    public GoodDto findById(String id) {
        var goodModel = goodRepository.findById(id);
        return goodMapper.toGoodDto(goodModel.orElse(null));
    }

    public List<GoodListDto> findAll() {
        var goodModelList = goodRepository.findAll();
        return goodMapper.toGoodListDtoList(goodModelList);
    }
}
