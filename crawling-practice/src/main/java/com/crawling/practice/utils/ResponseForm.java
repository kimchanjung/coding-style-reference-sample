package com.crawling.practice.utils;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Created by kimchanjung on 2021-04-15 오후 1:45
 */
@Getter
public class ResponseForm<T> {
    private String status;
    private T data;
    private String message;

    private ResponseForm() {}

    public static <T> ResponseForm<T> ok(T data) {
        ResponseForm<T> instance = new ResponseForm<>();
        instance.status = HttpStatus.OK.name();
        instance.data = data;
        return instance;
    }

    public ResponseForm(HttpStatus httpStatus, Exception e) {
        this.status = httpStatus.name();
        this.message = e.getMessage();
    }

    public ResponseForm(HttpStatus httpStatus, String error) {
        this.status = httpStatus.name();
        this.message = error;
    }
}
