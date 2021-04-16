package com.commerce.practice.mappers;

import com.commerce.practice.configuration.CommonMapperConfig;
import com.commerce.practice.entity.Order;
import com.commerce.practice.entity.OrderItem;
import com.commerce.practice.dto.OrderItemRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by kimchanjung on 2021-04-15 오후 11:27
 */
@Mapper(config = CommonMapperConfig.class)
public interface OrderItemMapper {
    OrderItemMapper INSTANCE = Mappers.getMapper( OrderItemMapper.class );

    OrderItem toEntity(Order order, OrderItemRequest request);
}
