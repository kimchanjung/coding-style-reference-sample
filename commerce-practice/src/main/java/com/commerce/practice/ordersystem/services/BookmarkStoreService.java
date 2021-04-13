package com.commerce.practice.ordersystem.services;



import com.commerce.practice.ordersystem.dto.BookmarkStoreResponse;
import com.commerce.practice.ordersystem.entity.User;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by kimchanjung on 2021-04-10 오후 3:24
 */
public interface BookmarkStoreService {
    List<BookmarkStoreResponse> findAll(Long userId, LocalDateTime time);
    BookmarkStoreResponse bookmark(User user, Long storeId);
    void delete(Long userId, Long storeId);
}
