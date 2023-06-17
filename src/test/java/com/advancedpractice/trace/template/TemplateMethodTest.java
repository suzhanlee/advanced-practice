package com.advancedpractice.trace.template;

import com.advancedpractice.trace.template.code.AbstractTemplate;
import com.advancedpractice.trace.template.code.SubClassLogic1;
import com.advancedpractice.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {

    @Test
    void templateMethodV0() {
        //given
        //when
        logic1();
        logic2();
        //then
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();

        log.info("비즈니스 로직1 실행");

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();

        log.info("비즈니스 로직2 실행");

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    @Test
    void templateMethodV1() {
        //given
        AbstractTemplate template1 = new SubClassLogic1();
        AbstractTemplate template2 = new SubClassLogic2();
        //when
        template1.execute();
        template2.execute();
        //then
    }

    @Test
    void templateMethodV2() {
        //given
        AbstractTemplate template1 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비즈니스 로직1 실행");
            }
        };

        AbstractTemplate template2 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비즈니스 로직2 실행");
            }
        };

        //when
        log.info("클래스 이름1={}", template1.getClass());
        template1.execute();

        log.info("클래스 이름2={}", template1.getClass());
        template2.execute();

        //then
    }




}
