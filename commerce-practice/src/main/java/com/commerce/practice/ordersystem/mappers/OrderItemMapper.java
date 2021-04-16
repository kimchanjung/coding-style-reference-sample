package com.commerce.practice.ordersystem.mappers;

import com.commerce.practice.configuration.CommonMapperConfig;
import com.commerce.practice.ordersystem.dto.OrderItemRequest;
import com.commerce.practice.ordersystem.entity.Order;
import com.commerce.practice.ordersystem.entity.OrderItem;
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
