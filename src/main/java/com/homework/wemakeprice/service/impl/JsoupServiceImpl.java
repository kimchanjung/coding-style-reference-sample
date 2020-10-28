package com.homework.wemakeprice.service.impl;

import com.homework.wemakeprice.enums.ParsingTypes;
import com.homework.wemakeprice.ex.HttpBadRequestException;
import com.homework.wemakeprice.service.JsoupService;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by kimchanjung on 2020-10-27 오후 6:05
 */
@Slf4j
@Service
public class JsoupServiceImpl implements JsoupService {

    @Override
    public String parse(String url, ParsingTypes parsingTypes) {
        try {
            log.info("parsingTypes"+parsingTypes);
            Document parse = Jsoup.connect(url).timeout(3000).execute().parse();
            log.info("html = " +parsingTypes.getText(parse));
            return parsingTypes.getText(parse);
        } catch (HttpStatusException e) {
            throw new HttpBadRequestException("잘못 호출된 페이지 입니다. [" + e.getStatusCode() + "]");
        } catch (IOException e) {
            throw new HttpBadRequestException("해당 사이트가 존재하지 않습니다.[" + e.toString() + "]");
        }
    }
}
