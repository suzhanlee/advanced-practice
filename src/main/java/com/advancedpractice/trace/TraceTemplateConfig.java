package com.advancedpractice.trace;

import com.advancedpractice.trace.callback.TraceTemplate;
import com.advancedpractice.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TraceTemplateConfig {

    @Bean
    public TraceTemplate traceTemplate(LogTrace trace) {
        return new TraceTemplate(trace);
    }

}
