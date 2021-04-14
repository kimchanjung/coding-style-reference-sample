package com.commerce.practice.ordersystem.dto;


import com.commerce.practice.ordersystem.entity.Store;
import com.commerce.practice.ordersystem.enums.StoreState;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Created by kimchanjung on 2021-04-10 오후 2:37
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StoreResponse {
    private Long id;
    private String name;
    private String state;
    private BusinessHours businessHours;
    private LocalDateTime createdAt;

    public static StoreResponse of(Long id, String name, StoreState state,
                                    BusinessHours businessHours, LocalDateTime createdAt) {
        StoreResponse instance = new StoreResponse();
        instance.id = id;
        instance.name = name;
        instance.state = state.name();
        instance.businessHours = businessHours;
        instance.createdAt = createdAt;
        return instance;
    }

    public static StoreResponse of(Store store) {
        return StoreResponse.of(store.getId(), store.getName(), store.getState(),
                BusinessHours.of(store.getOffDay(), store.getRun24(),
                        store.getOpenTime(), store.getCloseTime()),
                store.getCreatedAt());
    }

    @Getter
    public static class BusinessHours {
        private Integer offDay;
        private boolean run24;
        private Integer openTime;
        private Integer closeTime;

        public static BusinessHours of (Integer offDay, boolean run24, Integer openTime, Integer closeTime) {
            BusinessHours instance = new BusinessHours();
            instance.offDay = offDay;
            instance.run24 = run24;
            instance.openTime = openTime;
            instance.closeTime = closeTime;
            return instance;
        }
    }
}
