package org.pva.leonidas.mapper;

import org.mapstruct.Mapper;
import org.pva.leonidas.common.dto.GoodDto;
import org.pva.leonidas.common.dto.GoodListDto;
import org.pva.leonidas.db.model.good.GoodModel;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GoodMapper {

    GoodListDto toGoodListDtoFromGoodDto(GoodDto goodDto);

    GoodDto toGoodDto(GoodModel goodModel);

    GoodListDto toGoodListDto(GoodModel goodModel);

    List<GoodListDto> toGoodListDtoList(Iterable<GoodModel> goodModelList);

    GoodModel toGoodModel(GoodDto goodDto);
}
