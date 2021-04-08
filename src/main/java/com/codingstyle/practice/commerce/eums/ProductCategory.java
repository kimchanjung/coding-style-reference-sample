package com.codingstyle.practice.commerce.eums;

import lombok.Getter;

/**
 * Created by kimchanjung on 2021-04-08 오후 3:03
 */

@Getter
public enum ProductCategory {

    FOOD("음식", 1),
    FASHION("음식", 1),
    ELECTRONIC("음식", 1);

    private final String desc;
    private final Integer code;

    ProductCategory(String desc, Integer code) {
        this.desc = desc;
        this.code = code;
    }

    public String getDesc() {
        return this.name();
    }
}
