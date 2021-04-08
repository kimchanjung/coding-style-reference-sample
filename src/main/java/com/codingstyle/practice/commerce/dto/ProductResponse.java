package com.codingstyle.practice.commerce.dto;

import com.codingstyle.practice.commerce.entity.Product;
import com.codingstyle.practice.commerce.eums.ProductCategory;
import lombok.*;

import java.util.Date;

/**
 * Created by kimchanjung on 2021-04-07 오후 6:10
 */

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductResponse {
    private Long id;
    private String name;
    private Integer price;
    private ProductCategory productCategory;
    private Date createdDate;
    private Date lastModifiedDate;
}
