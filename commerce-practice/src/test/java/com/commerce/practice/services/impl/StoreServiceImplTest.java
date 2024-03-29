package com.commerce.practice.services.impl;

import com.commerce.practice.dto.StoreResponse;
import com.commerce.practice.mocks.MockEntity;
import com.commerce.practice.services.StoreService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by kimchanjung on 2021-04-13 오후 2:01
 */

@Slf4j
@SpringBootTest
class StoreServiceImplTest {

    @Autowired
    private MockEntity mockEntity;
    @Autowired
    private StoreService storeService;

    @Test
    public void 상점목록을_정상적으로_가져온다() {
        //Given
        LocalDateTime now = LocalDateTime.now();
        mockEntity.createStores(4);
        mockEntity.createStore(2, true,
                LocalDateTime.now().getHour() + 1, LocalDateTime.now().getHour() + 2);

        //When
        List<StoreResponse> storeResponses = storeService.findAllByTime(now);

        //Then
        storeResponses.forEach(store -> {
            assertTrue(store.getBusinessHours().getOpenTime() <= now.get(ChronoField.MINUTE_OF_DAY));
            assertNotNull(store.getId());
            assertNotNull(store.getName());
            assertNotNull(store.getName());
            assertNotNull(store.getBusinessHours().getOffDay());
            assertNotNull(store.getBusinessHours().getCloseTime());
        });
    }
}