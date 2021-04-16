package com.commerce.practice.ordersystem.services.impl;


import com.commerce.practice.ex.BadRequestException;
import com.commerce.practice.ex.ResourceNotFoundException;
import com.commerce.practice.ordersystem.dto.BookmarkedStoreResponse;
import com.commerce.practice.ordersystem.entity.BookmarkedStore;
import com.commerce.practice.ordersystem.entity.Store;
import com.commerce.practice.ordersystem.mappers.BookmarkedStoreMapper;
import com.commerce.practice.ordersystem.repositories.BookmarkedStoreRepository;
import com.commerce.practice.ordersystem.repositories.StoreRepository;
import com.commerce.practice.ordersystem.services.BookmarkedStoreService;
import com.commerce.practice.ordersystem.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.List;

/**
 * Created by kimchanjung on 2021-04-10 오후 3:36
 */
@Slf4j
@Transactional
@Service
public class BookmarkedStoreServiceImpl implements BookmarkedStoreService {
    private final BookmarkedStoreRepository bookmarkedStoreRepository;
    private final StoreRepository storeRepository;
    private final UserService userService;
    private final BookmarkedStoreMapper mapper;


    public BookmarkedStoreServiceImpl(BookmarkedStoreRepository bookmarkedStoreRepository,
                                      StoreRepository storeRepository, UserService userService,
                                      BookmarkedStoreMapper mapper) {
        this.bookmarkedStoreRepository = bookmarkedStoreRepository;
        this.storeRepository = storeRepository;
        this.userService = userService;
        this.mapper = mapper;
    }

    @Override
    public List<BookmarkedStoreResponse> findAll(Long userId, LocalDateTime time) {
        return mapper.toDto(bookmarkedStoreRepository
                .findAllByUserIdAndStoreOpenTimeLessThanEqual(userId, time.get(ChronoField.MINUTE_OF_DAY)));
    }

    @Override
    public BookmarkedStoreResponse bookmark(Long userId, Long storeId) {
        bookmarkedStoreRepository.findByUserIdAndStoreId(userId, storeId)
                .ifPresent(v -> { throw BadRequestException.alreadyBookmarked(v.getStore().getName());});
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> ResourceNotFoundException.notFound("업소"));

        return mapper.toDto(bookmarkedStoreRepository
                .save(BookmarkedStore.ofNew(userService.findMe(userId), store)));
    }

    @Override
    public boolean delete(Long userId, Long storeId) {
        bookmarkedStoreRepository.delete(bookmarkedStoreRepository
                .findByUserIdAndStoreId(userId, storeId)
                .orElseThrow(() -> ResourceNotFoundException.notFound("북마크")));
        return true;
    }
}
