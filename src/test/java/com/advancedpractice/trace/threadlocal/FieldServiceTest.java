package com.advancedpractice.trace.threadlocal;

import com.advancedpractice.trace.threadlocal.code.FieldService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class FieldServiceTest {

    private FieldService fieldService = new FieldService();

    @Test
    void field() {
        //given
        log.info("main start");
        Runnable userA = new Runnable() {
            @Override
            public void run() {
                fieldService.logic("userA");
            }
        };

        Runnable userB = new Runnable() {
            @Override
            public void run() {
                fieldService.logic("userB");
            }
        };

        Thread threadA = new Thread(userA);
        Thread threadB = new Thread(userB);
        threadA.setName("thread-A");
        threadB.setName("thread-B");

        //when
        threadA.start();

        sleep(100);

        threadB.start();

        sleep(3000);
        log.info("main exit");
        //then
    }

    private void sleep(int millis) {

        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }


}
