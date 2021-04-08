package com.codingstyle.practice.commerce.mapper;

import com.codingstyle.practice.commerce.dto.OrderResponse;
import com.codingstyle.practice.commerce.entity.Order;
import com.codingstyle.practice.config.CommonMapperConfig;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by kimchanjung on 2021-04-08 오후 6:54
 */

@Mapper(config = CommonMapperConfig.class)
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper( OrderMapper.class );

    OrderResponse toResponse(Order order);
}
