package com.commerce.practice.ordersystem.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by kimchanjung on 2021-04-10 오후 1:30
 */
@Getter
@Entity
@Table(name = "bookmarked_stores")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BookmarkedStore {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    private Store store;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Builder
    public static BookmarkedStore ofNew(User user, Store store) {
        BookmarkedStore instance = new BookmarkedStore();
        instance.user = user.addBookmarkStore(instance);
        instance.store = store;
        return instance;
    }
}
