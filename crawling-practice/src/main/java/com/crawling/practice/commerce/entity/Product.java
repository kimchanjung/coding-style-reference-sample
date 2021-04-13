package com.crawling.practice.commerce.entity;

import com.crawling.practice.commerce.eums.ProductCategory;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by kimchanjung on 2021-04-07 오후 5:18
 */

@Getter
@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 엔티티는 기본생성자가 필요한데 public으로 완전 오픈보다 PROTECTED 정도로 제한을 둔다
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private ProductCategory productCategory;

    @Temporal(TemporalType.TIMESTAMP)
    private final Date createdDate = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private final Date lastModifiedDate = new Date();

}
