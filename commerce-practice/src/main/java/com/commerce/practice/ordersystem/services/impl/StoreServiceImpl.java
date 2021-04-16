package com.commerce.practice.ordersystem.services.impl;


import com.commerce.practice.ex.BadRequestException;
import com.commerce.practice.ex.ResourceNotFoundException;
import com.commerce.practice.ordersystem.dto.StoreResponse;
import com.commerce.practice.ordersystem.entity.Store;
import com.commerce.practice.ordersystem.mappers.StoreMapper;
import com.commerce.practice.ordersystem.repositories.StoreRepository;
import com.commerce.practice.ordersystem.services.StoreService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.List;

/**
 * Created by kimchanjung on 2021-04-10 오후 3:36
 */

@Service
public class StoreServiceImpl implements StoreService {
    private final StoreRepository storeRepository;
    private final StoreMapper mapper;

    public StoreServiceImpl(StoreRepository storeRepository, StoreMapper mapper) {
        this.storeRepository = storeRepository;
        this.mapper = mapper;
    }

    @Override
    public Store findOneById(Long id) {
        return storeRepository.findById(id)
                .orElseThrow(() -> ResourceNotFoundException.notFound("업소"));
    }

    @Override
    public List<StoreResponse> findAllByTime(LocalDateTime time) {
        return mapper.toDto(
                storeRepository.findAllByOffDayNotAndOpenTimeLessThanEqualAndCloseTimeGreaterThanEqual(
                        time.getDayOfWeek().getValue(),
                        time.get(ChronoField.MINUTE_OF_DAY),
                        time.get(ChronoField.MINUTE_OF_DAY)));
    }

    @Override
    public Store findOneOpenShopById(Long id) {
        Store store = findOneById(id);
        if (!store.isOpen()) throw BadRequestException.closed();
        return store;
    }


}
