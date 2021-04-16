package com.commerce.practice.repositories;


import com.commerce.practice.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by kimchanjung on 2021-04-10 오후 3:40
 */
public interface StoreRepository extends JpaRepository<Store, Long> {
    List<Store> findAllByOffDayNotAndOpenTimeLessThanEqualAndCloseTimeGreaterThanEqual(Integer offDay, Integer openTime, Integer closeTime);
    List<Store> findAllByOffDayNot(Integer offDay);
}
