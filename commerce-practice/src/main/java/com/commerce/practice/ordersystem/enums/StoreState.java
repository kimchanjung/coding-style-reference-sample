package com.commerce.practice.ordersystem.enums;

/**
 * Created by kimchanjung on 2021-04-10 오후 1:20
 */
public enum StoreState {
    NORMAL("NORMAL"),
    HIDDEN("HIDDEN");

    private final String desc;

    StoreState(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.name();
    }
}
