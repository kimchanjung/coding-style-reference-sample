package com.commerce.practice.ordersystem.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * Created by kimchanjung on 2021-04-15 오후 2:15
 */
@Getter
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CancelOrderRequest {
    @NotBlank(message = "취소사유를 입력해주세요.")
    private String message;
}
