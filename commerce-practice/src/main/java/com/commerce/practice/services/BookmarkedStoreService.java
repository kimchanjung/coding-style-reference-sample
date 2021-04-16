package com.commerce.practice.services;


import com.commerce.practice.dto.BookmarkedStoreResponse;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by kimchanjung on 2021-04-10 오후 3:24
 */
public interface BookmarkedStoreService {
    List<BookmarkedStoreResponse> findAll(Long userId, LocalDateTime time);

    BookmarkedStoreResponse bookmark(Long userId, Long storeId);

    boolean delete(Long userId, Long storeId);
}
