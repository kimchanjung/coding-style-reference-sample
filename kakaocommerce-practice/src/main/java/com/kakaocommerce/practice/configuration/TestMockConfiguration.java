package com.kakaocommerce.practice.configuration;

import com.kakaocommerce.practice.ordersystem.mocks.MockEntity;
import com.kakaocommerce.practice.ordersystem.repositories.BookmarkStoreRepository;
import com.kakaocommerce.practice.ordersystem.repositories.StoreRepository;
import com.kakaocommerce.practice.ordersystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by kimchanjung on 2021-04-13 오후 12:58
 */
@Configuration
public class TestMockConfiguration {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private BookmarkStoreRepository bookmarkStoreRepository;

    @Bean
    public MockEntity mockEntity() {
        return new MockEntity(userRepository, storeRepository, bookmarkStoreRepository);
    }
}