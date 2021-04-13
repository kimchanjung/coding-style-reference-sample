package com.kakaocommerce.practice.ordersystem.services;


import com.kakaocommerce.practice.ordersystem.dto.StoreResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by kimchanjung on 2021-04-10 오후 3:23
 */
public interface StoreService {
    List<StoreResponse> findAllByTime(LocalDateTime time);
}
