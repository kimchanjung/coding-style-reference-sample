package com.homework.wemakeprice.enums;

/**
 * Created by kimchanjung on 2020-10-27 오후 4:53
 */

public enum ParsingTypes {
    WITHOUT_TAG("HTML_TAG_제외"),
    TEXT_ALL("TEXT_전체");

    private final String desc;


    ParsingTypes(String desc) {
        this.desc = desc;
    }

    public String getCode() {
        return name();
    }

    public String getDesc() {
        return desc;
    }
}
