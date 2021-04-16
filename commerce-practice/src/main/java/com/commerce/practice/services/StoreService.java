package com.commerce.practice.services;


import com.commerce.practice.dto.StoreResponse;
import com.commerce.practice.entity.Store;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Created by kimchanjung on 2021-04-10 오후 3:23
 */
public interface StoreService {
    Store findOneById(Long id);

    List<StoreResponse> findAllByTime(LocalDateTime time);

    Optional<Store> findOneOpenShopById(Long id);
}
