package com.crawling.practice.ex;

import org.jsoup.HttpStatusException;

import java.io.IOException;

/**
 * Created by kimchanjung on 2020-10-27 오후 2:01
 */

public class BadRequestException extends RuntimeException {

    public BadRequestException(String msg) {
        super(msg);
    }

    public static BadRequestException notFoundProtocol(IllegalArgumentException e) {
        return new BadRequestException("http 프로토콜 까지 정확히 입력해주세요 [" + e.getCause() + "]");
    }

    public static BadRequestException badRequestException(HttpStatusException e) {
        return new BadRequestException("잘못 호출된 페이지 입니다. [" + e.getStatusCode() + "]");
    }

    public static BadRequestException notFoundSite(IOException e) {
        throw new BadRequestException("해당 사이트가 존재하지 않습니다.[" + e.toString() + "]");
    }
}
