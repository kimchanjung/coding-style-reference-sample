package com.kakaocommerce.practice.ordersystem.services.impl;

import com.kakaocommerce.TestConfiguration;
import com.kakaocommerce.practice.ordersystem.dto.StoreResponse;
import com.kakaocommerce.practice.ordersystem.entity.Store;
import com.kakaocommerce.practice.ordersystem.mocks.MockEntity;
import com.kakaocommerce.practice.ordersystem.services.StoreService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by kimchanjung on 2021-04-13 오후 2:01
 */

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TestConfiguration.class)
class StoreServiceImplTest {

    @Autowired
    private MockEntity mockEntity;
    @Autowired
    private StoreService storeService;

    @Test
    public void 상점목록을_정상적으로_가져온다() {
        //Given
        List<Store> stores = mockEntity.createStores(4);
        mockEntity.createStore(2, true, LocalDateTime.now().getHour() + 1, LocalDateTime.now().getHour() + 2);
        LocalDateTime now = LocalDateTime.now();

        //When
        List<StoreResponse> storeResponses = storeService.findAllByTime(now);

        //Then
        storeResponses.forEach(store -> assertTrue(store.getBusinessHours().getOpenTime() <= now.get(ChronoField.MINUTE_OF_DAY)));
    }
}