package com.commerce.practice.ordersystem.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by kimchanjung on 2021-04-10 오후 2:00
 */

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false, name = "passwd")
    private String password;
    @Column(nullable = false)
    private Integer loginCount;
    @OneToMany(mappedBy = "user")
    private final List<BookmarkStore> bookmarkStores = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private final List<Order> orders = new ArrayList<>();
    @LastModifiedDate
    private LocalDateTime lastLoginAt;
    @CreatedDate
    private LocalDateTime createdAt;

    public static User of(String name, String email, String password) {
        User instance = new User();
        instance.name = name;
        instance.email = email;
        instance.password = password;
        instance.loginCount = 0;
        instance.lastLoginAt = LocalDateTime.now();
        return instance;
    }

    public User addOrder(Order order) {
        orders.add(order);
        return this;
    }

    public User addBookmarkStore(BookmarkStore bookmarkStore) {
        bookmarkStores.add(bookmarkStore);
        return this;
    }

    public User login() {
        loginCount++;
        return this;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public List<BookmarkStore> getBookmarkStores() {
        return bookmarkStores;
    }

    public LocalDateTime getLastLoginAt() {
        return lastLoginAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}