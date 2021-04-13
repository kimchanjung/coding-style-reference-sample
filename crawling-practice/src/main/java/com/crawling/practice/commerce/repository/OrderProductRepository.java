package com.crawling.practice.commerce.repository;

import com.crawling.practice.commerce.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kimchanjung on 2021-04-08 오후 9:55
 */
public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {
}
