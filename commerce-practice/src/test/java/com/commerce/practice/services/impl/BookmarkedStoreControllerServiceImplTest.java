package com.commerce.practice.services.impl;

import com.commerce.practice.dto.BookmarkedStoreResponse;
import com.commerce.practice.entity.BookmarkedStore;
import com.commerce.practice.entity.Store;
import com.commerce.practice.entity.User;
import com.commerce.practice.ex.ResourceNotFoundException;
import com.commerce.practice.mocks.MockEntity;
import com.commerce.practice.repositories.BookmarkedStoreRepository;
import com.commerce.practice.services.BookmarkedStoreService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by kimchanjung on 2021-04-12 오후 2:11
 */

@Slf4j
@SpringBootTest
class BookmarkedStoreControllerServiceImplTest {

    @Autowired
    private MockEntity mockEntity;
    @Autowired
    private BookmarkedStoreService bookmarkedStoreService;
    @Autowired
    private BookmarkedStoreRepository bookmarkedStoreRepository;

    @Test
    public void 업소북마크에서_영업중인_업소의_북마크만_가져온다() {
        //Given
        BookmarkedStore bookmarkedStore = mockEntity.createBookmarkStore();

        //When
        List<BookmarkedStoreResponse> responses = bookmarkedStoreService
                .findAll(bookmarkedStore.getUser().getId(), LocalDateTime.now().withHour(11));

        //Then
        assertEquals(bookmarkedStore.getId(), responses.get(0).getId());
        assertEquals(bookmarkedStore.getStore().isOpen(), responses.get(0).isOpen());
    }

    @Test
    public void 업소북마크가_정상적으로_등록된다() {
        //Given
        User user = mockEntity.creatUser();
        Store store = mockEntity.createStore();

        //When
        BookmarkedStoreResponse bookmark = bookmarkedStoreService.bookmark(user.getId(), store.getId());

        //Then
        assertEquals(store.getName(), bookmark.getStore().getName());
        assertEquals(store.isOpen(), bookmark.isOpen());
    }

    @Test
    public void 업소북마크가_정상적으로_삭제된다() {
        //Given
        BookmarkedStore bookmarkedStore = mockEntity.createBookmarkStore();

        //When
        bookmarkedStoreService.delete(bookmarkedStore.getUser().getId(), bookmarkedStore.getId());
        BookmarkedStore response = bookmarkedStoreRepository.findById(bookmarkedStore.getId()).orElse(null);

        //Then
        assertNull(response);
    }

    @Test
    public void 북마크를_삭제할_수_없는경우_예외를발생한다() {
        //Given
        BookmarkedStore bookmarkedStore = mockEntity.createBookmarkStore();

        //When & Then
        assertThrows(ResourceNotFoundException.class, () ->
                bookmarkedStoreService.delete(bookmarkedStore.getUser().getId(), 100L));
    }
}