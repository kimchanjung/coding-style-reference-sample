package com.commerce.practice.ordersystem.entity;


import com.commerce.practice.ordersystem.enums.StoreState;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by kimchanjung on 2021-04-10 오후 1:18
 */
@Table(name = "stores")
@Entity
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private StoreState state;
    @Column(nullable = false)
    private Integer offDay;
    @Column(nullable = false)
    private Boolean run24;
    @Column(nullable = false)
    private Integer openTime = 0;
    @Column(nullable = false)
    private Integer closeTime = 24 * 60;
    @CreatedDate
    private LocalDateTime createdAt;

    public static Store of(String name, StoreState state, Integer offDay, Boolean run24, Integer openTime, Integer closeTime) {
        Store instance = new Store();
        instance.name = name;
        instance.state = state;
        instance.offDay = offDay;

        if (run24) {
            instance.run24 = true;
        } else {
            instance.run24 = false;
            instance.openTime = setTime(openTime);
            instance.closeTime = setTime(closeTime);
        }

        return instance;
    }

    private static Integer setTime(Integer openTime) {
        return openTime * 60;
    }


    public Store enableRun24(Integer openTime, Integer closeTime) {
        this.openTime = openTime;
        this.closeTime = closeTime;
        return this;
    }

    public Store disableRun24() {
        this.openTime = 0;
        this.closeTime = setTime(24);
        return this;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public StoreState getState() {
        return state;
    }

    public Integer getOffDay() {
        return offDay;
    }

    public Boolean getRun24() {
        return run24;
    }

    public Integer getOpenTime() {
        return openTime;
    }

    public Integer getCloseTime() {
        return closeTime;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * TODO - 상점오픈여부 로직추가
     */
    public boolean isOpen() {
        return true;
    }
}
