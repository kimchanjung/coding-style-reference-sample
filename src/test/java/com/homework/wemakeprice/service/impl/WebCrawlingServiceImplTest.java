package com.homework.wemakeprice.service.impl;



import com.homework.wemakeprice.TestWeMakePriceConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by kimchanjung on 2020-10-27 오후 2:45
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestWeMakePriceConfiguration.class)
public class WebCrawlingServiceImplTest {

    @Test
    public void test() {
       log.info("test");
    }
}