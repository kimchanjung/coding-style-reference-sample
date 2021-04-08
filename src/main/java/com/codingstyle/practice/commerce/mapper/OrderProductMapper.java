package com.codingstyle.practice.commerce.mapper;

import com.codingstyle.practice.commerce.dto.OrderProductResponse;
import com.codingstyle.practice.commerce.entity.OrderProduct;
import com.codingstyle.practice.config.CommonMapperConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Created by kimchanjung on 2021-04-08 오후 10:33
 */

@Mapper(config = CommonMapperConfig.class)
public interface OrderProductMapper {
    OrderProductMapper INSTANCE = Mappers.getMapper( OrderProductMapper.class );

    //@Mapping(target = "order", ignore = true)
    OrderProductResponse toResponse(OrderProduct orderProduct);
}
