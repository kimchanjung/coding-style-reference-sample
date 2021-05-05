package com.commerce.practice.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by kimchanjung on 2021-04-10 오후 1:30
 * [엔티티 관계에서 기본패치전략]
 * 기본패치전략을 그대로 사용하는 경우 생략해도 되지만
 * 사람은 항상 햇갈릴 수 있기 때문에 명시적으로 설정해주는 편이다
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
