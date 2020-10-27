package com.homework.wemakeprice.enums;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

import javax.print.Doc;
import java.util.function.Function;

/**
 * Created by kimchanjung on 2020-10-27 오후 4:53
 */

public enum ParsingTypes {
    WITHOUT_TAG("HTML_TAG_제외", Element::text),
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
