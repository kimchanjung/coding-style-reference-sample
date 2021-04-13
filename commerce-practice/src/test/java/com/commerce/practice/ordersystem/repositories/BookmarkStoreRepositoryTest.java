package com.commerce.practice.ordersystem.repositories;

//import com.kakaocommerce.practice.configuration.TestMockConfiguration;

import com.commerce.practice.configuration.TestMockConfiguration;
import com.commerce.practice.ordersystem.entity.BookmarkStore;
import com.commerce.practice.ordersystem.mocks.MockEntity;
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
class BookmarkStoreRepositoryTest {

    @Autowired
    private BookmarkStoreRepository bookmarkStoreRepository;
    @Autowired
    private MockEntity mockEntity;

    @Test
    public void 유저아이디로_북마크를_가져온다() {
        //Given
        BookmarkStore bookmarkStore = mockEntity.createBookmarkStore();

        //When
        List<BookmarkStore> bookmarkStores = bookmarkStoreRepository.findAllByUserIdAndStoreOpenTimeLessThanEqual(1L, 11*60);

        //Then
        assertEquals(1L, bookmarkStores.get(0).getId());
        assertEquals(bookmarkStore.getUser().getEmail(), bookmarkStores.get(0).getUser().getEmail());
    }

    @Test
    public void 유저아이디로와_업소번호로_북마크를_가져온() {
        //Given
        BookmarkStore bookmarkStore = mockEntity.createBookmarkStore();

        //When
        BookmarkStore response = bookmarkStoreRepository.findByUserIdAndStoreId(bookmarkStore.getUser().getId(), bookmarkStore.getStore().getId()).get();

        //Then
        assertEquals(bookmarkStore.getId(), response.getId());
        assertEquals(bookmarkStore.getUser().getEmail(), response.getUser().getEmail());
    }

}