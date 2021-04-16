package com.commerce.practice.repositories;

//import com.kakaocommerce.practice.configuration.TestMockConfiguration;

import com.commerce.practice.configuration.TestMockConfiguration;
import com.commerce.practice.entity.BookmarkedStore;
import com.commerce.practice.mocks.MockEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by kimchanjung on 2021-04-12 오후 4:55
 */
@Slf4j
@Import(TestMockConfiguration.class)
@DataJpaTest
class BookmarkedStoreControllerRepositoryTest {

    @Autowired
    private BookmarkedStoreRepository bookmarkedStoreRepository;
    @Autowired
    private MockEntity mockEntity;

    @Test
    public void 유저아이디로_북마크를_가져온다() {
        //Given
        BookmarkedStore bookmarkedStore = mockEntity.createBookmarkStore();

        //When
        List<BookmarkedStore> bookmarkedStores = bookmarkedStoreRepository
                .findAllByUserIdAndStoreOpenTimeLessThanEqual(1L, 11 * 60);

        //Then
        assertEquals(1L, bookmarkedStores.get(0).getId());
        assertEquals(bookmarkedStore.getUser().getEmail(), bookmarkedStores.get(0).getUser().getEmail());
    }

    @Test
    public void 유저아이디로와_업소번호로_북마크를_가져온() {
        //Given
        BookmarkedStore bookmarkedStore = mockEntity.createBookmarkStore();

        //When
        BookmarkedStore response = bookmarkedStoreRepository
                .findByUserIdAndStoreId(bookmarkedStore.getUser().getId(), bookmarkedStore.getStore().getId()).get();

        //Then
        assertEquals(bookmarkedStore.getId(), response.getId());
        assertEquals(bookmarkedStore.getUser().getEmail(), response.getUser().getEmail());
    }

}