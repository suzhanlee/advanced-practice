package com.advancedpractice.trace.strategy;

import com.advancedpractice.trace.strategy.code.strategy.ContextV1;
import com.advancedpractice.trace.strategy.code.strategy.Strategy;
import com.advancedpractice.trace.strategy.code.strategy.StrategyLogic1;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {

    @Test
    void strategyV0() {
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
    void strategyV1() {
        //given
        StrategyLogic1 strategyLogic1 = new StrategyLogic1();
        ContextV1 contextV1 = new ContextV1(strategyLogic1);

        //when
        contextV1.execute();
        //then
    }

    @Test
    void strategyV2() {
        //given
        Strategy strategyLogic1 = new Strategy() {

            @Override
            public void call() {
                log.info("비즈니스 로직1 실행");

            }
        };

        ContextV1 contextV1 = new ContextV1(strategyLogic1);

        Strategy strategyLogic2 = new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직2 실행");
            }
        };
        ContextV1 context2 = new ContextV1(strategyLogic2);

        //when
        log.info("strategyLogic1={}", strategyLogic1.getClass());
        contextV1.execute();

        log.info("strategyLogic2={}", strategyLogic2.getClass());
        context2.execute();
        //then
    }

    @Test
    void strategyV3() {
        //given
        ContextV1 context1 = new ContextV1(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직1 실행");
            }
        });

        ContextV1 context2 = new ContextV1(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직2 실행");
            }
        });

        //when
        context1.execute();
        context2.execute();
        //then
    }


    @Test
    void strategyV4() {
        //given
        ContextV1 context1 = new ContextV1(() -> log.info("비즈니스 로직1 실행"));
        ContextV1 context2 = new ContextV1(() -> log.info("비즈니스 로직2 실행"));
        //when
        context1.execute();
        context2.execute();
        //then
    }

}
