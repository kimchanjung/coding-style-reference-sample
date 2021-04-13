package com.crawling.practice.commerce.repository;

import com.crawling.practice.commerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kimchanjung on 2021-04-08 오후 3:42
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
