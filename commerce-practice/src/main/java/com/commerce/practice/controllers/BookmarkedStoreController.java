package com.commerce.practice.controllers;

import com.commerce.practice.dto.BookmarkedStoreResponse;
import com.commerce.practice.services.BookmarkedStoreService;
import com.commerce.practice.utils.ResponseForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by kimchanjung on 2021-04-15 오전 11:27
 */
@Slf4j
@RestController
@RequestMapping("/api/bookmarkedstores")
public class BookmarkedStoreController {

    private final BookmarkedStoreService bookmarkedStoreService;

    public BookmarkedStoreController(BookmarkedStoreService bookmarkedStoreService) {
        this.bookmarkedStoreService = bookmarkedStoreService;
    }

    /**
     * 세션에서 유저아이디로 User를 가져오지만
     * 로그인 구현이 없으므로 1번회원을 가져온다
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseForm<List<BookmarkedStoreResponse>> findAll(
            @RequestParam(name = "time", required = false) LocalDateTime time) {
        return ResponseForm.ok(bookmarkedStoreService.findAll(1L, time == null ? LocalDateTime.now() : time));
    }

    @RequestMapping(value = "/{storeId}/bookmark", method = RequestMethod.POST)
    public ResponseForm<BookmarkedStoreResponse> bookmark(@PathVariable("storeId") Long storeId) {
        return ResponseForm.ok(bookmarkedStoreService.bookmark(1L, storeId));
    }

    @RequestMapping(value = "/{storeId}/bookmark", method = RequestMethod.DELETE)
    public ResponseForm<Boolean> delete(@PathVariable("storeId") Long storeId) {
        return ResponseForm.ok(bookmarkedStoreService.delete(1L, storeId));
    }

}
