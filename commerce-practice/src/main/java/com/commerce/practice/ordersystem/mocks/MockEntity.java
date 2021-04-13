package com.commerce.practice.ordersystem.mocks;

import com.commerce.practice.ordersystem.entity.BookmarkStore;
import com.commerce.practice.ordersystem.entity.Store;
import com.commerce.practice.ordersystem.entity.User;
import com.commerce.practice.ordersystem.enums.StoreState;
import com.commerce.practice.ordersystem.repositories.BookmarkStoreRepository;
import com.commerce.practice.ordersystem.repositories.StoreRepository;
import com.commerce.practice.ordersystem.repositories.UserRepository;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by kimchanjung on 2021-04-13 오후 12:03
 */

@Transactional
@Component
public class MockEntity {

    private final UserRepository userRepository;
    private final StoreRepository storeRepository;
    private final BookmarkStoreRepository bookmarkStoreRepository;

    public MockEntity(UserRepository userRepository, StoreRepository storeRepository,
                      BookmarkStoreRepository bookmarkStoreRepository) {
        this.userRepository = userRepository;
        this.storeRepository = storeRepository;
        this.bookmarkStoreRepository = bookmarkStoreRepository;
    }

    public static Integer randomNumber() {
        return new Random().nextInt(1000 - 1) + 1;
    }

    public User creatUser() {
        return userRepository.save(User.of("김찬정" + randomNumber(), "kimchanjung.dev@gmail.com", "1234"));
    }

    public Store createStore() {
        return storeRepository.save(Store.of("홍콩반점" + randomNumber(), StoreState.NORMAL, 1, false, 11, 22));
    }

    public BookmarkStore createBookmarkStore() {
        return bookmarkStoreRepository.save(BookmarkStore.of(creatUser(), createStore()));
    }


    public List<Store> createStores(int size) {
        return IntStream.range(0, size).mapToObj(i -> createStore()).collect(Collectors.toList());
    }

    public Store createStore(Integer offDay, boolean run24, Integer openTime, Integer closeTime) {
        return storeRepository.save(Store.of("홍콩반점" + randomNumber(), StoreState.NORMAL, offDay, false, openTime, closeTime));
    }

}
