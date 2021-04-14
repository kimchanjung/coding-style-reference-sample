package com.commerce.practice.ordersystem.services;


import com.commerce.practice.ordersystem.dto.StoreResponse;
import com.commerce.practice.ordersystem.entity.Store;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by kimchanjung on 2021-04-10 오후 3:23
 */
public interface StoreService {
    Store findOneById(Long id);
    List<StoreResponse> findAllByTime(LocalDateTime time);
}
