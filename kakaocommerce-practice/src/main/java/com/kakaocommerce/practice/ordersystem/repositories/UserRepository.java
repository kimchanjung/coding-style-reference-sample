package com.kakaocommerce.practice.ordersystem.repositories;


import com.kakaocommerce.practice.ordersystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kimchanjung on 2021-04-12 오후 2:14
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
