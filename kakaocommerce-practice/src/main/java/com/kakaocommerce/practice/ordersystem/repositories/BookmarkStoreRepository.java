package com.kakaocommerce.practice.ordersystem.repositories;


import com.kakaocommerce.practice.ordersystem.entity.BookmarkStore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by kimchanjung on 2021-04-10 오후 3:38
 */

public interface BookmarkStoreRepository extends JpaRepository<BookmarkStore, Long> {
    Optional<BookmarkStore> findByUserIdAndStoreId(Long userId, Long storeId);
    List<BookmarkStore> findAllByUserIdAndStoreOpenTimeLessThanEqual(Long userId, Integer openTime);
}
