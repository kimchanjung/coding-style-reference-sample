package com.crawling.practice.commerce.mapper;

import com.crawling.practice.commerce.dto.OrderResponse;
import com.crawling.practice.commerce.entity.Order;
import com.crawling.practice.config.CommonMapperConfig;
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
