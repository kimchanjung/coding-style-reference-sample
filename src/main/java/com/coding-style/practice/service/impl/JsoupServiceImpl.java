package com.codingStyle.practice.service.impl;

import com.codingStyle.practice.dto.WebContentDto;
import com.codingStyle.practice.enums.ParsingTypes;
import com.codingStyle.practice.ex.HttpBadRequestException;
import com.codingStyle.practice.service.JsoupService;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by kimchanjung on 2020-10-27 오후 6:05
 * 크롤링 라이브러를 곧바로 사용하지 않고 서비로 한번 추상화하여
 * 결합도를 느슨하게 유지
 * (추후 테스트 수행시 Mock 객체사용을 용이하도록 하기위하여)
 */

@Service
public class JsoupServiceImpl implements JsoupService {

    @Override
    public WebContentDto parse(String url, ParsingTypes parsingTypes) {
        try {
            return WebContentDto.of(parsingTypes
                    .getText(Jsoup.connect(url)
                            .timeout(3000)
                            .execute()
                            .parse()));
        } catch (IllegalArgumentException e) {
            throw HttpBadRequestException.notFoundProtocol(e);
        } catch (HttpStatusException e) {
            throw HttpBadRequestException.badRequestException(e);
        } catch (IOException e) {
            throw HttpBadRequestException.notFoundSite(e);
        }
    }
}
