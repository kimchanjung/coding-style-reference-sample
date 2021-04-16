package com.commerce.practice.ordersystem.mappers;

import com.commerce.practice.configuration.CommonMapperConfig;
import com.commerce.practice.ordersystem.dto.StoreResponse;
import com.commerce.practice.ordersystem.entity.Store;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Created by kimchanjung on 2021-04-15 오후 10:25
 */
@Mapper(config = CommonMapperConfig.class)
public interface StoreMapper {
    StoreMapper INSTANCE = Mappers.getMapper(StoreMapper.class);

    @Mapping(target = "businessHours", ignore = true)
    @Mapping(target = "businessHours.offDay", source = "offDay")
    @Mapping(target = "businessHours.run24", source = "run24")
    @Mapping(target = "businessHours.openTime", source = "openTime")
    @Mapping(target = "businessHours.closeTime", source = "closeTime")
    StoreResponse toDto(Store store);

    List<StoreResponse> toDto(List<Store> store);
}
