package com.commerce.practice.services.impl;


import com.commerce.practice.dto.StoreResponse;
import com.commerce.practice.entity.Store;
import com.commerce.practice.ex.ResourceNotFoundException;
import com.commerce.practice.mappers.StoreMapper;
import com.commerce.practice.repositories.StoreRepository;
import com.commerce.practice.services.StoreService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.List;
import java.util.Optional;

/**
 * Created by kimchanjung on 2021-04-10 오후 3:36
 */

@Transactional
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
    public Optional<Store> findOneOpenShopById(Long id) {
        return findOneById(id).orderable();
    }
}
