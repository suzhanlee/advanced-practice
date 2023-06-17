package com.advancedpractice.trace.hellotrace;

import com.advancedpractice.trace.TraceStatus;
import org.junit.jupiter.api.Test;

public class HelloTraceV1Test {

    @Test
    void begin_end() {
        //given
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("hello");

        //when
        trace.end(status);

        //then
    }

    @Test
    void begin_exception() {
        //given
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("hello");

        //when
        trace.exception(status, new IllegalStateException());

        //then
    }

}
