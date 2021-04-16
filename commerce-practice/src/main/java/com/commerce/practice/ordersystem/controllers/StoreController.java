package com.commerce.practice.ordersystem.controllers;

import com.commerce.practice.ordersystem.dto.StoreResponse;
import com.commerce.practice.ordersystem.services.StoreService;
import com.commerce.practice.ordersystem.utils.ResponseForm;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by kimchanjung on 2021-04-15 오전 11:27
 */
@RestController
@RequestMapping("/api/stores")
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseForm<List<StoreResponse>> findAll(@RequestParam(name = "time", required = false)
                                                         @DateTimeFormat(pattern = "yyyy-MM-dd kk:mm:ss")
                                                                 LocalDateTime time) {
        return ResponseForm.ok(storeService.findAllByTime(time == null ? LocalDateTime.now() : time));
    }
}
