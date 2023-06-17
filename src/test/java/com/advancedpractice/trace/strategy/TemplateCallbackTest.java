package com.advancedpractice.trace.strategy;

import com.advancedpractice.trace.strategy.code.template.Callback;
import com.advancedpractice.trace.strategy.code.template.TimeLogTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateCallbackTest {

    @Test
    void callbackV1() {
        //given
        TimeLogTemplate template = new TimeLogTemplate();

        //when
        template.execute(new Callback() {
            @Override
            public void call() {
                log.info("비즈니스 로직1 실행");
            }
        });

        template.execute(new Callback() {
            @Override
            public void call() {
                log.info("비즈니스 로직2 실행");
            }
        });
        //then
    }

    @Test
    void callbackV2() {
        //given
        TimeLogTemplate template = new TimeLogTemplate();

        //when
        template.execute(() -> {
            log.info("비즈니스 로직1 실행");
        });

        template.execute(() -> {
            log.info("비즈니스 로직2 실행");
        });
        //then
    }


}
