package com.commerce.practice.ex;

/**
 * Created by kimchanjung on 2020-10-27 오후 2:01
 */

public class BadRequestException extends RuntimeException {

    public BadRequestException(String msg) {
        super(msg);
    }

    public static BadRequestException alreadyBookmarked(String message) {
        return new BadRequestException(message+" 은(는) 이미 북마크된 업소 입니다.");
    }

    public static BadRequestException badStatus(String message) {
        return new BadRequestException(message+" 로 변경할 수 없습니다.");
    }
    public static BadRequestException closed() {
        return new BadRequestException("업소운영시간이 아닙니다.");
    }
}
