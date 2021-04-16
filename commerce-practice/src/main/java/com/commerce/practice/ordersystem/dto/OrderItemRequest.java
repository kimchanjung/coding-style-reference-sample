package com.commerce.practice.ordersystem.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Created by kimchanjung on 2021-04-10 오후 3:19
 */
@Getter
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderItemRequest {
    @NotBlank(message = "상품명을 입력해주세요.")
    private String name;
    @NotNull(message = "가격을 입력해주세요.")
    @Min(value = 100, message = "100원이상 입력해주세요.")
    private Integer unitPrice;
    @NotNull(message = "상품개수를 입력해주세요.")
    @Min(value = 1, message = "수량은 1개 이상 입력해주세요")
    private Integer unitCount;
}
