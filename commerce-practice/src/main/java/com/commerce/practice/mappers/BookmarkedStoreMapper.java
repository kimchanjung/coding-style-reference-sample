package com.commerce.practice.mappers;

import com.commerce.practice.configuration.CommonMapperConfig;
import com.commerce.practice.dto.BookmarkedStoreResponse;
import com.commerce.practice.entity.BookmarkedStore;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Created by kimchanjung on 2021-04-15 오후 10:38
 */
@Mapper(config = CommonMapperConfig.class, uses = StoreMapper.class)
public interface BookmarkedStoreMapper {
    BookmarkedStoreMapper INSTANCE = Mappers.getMapper(BookmarkedStoreMapper.class);

    @Mapping( target = "open", source = "store.open")
    BookmarkedStoreResponse toDto(BookmarkedStore bookmarkedStore);

    List<BookmarkedStoreResponse> toDto(List<BookmarkedStore> bookmarkedStore);
}
