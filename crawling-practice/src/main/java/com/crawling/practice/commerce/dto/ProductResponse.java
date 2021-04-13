package com.crawling.practice.commerce.dto;

import com.crawling.practice.commerce.eums.ProductCategory;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createdDate;
    private Date lastModifiedDate;
}
