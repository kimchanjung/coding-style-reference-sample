package com.commerce.practice.ordersystem.dto;

import com.commerce.practice.ordersystem.entity.BookmarkedStore;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Created by kimchanjung on 2021-04-10 오후 2:46
 */
@Getter
@Builder
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookmarkedStoreResponse {
    private Long id;
    private boolean open;
    private StoreResponse store;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
}
