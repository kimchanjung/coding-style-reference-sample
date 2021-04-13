package com.commerce.practice.ordersystem.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by kimchanjung on 2021-04-10 오후 1:30
 */
@Entity
public class BookmarkStore {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    private Store store;

    @CreatedDate
    private LocalDateTime createdAt;

    protected BookmarkStore(){}

    public static BookmarkStore of (User user, Store store) {
        BookmarkStore instance = new BookmarkStore();
        instance.user = user.addBookmarkStore(instance);
        instance.store = store;
        return instance;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Store getStore() {
        return store;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
