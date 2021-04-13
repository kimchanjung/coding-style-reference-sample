package com.crawling.practice.commerce.mapper;

import com.crawling.practice.commerce.dto.OrderProductResponse;
import com.crawling.practice.commerce.entity.OrderProduct;
import com.crawling.practice.config.CommonMapperConfig;
import org.mapstruct.Mapper;
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
