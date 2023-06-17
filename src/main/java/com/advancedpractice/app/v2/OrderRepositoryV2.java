package com.advancedpractice.app.v2;

import com.advancedpractice.trace.TraceId;
import com.advancedpractice.trace.TraceStatus;
import com.advancedpractice.trace.hellotrace.HelloTraceV1;
import com.advancedpractice.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV2 {

    private final HelloTraceV2 trace;

    public void save(TraceId traceId, String itemId) {

        TraceStatus status = null;
        try {
            status = trace.beginSync(traceId, "OrderRepository.save()");

            if (itemId.equals("ex")) {
                throw new IllegalStateException("예외발생!");
            }

            sleep(1000);

            trace.end(status);

        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }

    private void sleep(int millis) {

        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
