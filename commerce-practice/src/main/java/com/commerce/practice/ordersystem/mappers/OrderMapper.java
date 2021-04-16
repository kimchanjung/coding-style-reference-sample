package com.commerce.practice.ordersystem.mappers;

import com.commerce.practice.configuration.CommonMapperConfig;
import com.commerce.practice.ordersystem.dto.OrderResponse;
import com.commerce.practice.ordersystem.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Created by kimchanjung on 2021-04-15 오후 8:18
 */
@Mapper(config = CommonMapperConfig.class)
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper( OrderMapper.class );

    @Mapping(target = "cancel", ignore = true)
    @Mapping(target = "storeId", source = "store.id")
    @Mapping(target = "cancel.message",source = "cancelMsg")
    @Mapping(target = "cancel.time", source = "canceledAt")
    OrderResponse toDto(Order order);

    List<OrderResponse> toDto(List<Order> orders);


}