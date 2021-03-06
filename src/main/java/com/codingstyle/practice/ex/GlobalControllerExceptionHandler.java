package com.codingstyle.practice.ex;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.stream.Collectors;

/**
 * Created by kimchanjung on 2020-10-27 오후 2:01
 * Hibernate validation의 처리에서 오류 메시지를
 * api응답에 code, message 두 프로퍼티에 담아 리턴 하도록
 * 처리함
 */

@Slf4j
@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler({
            HttpBadRequestException.class,
            MethodArgumentNotValidException.class,
            BindException.class
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessage handleBadRequest(Exception e) {

        Class<? extends Throwable> exClazz = e.getClass();

        if (exClazz.isAssignableFrom(MethodArgumentNotValidException.class)) {
            MethodArgumentNotValidException errorEx = (MethodArgumentNotValidException) e;
            return new ErrorMessage(
                    HttpStatus.BAD_REQUEST,
                    errorEx.getBindingResult()
                            .getFieldErrors().stream()
                            .map(v -> String.format("%s [%s]", v.getDefaultMessage(), v.getField()))
                            .collect(Collectors.joining(", ")));

        } else if (exClazz.isAssignableFrom(BindException.class)) {
            BindException bindEx = (BindException) e;
            String invalidColumns = bindEx.getBindingResult().getFieldErrors().stream()
                    .map(v -> String.format("%s", v.getField()))
                    .collect(Collectors.joining(","));

            String message = String.format("Invalid Parameters [%s]", invalidColumns);
            return new ErrorMessage(HttpStatus.BAD_REQUEST, message);
        }

        return new ErrorMessage(HttpStatus.BAD_REQUEST, e);
    }

    @Getter
    public static class ErrorMessage {
        private String code;
        private String message;

        public ErrorMessage(String codeName, String error) {
            log.error(codeName, error);
            this.code = codeName;
            this.message = error;
        }

        public ErrorMessage(HttpStatus httpStatus, String error) {
            this.code = httpStatus.name();
            this.message = error;
        }

        public ErrorMessage(HttpStatus httpStatus, String codeName, Exception error) {
            log.error(codeName, error);
            this.code = httpStatus.name();
            this.message = error.getMessage();
        }

        public ErrorMessage(HttpStatus httpStatus, Exception error) {
            log.error(httpStatus.getReasonPhrase(), error);
            this.code = httpStatus.name();
            this.message = error.getMessage();
        }

    }
}
