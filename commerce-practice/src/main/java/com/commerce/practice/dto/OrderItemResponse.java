package com.commerce.practice.dto;

import lombok.*;

/**
 * Created by kimchanjung on 2021-04-10 오후 2:50
 */
@Getter
@Builder
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderItemResponse {
    private Long id;
    private String name;
    private Integer unitPrice;
    private Integer unitCount;
}
