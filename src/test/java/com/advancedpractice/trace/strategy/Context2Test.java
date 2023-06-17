package com.advancedpractice.trace.strategy;

import com.advancedpractice.trace.strategy.code.strategy.ContextV2;
import com.advancedpractice.trace.strategy.code.strategy.Strategy;
import com.advancedpractice.trace.strategy.code.strategy.StrategyLogic1;
import com.advancedpractice.trace.strategy.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class Context2Test {

    @Test
    void strategyV1() {
        //given
        ContextV2 context = new ContextV2();
        //when
        context.execute(new StrategyLogic1());
        context.execute(new StrategyLogic2());
        //then
    }

    @Test
    void strategyV2() {
        //given
        ContextV2 context = new ContextV2();
        //when
        context.execute(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직1 실행");
            }
        });

        context.execute(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직2 실행");
            }
        });
        //then
    }

    @Test
    void strategyV3() {
        //given
        ContextV2 context = new ContextV2();
        //when
        context.execute(() -> log.info("비즈니스 로직1 실행"));
        context.execute(() -> log.info("비즈니스 로직2 실행"));
        //then
    }

}
