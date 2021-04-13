package com.commerce.practice.ordersystem.repositories;

import com.commerce.practice.configuration.TestMockConfiguration;
import com.commerce.practice.ordersystem.entity.Store;
import com.commerce.practice.ordersystem.mocks.MockEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by kimchanjung on 2021-04-13 오후 4:11
 */

@Slf4j
@Import(TestMockConfiguration.class)
@DataJpaTest
class StoreRepositoryTest {

    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private MockEntity mockEntity;

    @Test
    public void test() {
        //Given
        Store store = mockEntity.createStore(2, true, LocalDateTime.now().getHour(), LocalDateTime.now().getHour() + 5);

        //When
        List<Store> allByOffDayBefore = storeRepository.findAllByOffDayNotAndOpenTimeLessThanEqualAndCloseTimeGreaterThanEqual(1, LocalDateTime.now().get(ChronoField.MINUTE_OF_DAY),  LocalDateTime.now().get(ChronoField.MINUTE_OF_DAY));

        //Then
        assertEquals(1, allByOffDayBefore.size());
    }
}