package com.advancedpractice;

import com.advancedpractice.trace.logtrace.LogTrace;
import com.advancedpractice.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace LogTrace() {

        return new ThreadLocalLogTrace();
    }
}
