package com.commerce.practice.ordersystem.entity;

import com.commerce.practice.ordersystem.enums.StoreState;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by kimchanjung on 2021-04-15 오전 11:50
 */

@Slf4j
class StoreTest {

    @Test
    public void 업소_영업중이다() {
        //Given
        Store 홍콩반점 = Store.ofNew("홍콩반점", StoreState.NORMAL, 1, false, 0, 24);

        //When & Then
        assertTrue(홍콩반점.isOpen());
    }

    @Test
    public void 업소는_숨김업소이다() {
        //Given
        Store 홍콩반점 = Store.ofNew("홍콩반점", StoreState.HIDDEN, 1, false, 0, 24);

        //When & Then
        assertFalse(홍콩반점.isOpen());
    }

    @Test
    public void 업소는_휴무일이다() {
        //Given
        int offDay = LocalDateTime.now().getDayOfWeek().getValue();
        Store 홍콩반점 = Store.ofNew("홍콩반점", StoreState.NORMAL, offDay, false, 9, 20);

        //When & Then
        assertFalse(홍콩반점.isOpen());
    }

    @Test
    public void 업소는_운영시간이_아니다() {
        //Given
        LocalDateTime now = LocalDateTime.now();
        int openTime = now.plusHours(1).getHour();
        int closeTime = now.plusHours(5).getHour();

        Store 홍콩반점 = Store.ofNew("홍콩반점", StoreState.NORMAL,
                now.minusDays(1).getDayOfWeek().getValue(),
                false, openTime, closeTime);

        //When & Then
        assertFalse(홍콩반점.isOpen());
    }

}