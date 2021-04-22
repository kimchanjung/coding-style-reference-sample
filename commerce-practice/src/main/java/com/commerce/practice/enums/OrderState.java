package com.commerce.practice.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kimchanjung on 2021-04-10 오후 1:38
 */
public enum OrderState {
    NEW("NEW", Arrays.asList("CANCEL", "COMPLETE")),
    COMPLETE("COMPLETE", new ArrayList<>()),
    CANCEL("CANCEL", new ArrayList<>());

    private final String desc;
    private final List<String> next;

    OrderState(String desc, List<String> next) {
        this.desc = desc;
        this.next = next;
    }

    public String getDesc() {
        return this.name();
    }

    public boolean stateChangeable(OrderState state) {
        return !this.next.contains(state.desc);
    }
}
