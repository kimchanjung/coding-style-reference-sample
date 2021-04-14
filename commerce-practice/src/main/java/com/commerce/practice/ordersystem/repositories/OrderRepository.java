package com.commerce.practice.ordersystem.repositories;


import com.commerce.practice.ordersystem.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Created by kimchanjung on 2021-04-10 오후 3:37
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
   List<Order> findAllByUserIdAndCreatedAtBetweenOrderByIdAsc(Long userId, LocalDateTime from, LocalDateTime to);
   Optional<Order> findByIdAndUserId(Long orderId, Long userId);
}
