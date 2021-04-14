package com.commerce.practice.ordersystem.enums;

/**
 * Created by kimchanjung on 2021-04-10 오후 1:38
 */
public enum OrderState {
    NEW("NEW", "CANCEL"),
    COMPLETE("COMPLETE", null),
    CANCEL("CANCEL",null);

    private final String desc;
    private final String  next;

    OrderState(String desc, String next) {
        this.desc = desc;
        this.next = next;
    }

    public String getDesc() {
        return this.name();
    }

    public boolean changeableState(OrderState state) {
        return this.next.equals(state.desc);
    }

}
