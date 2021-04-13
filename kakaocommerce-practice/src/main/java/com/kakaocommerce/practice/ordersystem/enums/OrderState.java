package com.kakaocommerce.practice.ordersystem.enums;

/**
 * Created by kimchanjung on 2021-04-10 오후 1:38
 */
public enum OrderState {
    NEW("NEW"),
    COMPLETE("COMPLETE"),
    CANCEL("CANCEL");

    private final String desc;

    OrderState(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.name();
    }
}
