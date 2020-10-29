package com.homework.wemakeprice.dto;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.stream.Collectors;

/**
 * Created by kimchanjung on 2020-10-28 오후 1:17
 * 크롤링한 내용을 파싱하기위한 객체
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WebContentDto {

    private String content;

    public static WebContentDto of(String content) {
        WebContentDto instance = new WebContentDto();
        instance.content = content;
        return instance;
    }

    /**
     * 크롤힝한 내용을 조건에 맞게 숫자와 알파벳만 남기고 정렬까지 처리한다.
     */
    public String parse() {
        StringBuilder numeric = new StringBuilder();
        return rejoin(content.chars()
                .mapToObj(v -> String.valueOf((char) v))
                .sorted((a, b) -> a.toUpperCase().equals(b.toUpperCase()) ?
                        a.compareTo(b) :
                        a.toUpperCase().compareTo(b.toUpperCase()))
                .filter(v -> validChar(v, numeric))
                .collect(Collectors.joining("")), numeric);
    }

    /**
     * 숫자와 알파벳만 남기도록 필터링
     * 추후 숫자와 알파벳을 분리하기 위하여 숫자의 마지막 인덱스를
     * 찾기위한 시간복잡도를 줄이기 위해 필터링과 동시에 숫자를 따로 저장해둠
     */
    private static boolean validChar(String v, StringBuilder numeric) {
        if (Character.isDigit(v.charAt(0))) numeric.append(v);
        int type = Character.getType(v.charAt(0));
        return type == 2 || type == 1;
    }

    /**
     * 알파벳 사이에 숫자를 삽입하고 제조합
     */
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
