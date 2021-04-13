package com.commerce.practice.ordersystem.dto;


import com.commerce.practice.ordersystem.entity.Store;
import com.commerce.practice.ordersystem.enums.StoreState;

import java.time.LocalDateTime;

/**
 * Created by kimchanjung on 2021-04-10 오후 2:37
 */
public class StoreResponse {
    private Long id;
    private String name;
    private String state;
    private BusinessHours businessHours;
    private LocalDateTime createdAt;

    private StoreResponse(){}

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

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public BusinessHours getBusinessHours() {
        return businessHours;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

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

        public Integer getOffDay() {
            return offDay;
        }

        public boolean isRun24() {
            return run24;
        }

        public Integer getOpenTime() {
            return openTime;
        }

        public Integer getCloseTime() {
            return closeTime;
        }
    }
}
