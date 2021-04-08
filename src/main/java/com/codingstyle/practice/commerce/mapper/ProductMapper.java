package com.codingstyle.practice.commerce.mapper;

import com.codingstyle.practice.commerce.dto.ProductRequest;
import com.codingstyle.practice.commerce.dto.ProductResponse;
import com.codingstyle.practice.commerce.entity.Product;
import com.codingstyle.practice.config.CommonMapperConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Created by kimchanjung on 2021-04-08 오후 4:12
 */

@Mapper(config = CommonMapperConfig.class)
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper( ProductMapper.class );

    @Mapping(target = "id", ignore = true)
    Product toEntity(ProductRequest productRequest);

    ProductResponse toResponse(Product product);
}
