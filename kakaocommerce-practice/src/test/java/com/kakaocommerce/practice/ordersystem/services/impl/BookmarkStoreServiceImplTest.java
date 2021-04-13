package com.kakaocommerce.practice.ordersystem.services.impl;

import com.kakaocommerce.TestConfiguration;
import com.kakaocommerce.practice.ordersystem.dto.BookmarkStoreResponse;
import com.kakaocommerce.practice.ordersystem.entity.BookmarkStore;
import com.kakaocommerce.practice.ordersystem.entity.Store;
import com.kakaocommerce.practice.ordersystem.entity.User;
import com.kakaocommerce.practice.ordersystem.mocks.MockEntity;
import com.kakaocommerce.practice.ordersystem.services.BookmarkStoreService;
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
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TestConfiguration.class)
class BookmarkStoreServiceImplTest {

    @Autowired
    private MockEntity mockEntity;
    @Autowired
    private BookmarkStoreService bookmarkStoreService;

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

}