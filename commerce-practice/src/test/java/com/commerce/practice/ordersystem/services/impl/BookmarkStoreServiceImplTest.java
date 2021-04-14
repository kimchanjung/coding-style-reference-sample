package com.commerce.practice.ordersystem.services.impl;

import com.commerce.practice.ordersystem.dto.BookmarkStoreResponse;
import com.commerce.practice.ordersystem.entity.BookmarkStore;
import com.commerce.practice.ordersystem.entity.Store;
import com.commerce.practice.ordersystem.entity.User;
import com.commerce.practice.ordersystem.mocks.MockEntity;
import com.commerce.practice.ordersystem.repositories.BookmarkStoreRepository;
import com.commerce.practice.ordersystem.services.BookmarkStoreService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by kimchanjung on 2021-04-12 오후 2:11
 */

@Slf4j
@SpringBootTest
class BookmarkStoreServiceImplTest {

    @Autowired
    private MockEntity mockEntity;
    @Autowired
    private BookmarkStoreService bookmarkStoreService;
    @Autowired
    private BookmarkStoreRepository bookmarkStoreRepository;

    @Test
    public void 업소북마크에서_영업중인_업소의_북마크만_가져온다() {
        //Given
        BookmarkStore bookmarkStore = mockEntity.createBookmarkStore();

        //When
        List<BookmarkStoreResponse> responses = bookmarkStoreService.findAll(bookmarkStore.getUser().getId(), LocalDateTime.now().withHour(11));

        //Then
        assertEquals(bookmarkStore.getId(), responses.get(0).getId());
    }

    @Test
    public void 업소북마크가_정상적으로_등록된다() {
        //Given
        User user = mockEntity.creatUser();
        Store store = mockEntity.createStore();

        //When
        BookmarkStoreResponse bookmark = bookmarkStoreService.bookmark(user, store.getId());

        //Then
        assertEquals(store.getName(), bookmark.getStoreResponse().getName());
    }

    @Test
    public void 업소북마크가_정상적으로_삭제된다() {
        //Given
        BookmarkStore bookmarkStore = mockEntity.createBookmarkStore();

        //When
        bookmarkStoreService.delete(bookmarkStore.getUser().getId(), bookmarkStore.getId());
        BookmarkStore findBookmark = bookmarkStoreRepository.findById(bookmarkStore.getId()).orElse(null);

        //Then
        assertNull(findBookmark);
    }

    @Test
    public void 북마크를_삭제할수_없는경우_예외를발생한다() {
        //Given
        BookmarkStore bookmarkStore = mockEntity.createBookmarkStore();

        //When & Then
        assertThrows(IllegalArgumentException.class,
                () -> bookmarkStoreService.delete(bookmarkStore.getUser().getId(), 100L));
    }

}