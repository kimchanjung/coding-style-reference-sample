package com.commerce.practice.ordersystem.repositories;


import com.commerce.practice.ordersystem.entity.BookmarkedStore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by kimchanjung on 2021-04-10 오후 3:38
 */

public interface BookmarkedStoreRepository extends JpaRepository<BookmarkedStore, Long> {
    Optional<BookmarkedStore> findByUserIdAndStoreId(Long userId, Long storeId);
    List<BookmarkedStore> findAllByUserIdAndStoreOpenTimeLessThanEqual(Long userId, Integer openTime);
}
