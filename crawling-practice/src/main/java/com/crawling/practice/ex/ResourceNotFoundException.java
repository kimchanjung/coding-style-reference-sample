package com.crawling.practice.ex;

import static java.lang.String.format;

/**
 * Created by kimchanjung on 2021-04-08 오후 7:30
 */
public class ResourceNotFoundException extends RuntimeException {
    private ResourceNotFoundException(String msg) {
        super(msg);
    }

    public static ResourceNotFoundException notFound(String name) {
        return new ResourceNotFoundException(format("(%s) 정보를 찾을 수 없습니다", name));
    }
}
