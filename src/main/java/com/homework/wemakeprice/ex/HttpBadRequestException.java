package com.homework.wemakeprice.ex;

/**
 * Created by kimchanjung on 2020-10-27 오후 2:01
 */

public class HttpBadRequestException extends RuntimeException {
    public HttpBadRequestException() {
        super();
    }
    public HttpBadRequestException(String msg) {
        super(msg);
    }
}
