package com.advancedpractice.trace.threadlocal.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalService {

    private ThreadLocal<String> nameStore = new ThreadLocal<>();

    public String logic(String name) {

        log.info("저장 name={} -> nameStore={}", name, nameStore.get()); // 쓰레드 로컬안에 있는 값 가져오기
        nameStore.set(name);
        sleep(1000);

        log.info("조회 nameStore={}", nameStore.get());
        return nameStore.get();

    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
