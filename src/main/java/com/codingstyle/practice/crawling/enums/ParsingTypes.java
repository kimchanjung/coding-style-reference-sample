package com.codingstyle.practice.crawling.enums;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

import java.util.function.Function;

/**
 * Created by kimchanjung on 2020-10-27 오후 4:53
 * 파싱타입(HTML제거 또는 포함)을 선언하고
 * 비즈니스 로직에서 파싱타입에 따른 if 분기를 제거하기 위하여
 * 해당타입에 맞는 람다함수를 선언하여 수행되도록 처리함
 */

public enum ParsingTypes {
    // Jsoup 라이브러이에서 html 제거하는 메소드를 호출
    WITHOUT_TAG("HTML_TAG_제외", Element::text),
    // Jsoup 라이브러리에서 가져온 내용을 그대로 스트링으로 반환
    TEXT_ALL("TEXT_전체", Node::toString);

    private final String desc;
    private final Function<Document, String> expression;

    ParsingTypes(String desc, Function<Document, String> expression) {
        this.desc = desc;
        this.expression = expression;
    }

    public String getCode() {
        return name();
    }

    public String getDesc() {
        return desc;
    }

    public String getText(Document doc) {
        return expression.apply(doc);
    }
}
