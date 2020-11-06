package com.codingStyle.practice.ex;

import org.jsoup.HttpStatusException;

import java.io.IOException;

/**
 * Created by kimchanjung on 2020-10-27 오후 2:01
 */

public class HttpBadRequestException extends RuntimeException {

    public HttpBadRequestException(String msg) {
        super(msg);
    }

    public static HttpBadRequestException notFoundProtocol(IllegalArgumentException e) {
        return new HttpBadRequestException("http 프로토콜 까지 정확히 입력해주세요 [" + e.getCause() + "]");
    }

    public static HttpBadRequestException badRequestException(HttpStatusException e) {
        return new HttpBadRequestException("잘못 호출된 페이지 입니다. [" + e.getStatusCode() + "]");
    }

    public static HttpBadRequestException notFoundSite(IOException e) {
        throw new HttpBadRequestException("해당 사이트가 존재하지 않습니다.[" + e.toString() + "]");
    }
}
