package com.homework.wemakeprice.dto;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by kimchanjung on 2020-10-28 오후 1:17
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WebContentDto {
    private String content;

    public static WebContentDto of(String content) {
        WebContentDto instance = new WebContentDto();
        instance.content = parse(content);
        return instance;
    }

    private static String parse(String content) {
        StringBuilder numeric = new StringBuilder();
        return rejoin(content.chars()
                .mapToObj(v -> String.valueOf((char) v))
                .sorted((a, b) -> a.toUpperCase().equals(b.toUpperCase()) ?
                        a.compareTo(b) :
                        a.toUpperCase().compareTo(b.toUpperCase()))
                .filter(v -> validChar(v, numeric))
                .collect(Collectors.joining("")), numeric);
    }

    private static boolean validChar(String v, StringBuilder numeric) {
        if (Character.isDigit(v.charAt(0))) numeric.append(v);
        return Character.getType(v.charAt(0)) == 2 || Character.getType(v.charAt(0)) == 1;
    }

    private static String rejoin(String alphabets, StringBuilder numeric) {
        StringBuilder rejoin = new StringBuilder();

        for (int i = 0; i < alphabets.length(); i++) {
            rejoin.append(alphabets.charAt(i));
            if (numeric.length() > i) {
                rejoin.append(numeric.charAt(i));
            }
        }

        return rejoin.toString();
    }
}
