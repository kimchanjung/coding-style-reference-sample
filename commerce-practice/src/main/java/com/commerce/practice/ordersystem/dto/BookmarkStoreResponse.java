package com.commerce.practice.ordersystem.dto;

import com.commerce.practice.ordersystem.entity.BookmarkStore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Created by kimchanjung on 2021-04-10 오후 2:46
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookmarkStoreResponse {
    private Long id;
    private boolean open;
    private StoreResponse storeResponse;
    private LocalDateTime createdAt;

    public static BookmarkStoreResponse of(Long id, boolean open, StoreResponse storeResponse, LocalDateTime createdAt) {
        BookmarkStoreResponse instance = new BookmarkStoreResponse();
        instance.id = id;
        instance.open = open;
        instance.storeResponse = storeResponse;
        instance.createdAt = createdAt;
        return instance;
    }

    public static BookmarkStoreResponse of(BookmarkStore store) {
        return BookmarkStoreResponse.of(store.getId(),
                store.getStore().isOpen(),
                StoreResponse.of(store.getStore()),
                store.getCreatedAt());
    }
}
