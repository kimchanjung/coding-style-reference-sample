package com.commerce.practice.ordersystem.services.impl;


import com.commerce.practice.ordersystem.dto.BookmarkStoreResponse;
import com.commerce.practice.ordersystem.entity.BookmarkStore;
import com.commerce.practice.ordersystem.entity.User;
import com.commerce.practice.ordersystem.repositories.BookmarkStoreRepository;
import com.commerce.practice.ordersystem.repositories.StoreRepository;
import com.commerce.practice.ordersystem.services.BookmarkStoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kimchanjung on 2021-04-10 오후 3:36
 */
@Slf4j
@Transactional
@Service
public class BookmarkStoreServiceImpl implements BookmarkStoreService {
    private final BookmarkStoreRepository bookmarkStoreRepository;
    private final StoreRepository storeRepository;


    public BookmarkStoreServiceImpl(BookmarkStoreRepository bookmarkStoreRepository,
                                    StoreRepository storeRepository) {
        this.bookmarkStoreRepository = bookmarkStoreRepository;
        this.storeRepository = storeRepository;
    }

    @Override
    public List<BookmarkStoreResponse> findAll(Long userId, LocalDateTime time) {
        return bookmarkStoreRepository.findAllByUserIdAndStoreOpenTimeLessThanEqual(userId, time.get(ChronoField.MINUTE_OF_DAY))
                .stream()
                .map(BookmarkStoreResponse::of)
                .collect(Collectors.toList());
    }

    @Override
    public BookmarkStoreResponse bookmark(User user, Long storeId) {
        return storeRepository.findById(storeId)
                .map(v -> BookmarkStoreResponse.of(bookmarkStoreRepository.save(BookmarkStore.of(user, v))))
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상점번호[" + storeId + "]입니다."));
    }


    @Override
    public void delete(Long userId, Long storeId) {
        bookmarkStoreRepository.delete(
                bookmarkStoreRepository.findByUserIdAndStoreId(userId, storeId)
                .orElseThrow(() -> new IllegalArgumentException("북마크상점을 삭제할 수 없습니다. 업소번호를 확인하세요.")));
    }
}
