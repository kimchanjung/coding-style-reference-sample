package com.commerce.practice.services.impl;


import com.commerce.practice.dto.BookmarkedStoreResponse;
import com.commerce.practice.entity.BookmarkedStore;
import com.commerce.practice.entity.Store;
import com.commerce.practice.ex.BadRequestException;
import com.commerce.practice.ex.ResourceNotFoundException;
import com.commerce.practice.mappers.BookmarkedStoreMapper;
import com.commerce.practice.repositories.BookmarkedStoreRepository;
import com.commerce.practice.repositories.StoreRepository;
import com.commerce.practice.services.BookmarkedStoreService;
import com.commerce.practice.services.UserService;
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
        return mapper.toDto(bookmarkedStoreRepository.findByUserIdAndStoreId(userId, storeId)
                .orElseGet(() -> storeRepository.findById(storeId)
                        .map(store -> bookmarkedStoreRepository
                                .save(BookmarkedStore.ofNew(userService.findMe(userId), store)))
                        .orElseThrow(() -> ResourceNotFoundException.notFound("업소"))));
    }

    @Override
    public boolean delete(Long userId, Long storeId) {
        bookmarkedStoreRepository.delete(bookmarkedStoreRepository
                .findByUserIdAndStoreId(userId, storeId)
                .orElseThrow(() -> ResourceNotFoundException.notFound("북마크")));
        return true;
    }
}
