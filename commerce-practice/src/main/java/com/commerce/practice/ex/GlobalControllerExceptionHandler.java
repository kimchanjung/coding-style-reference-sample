package com.commerce.practice.ex;

import com.commerce.practice.utils.ResponseForm;
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
            Exception.class,
            BadRequestException.class,
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public <T> ResponseForm<T> handleBadRequest(Exception e) {
        return new ResponseForm<T>(HttpStatus.BAD_REQUEST, e);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public <T> ResponseForm<T> handleBadRequest(MethodArgumentNotValidException e) {
        return new ResponseForm<T>(HttpStatus.BAD_REQUEST, e.getBindingResult().getFieldErrors().stream()
                .map(v -> String.format("%s [%s]", v.getDefaultMessage(), v.getField()))
                .collect(Collectors.joining(", ")));
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public <T> ResponseForm<T> handleBadRequest(BindException e) {
        return new ResponseForm<T>(HttpStatus.BAD_REQUEST, String.format("Invalid Parameters [%s]",
                e.getBindingResult().getFieldErrors().stream()
                        .map(v -> String.format("%s", v.getField()))
                        .collect(Collectors.joining(","))));
    }

}
