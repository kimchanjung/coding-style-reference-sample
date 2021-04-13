package com.commerce.practice.ordersystem.services;


import com.commerce.practice.ordersystem.dto.StoreResponse;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by kimchanjung on 2021-04-10 오후 3:23
 */
public interface StoreService {
    List<StoreResponse> findAllByTime(LocalDateTime time);
}
