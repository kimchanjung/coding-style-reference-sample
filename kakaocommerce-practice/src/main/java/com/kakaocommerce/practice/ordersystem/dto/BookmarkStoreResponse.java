package com.kakaocommerce.practice.ordersystem.dto;

import com.kakaocommerce.practice.ordersystem.entity.BookmarkStore;

import java.time.LocalDateTime;

/**
 * Created by kimchanjung on 2021-04-10 오후 2:46
 */
public class BookmarkStoreResponse {
    private Long id;
    private boolean open;
    private StoreResponse storeResponse;
    private LocalDateTime createdAt;

    private BookmarkStoreResponse() {
    }

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

    public Long getId() {
        return id;
    }

    public boolean isOpen() {
        return open;
    }

    public StoreResponse getStoreResponse() {
        return storeResponse;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}