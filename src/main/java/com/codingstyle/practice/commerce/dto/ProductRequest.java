package com.codingstyle.practice.commerce.dto;

import com.codingstyle.practice.commerce.eums.ProductCategory;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Created by kimchanjung on 2021-04-07 오후 6:10
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductRequest {

    @NotBlank(message = "상품명을 입력해주세요.")
    private String name;

    @NotNull(message = "가격을 입력해주세")
    @Min(value = 100, message = "100원이상 입력해주세요.")
    private Integer price;

    @NotNull(message = "상품종류를 선택해주세요.")
    private ProductCategory productCategory;

    public static ProductRequest of(String name, Integer price, ProductCategory productCategory) {
        ProductRequest instance = new ProductRequest();
        instance.name = name;
        instance.price = price;
        instance.productCategory = productCategory;
        return instance;
    }
}
