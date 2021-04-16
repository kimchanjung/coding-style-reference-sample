package com.commerce.practice.entity;


import com.commerce.practice.enums.StoreState;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;

/**
 * Created by kimchanjung on 2021-04-10 오후 1:18
 */
@Getter
@Entity
@Table(name = "stores")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Builder
    public static Store ofNew(String name, StoreState state, Integer offDay,
                              Boolean run24, Integer openTime, Integer closeTime) {
        Store instance = new Store();
        instance.name = name;
        instance.state = state;
        instance.offDay = offDay;

        if (run24) {
            instance.run24 = true;
        } else {
            instance.run24 = false;
            instance.openTime = getTime(openTime);
            instance.closeTime = getTime(closeTime);
        }

        return instance;
    }

    private static Integer getTime(Integer time) {
        return time * 60;
    }

    public Store enableRun24(Integer openTime, Integer closeTime) {
        this.openTime = openTime;
        this.closeTime = closeTime;
        return this;
    }

    public Store disableRun24() {
        this.openTime = 0;
        this.closeTime = getTime(24);
        return this;
    }

    public boolean isOpen() {
        LocalDateTime now = LocalDateTime.now();
        int seconds = now.getHour() * 60 + now.getMinute();

        return state.equals(StoreState.NORMAL)
                && offDay != now.getDayOfWeek().getValue()
                && seconds >= openTime && closeTime >= seconds;
    }

    public Optional<Store> orderable() {
        return isOpen() ? of(this) : empty();
    }
}
