package com.advancedpractice.app.v5;

import com.advancedpractice.trace.callback.TraceTemplate;
import com.advancedpractice.trace.logtrace.LogTrace;
import com.advancedpractice.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV5 {

    private final OrderRepositoryV5 orderRepository;
    private final TraceTemplate template;

    public void orderItem(String itemId) {

        template.execute("OrderService.orderItem()", () -> {
            orderRepository.save(itemId);
            return null;
        });
    }


}
