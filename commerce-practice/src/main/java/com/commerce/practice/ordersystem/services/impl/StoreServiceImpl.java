package com.commerce.practice.ordersystem.services.impl;


import com.commerce.practice.ordersystem.dto.StoreResponse;
import com.commerce.practice.ordersystem.entity.Store;
import com.commerce.practice.ordersystem.repositories.StoreRepository;
import com.commerce.practice.ordersystem.services.StoreService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kimchanjung on 2021-04-10 오후 3:36
 */

@Service
public class StoreServiceImpl implements StoreService {
    private final StoreRepository storeRepository;

    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public Store findOneById(Long id) {
        return storeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지않는 업소입니다."));
    }

    @Override
    public List<StoreResponse> findAllByTime(LocalDateTime time) {
        return storeRepository.findAllByOffDayNotAndOpenTimeLessThanEqualAndCloseTimeGreaterThanEqual(time.getDayOfWeek().getValue(), time.get(ChronoField.MINUTE_OF_DAY), time.get(ChronoField.MINUTE_OF_DAY))
                .stream()
                .map(StoreResponse::of)
                .collect(Collectors.toList());
    }


}
